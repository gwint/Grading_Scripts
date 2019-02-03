import os
import sys
import subprocess
import csv
from argparse import ArgumentParser
from html.parser import HTMLParser

STUDENT_INFO_FILE = "students.csv"
A51_FILE = "a51_roster.csv"
A52_FILE = "a52_roster.csv"
A53_FILE = "a53_roster.csv"
A54_FILE = "a54_roster.csv"

NAME_IDX = 0
COMMENT_IDX = 9
NO_ENTRY_MESSAGE = \
        "There is no student submission text data for this assignment."

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

  name_to_info_mapping = get_student_info()

  parser = ArgumentParser()
  parser.add_argument("assn_name", type=str, nargs=1)
  parser.add_argument("update_files", type=str, nargs= '+')

  students_of_interest = []
  args = parser.parse_args()

  assn_name = args.assn_name
  update_files = args.update_files

  ## TODO: Add more roster files
  students_of_interest += get_roster(A54_FILE)

  num_repos_updated = 0

  for student_name in students_of_interest:
    bID = name_to_info_mapping[student_name][0]
    gitusername = name_to_info_mapping[student_name][1]
    if(name_to_info_mapping[student_name][1] != "NA"):
        retVal = os.system(f'git clone https://github.com/binghamtonuniversity-cs240/{sys.argv[1]}-spr18-{gitusername.strip()}.git')
        #if the repo doesn't exist, continue
        if(retVal != 0):
        	continue
        for file in update_files:
        	os.system(f'cp {file} {sys.argv[1]}-spr18-{gitusername.strip()}')

        dirName = sys.argv[1] + "-spr18-" + gitusername.replace("\n", "")
        os.system(f"cd {dirName}")
        os.system("git add -A")
        #p = subprocess.Popen(["git", "add",  "-A"],\
        #                     cwd = sys.argv[1] + "-spr18-" +\
        #                         gitusername.replace("\n", ""),\
        #                     shell=True)
        #p.wait()
        os.system('git commit -m "updating the update"')
        #p = subprocess.Popen(["git", "commit", "-m" ,"updating files"],\
        #                     cwd = sys.argv[1] + "-spr18-" +\
        #                         gitusername.replace("\n", ""),\
        #                     shell=True)
        #p.wait()
        os.system("git push")
        #p = subprocess.Popen(["git", "push"],\
        #                     cwd = sys.argv[1] + "-spr18-" + \
        #                         gitusername.replace("\n", ""),\
        #                     shell=True)
        num_repos_updated += 1
        #p.wait()
        #os.system("rm -rf " + sys.argv[1] + "-spr18-" + gitusername.replace("\n", ""))
    else:
      students_wo_githubs.append(student_name)

  print(f'Successfully updated repos of {num_repos_updated} students out of a possible {len(students_of_interest)}.')
  print(f'{len(students_wo_githubs)} have no github username on file.')
  print(students_wo_githubs)

main()
