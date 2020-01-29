import os
import sys
import subprocess
import csv
from argparse import ArgumentParser
from html.parser import HTMLParser

COMMIT_HASHS_DIR = "/home/gregory/Downloads/gradebook_10385.202020_lab01_2020-01-26-21-22-56" ## maps student name to commit hash
                                ## (only of people who submitted)
STUDENT_INFO_FILE = "studentGithubUsernames.csv"
NAME_IDX = 0
HASH_IDX = 6
COMMENT_IDX = 9
NO_ENTRY_MESSAGE = \
        "There is no student submission text data for this assignment."
A51_ROSTER = "a51_roster.csv"
A52_ROSTER = "a52_roster.csv"
A53_ROSTER = "a53_roster.csv"
A54_ROSTER = "a54_roster.csv"
FULL_ROSTER = "full_roster.csv"

def get_roster(roster_file):
  roster = []
  roster_file_obj = open(roster_file, 'r')
  line = roster_file_obj.readline()
  while(line):
    pieces = line.split(',')
    name = f'{pieces[1].strip()} {pieces[0].strip()}'
    roster.append(name)
    line = roster_file_obj.readline()
  roster_file_obj.close()

  return roster

def get_name_to_hash_mapping():
  name_to_hash_mapping = {}
  for filename in os.listdir(COMMIT_HASHS_DIR):
    commit_file_obj = open(f'{COMMIT_HASHS_DIR}/{filename}', 'r')
    lines = commit_file_obj.readlines()
    name = lines[0].strip().split("Name:")[1].strip().split('(')[0].strip()

    class HashParser(HTMLParser):
      def __init__(self):
        self._hash = ""
        HTMLParser.__init__(self)

      def handle_data(self, data):
        if(data.strip()):
          self._hash = data.strip()

      def get_hash(self):
        return self._hash

    parser = HashParser()
    parser.feed(lines[HASH_IDX])

    hash = parser.get_hash()

    if(hash == NO_ENTRY_MESSAGE):
      hash = lines[COMMENT_IDX].strip()

    name_to_hash_mapping[name] = hash
    commit_file_obj.close()

  return name_to_hash_mapping

def get_student_info():
  name_to_info_mapping = {}
  with open(STUDENT_INFO_FILE, 'r') as csv_file:
    csv_reader = csv.reader(csv_file)
    for row in (csv_reader):
      student_name = row[0]
      student_id = row[1]
      github_username = row[2]

      name_to_info_mapping[student_name] = [student_id, github_username]

  return name_to_info_mapping

#make a directory names after the assignment
#for each student, go through clone their repositories
def main():
  students_wo_githubs = []
  students_wo_commit_hash = []

  name_to_info_mapping = get_student_info()
  name_to_hash_mapping = get_name_to_hash_mapping()

  parser = ArgumentParser()
  parser.add_argument("assn_name", type=str, nargs=1)
  parser.add_argument("-a51", action="store_true")
  parser.add_argument("-a52", action="store_true")
  parser.add_argument("-a53", action="store_true")
  parser.add_argument("-a54", action="store_true")
  parser.add_argument("-full", action="store_true")

  students_of_interest = []
  args = parser.parse_args()

  assn_name = args.assn_name

  if(args.a51):
    students_of_interest += get_roster(A51_ROSTER)
  if(args.a52):
    students_of_interest += get_roster(A52_ROSTER)
  if(args.a53):
    students_of_interest += get_roster(A53_ROSTER)
  if(args.a54):
    students_of_interest += get_roster(A54_ROSTER)
  if(args.full):
    students_of_interest += get_roster(FULL_ROSTER)

  os.system("mkdir " + sys.argv[1])
  num_repos_cloned = 0
  error = []

  for student_name in students_of_interest:
    #print(name_to_info_mapping)
    bID = ""
    gitusername = ""
    try:
        bID = name_to_info_mapping[student_name][0]
        gitusername = name_to_info_mapping[student_name][1]
    except:
        continue

    if(name_to_info_mapping[student_name][1] != "NA"):
        os.system("echo -------------" + student_name + "---------------------")
        x = os.system(f'git clone https://github.com/Binghamton-CS140-A0-Spring-2019/sem202020-{sys.argv[1]}-{gitusername.strip()}.git')
        if x != 0:
        	error.append(student_name + " " + bID)
        	continue
        p = subprocess.Popen(["mkdir", bID])
        p.wait()
        p = subprocess.Popen(["mv", "sem202020-" + sys.argv[1] + "-" + gitusername.strip(), bID])
        p.wait()
        p = subprocess.Popen(["mv", bID, sys.argv[1]])
        p.wait()

        ##now we want to ensure we get the commit that the student wants graded
        #p = subprocess.Popen(["git", "checkout",\
                         #    name_to_hash_mapping[student_name]],\
                         #    cwd = sys.argv[1] + os.sep + bID +\
                          #       os.sep + sys.argv[1] + "-" +\
                         #        gitusername.replace("\n", ""),\
                        #     shell=True)
        num_repos_cloned += 1
        p.wait()
      #else:
       # students_wo_commit_hash.append(student_name + " " + bID)
    else:
      students_wo_githubs.append(student_name)

  print(f'Successfully cloned repos from {num_repos_cloned} students out of a possible {len(students_of_interest)}.')
  print(f'{len(error)} users had errors occur.')
  print(error)
  errors = open(sys.argv[1] + "_errors.txt", 'w')
  for name in error:
    errors.write(name + "\n")
  errors.close()
  print(f'{len(students_wo_commit_hash)} have no commit hash on file.')
  print(students_wo_commit_hash)
  hash = open(sys.argv[1] + "_noHash.txt", 'w')
  for name in students_wo_commit_hash:
    hash.write(name + "\n")
  hash.close()

main()
