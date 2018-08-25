import os
import sys
import subprocess
import csv
from argparse import ArgumentParser

#each line will have the students binghamton ID first, followed by their git username. 
#separated by a single space.

COMMIT_HASHS_DIR = "hash_files" ## maps student name to commit hash
                                ## (only of people who submitted)
STUDENT_INFO_FILE = "students.csv" ## maps id to student name
NAME_IDX = 0
HASH_IDX = 6
NO_ENTRY_MESSAGE = \
        "There is no student submission text data for this assignment."
A51_ROSTER = "a51_roster.csv"
A52_ROSTER = "a52_roster.csv"
A53_ROSTER = "a53_roster.csv"
A54_ROSTER = "a54_roster.csv"

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
    hash = lines[HASH_IDX].replace("<p>", "")\
                          .replace('</p>\n', "")\
                          .replace('</pre>', "")\
                          .replace('<pre style="width: 1.0px;height: 1.0px;top: 5.0px;">', "")\
                          .replace('</span></span>', "").strip()

    if(hash == NO_ENTRY_MESSAGE):
      hash = lines[9].strip()

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

  os.system("mkdir " + sys.argv[1])
  num_repos_cloned = 0

  for student_name in students_of_interest:
    bID = name_to_info_mapping[student_name][0]
    gitusername = name_to_info_mapping[student_name][1]
    if(name_to_info_mapping[student_name][1] != "NA"):
      if(student_name in name_to_hash_mapping.keys()):
        os.system("git clone " + "https://github.com/Binghamton-CS140-A0-Fall-2018/" + sys.argv[1] + "-" + gitusername.replace("\n", "") + ".git")
        os.system("mkdir " + bID)
        os.system("mv " + sys.argv[1] + "-" + gitusername.replace("\n", "") + " " + bID)
        os.system("mv " + bID + " " + sys.argv[1])

        # #now we want to ensure we get the commit that the student wants graded
        p = subprocess.Popen(["git checkout",\
                             name_to_hash_mapping[student_name]],\
                             cwd = sys.argv[1] + os.sep + bID +\
                                 os.sep + sys.argv[1] + "-" +\
                                 gitusername.replace("\n", ""),\
                             shell=True)
        num_repos_cloned += 1
        p.wait()
      else:
        students_wo_commit_hash.append(student_name)
    else:
      students_wo_githubs.append(student_name)


  print(f'Successfully cloned repos from {num_repos_cloned} students out of a possible {len(students_of_interest)}.')
  print(f'{len(students_wo_githubs)} have no github username on file.')
  print(students_wo_githubs)
  print(f'{len(students_wo_commit_hash)} have no commit hash on file.')
  print(students_wo_commit_hash)

main()
