import os
import sys
import subprocess
import csv

#each line will have the students binghamton ID first, followed by their git username. 
#separated by a single space.

GITHUB_INFO_FILE = "student_githubs.txt" ## maps id to github username
COMMIT_HASHS_DIR = "hash_files" ## maps student name to commit hash
                                ## (only of people who submitted)
STUDENT_INFO_FILE = "student_info.csv" ## maps id to student name
NAME_IDX = 0
HASH_IDX = 6
NO_ENTRY_MESSAGE = \
        "There is no student submission text data for this assignment."

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


def get_id_to_name_mapping():
  id_to_name_mapping = {}
  with open(STUDENT_INFO_FILE, 'r') as csv_file:
    csv_reader = csv.reader(csv_file)
    for row in (csv_reader):
      first_name = row[0]
      last_name = row[1]
      id = row[2]
      id_to_name_mapping[id] = "%s %s" % (first_name, last_name)

  return id_to_name_mapping


def get_id_to_github_uname_mapping():
  id_to_username_mapping = {}

  with open(GITHUB_INFO_FILE, 'r') as github_info_file_obj:
    line = github_info_file_obj.readline()
    while(line):
      id_and_username = line.split()
      id_to_username_mapping[id_and_username[0]] = id_and_username[1]
      line = github_info_file_obj.readline()

  return id_to_username_mapping

#make a directory names after the assignment
#for each student, go through clone their repositories
def main():
  if len(sys.argv) != 2:
    print("Usage: python uzip.py [assignment name]")
    exit(0)

  students_wo_githubs = []
  students_wo_commit_hash = []

  id_to_name_mapping = get_id_to_name_mapping()
  id_to_username_mapping = get_id_to_github_uname_mapping()
  name_to_hash_mapping = get_name_to_hash_mapping()

  assert len(id_to_name_mapping) == 77
  assert len(id_to_username_mapping) == 65
  assert len(name_to_hash_mapping) == 68

  os.system("mkdir " + sys.argv[1])
  num_repos_cloned = 0
  for bID in id_to_name_mapping.keys():
    if(bID in id_to_username_mapping.keys()):
      gitusername = id_to_username_mapping[bID]
      student_name = id_to_name_mapping[bID]
      if(student_name in name_to_hash_mapping.keys()):
        os.system("git clone " + "https://github.com/Binghamton-CS140-A0-Fall-2018/" + sys.argv[1] + "-" + gitusername.replace("\n", "") + ".git")
        os.system("mkdir " + bID)
        os.system("mv " + sys.argv[1] + "-" + gitusername.replace("\n", "") + " " + bID)
        os.system("mv " + bID + " " + sys.argv[1])

        # #now we want to ensure we get the commit that the student wants graded
        p = subprocess.Popen(["git checkout", name_to_hash_mapping[id_to_name_mapping[bID]] ], cwd= sys.argv[1] + os.sep + bID + os.sep + sys.argv[1] + "-" + gitusername.replace("\n", ""), shell=True)
        num_repos_cloned += 1
        #p.wait()
      else:
        students_wo_commit_hash.append(bID)
    else:
      students_wo_githubs.append(bID)

  print(f'Successfully cloned repos from {num_repos_cloned} students out of a possible {len(id_to_name_mapping)}.')
  print(f'{len(students_wo_githubs)} have no github username on file.')
  print(students_wo_githubs)
  print(f'{len(students_wo_commit_hash)} have no commit hash on file.')
  print(students_wo_commit_hash)

main()
