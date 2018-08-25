import csv

GITHUB_INFO_FILE = "student_githubs.txt"
OTHER_INFO_FILE = "student_info.csv"
NEW_STUDENT_INFO_FILE = "students.csv"

def get_name_to_id_mapping():
  name_to_id_mapping = {}
  with open(OTHER_INFO_FILE, 'r') as csv_file:
    csv_reader = csv.reader(csv_file)
    for row in (csv_reader):
      first_name = row[0]
      last_name = row[1]
      id = row[2]
      name_to_id_mapping["%s %s" % (first_name, last_name)] = [id]

  return name_to_id_mapping

def get_id_to_github_uname_mapping():
  id_to_username_mapping = {}

  with open(GITHUB_INFO_FILE, 'r') as github_info_file_obj:
    line = github_info_file_obj.readline()
    while(line):
      id_and_username = line.split()
      id_to_username_mapping[id_and_username[0]] = id_and_username[1]
      line = github_info_file_obj.readline()

  return id_to_username_mapping

def main():
  github_file_obj = open(GITHUB_INFO_FILE, 'r')
  other_info_file_obj = open(OTHER_INFO_FILE, 'r')

  name_to_id_mapping = get_name_to_id_mapping()
  id_to_username_mapping = get_id_to_github_uname_mapping()

  for student_name in name_to_id_mapping.keys():
    github_username = "NA"

    if(name_to_id_mapping[student_name][0] in id_to_username_mapping.keys()):
      github_username =\
             id_to_username_mapping[name_to_id_mapping[student_name][0]]

    name_to_id_mapping[student_name].append(github_username)

  other_info_file_obj.close()
  github_file_obj.close()

  print(name_to_id_mapping)

  new_student_info_file_obj = open(NEW_STUDENT_INFO_FILE, 'w')

  for student_name in name_to_id_mapping.keys():
    student_id = name_to_id_mapping[student_name][0]
    github_username = name_to_id_mapping[student_name][1]
    new_student_info_file_obj.write(f'{student_name},{student_id},{github_username}\n')

  new_student_info_file_obj.close()

main()
