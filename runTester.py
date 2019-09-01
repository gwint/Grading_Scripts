import os
import csv

assignment_name = "lab-01"
package_name = "lab01"
tester_file_path = "/home/mllab/Desktop/CS140/Grading_Scripts/Testers/Labs/Lab01_Grader.java"

path_to_submissions = "/home/mllab/Desktop/CS140/Grading_Scripts/" + assignment_name + '/'
STUDENT_INFO_FILE = "studentGithubUsernames.csv"

#Get just the tester name, without the .java extension
tester_file_name = tester_file_path.split('/')[-1]
tester_file_name = tester_file_name[:-5] #Remove .java


def get_student_info():
  name_to_info_mapping = {}
  id_to_name = {}
  with open(STUDENT_INFO_FILE, 'r') as csv_file:
    csv_reader = csv.reader(csv_file)
    for row in (csv_reader):
      student_name = row[0]
      student_id = row[1]
      github_username = row[2]

      name_to_info_mapping[student_id] = github_username
      id_to_name[student_id] = student_name

  return name_to_info_mapping, id_to_name


#Get name of all student folders
student_folders = [name for name in os.listdir(path_to_submissions)]
print("Grading", len(student_folders), "Assignments")

#Map student id to github id
id_to_github, id_to_name = get_student_info()

#Make report.txt file
f = open(path_to_submissions+"report.txt",'w')
f.close()

#Run tester for each folder
for student in student_folders:

	#Append student name to report.txt
	f = open(path_to_submissions+"report.txt",'a')
	f.write('\n\n' + id_to_name[student] + '\n')
	f.close()

	#Get path to particular students code
	path_to_code = path_to_submissions+student+'/'+assignment_name+'-'+id_to_github[student]+'/'

	#Copy tester file to students code
	os.system("cp " + tester_file_path + ' ' + path_to_code)

	#compile (including tester)
	os.system("javac -d . "+path_to_code+"*.java")

	#Run tester. The tester appends the grade and errors to report.txt
	os.system("java "+package_name+'.'+tester_file_name)

