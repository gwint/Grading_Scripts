import os
import csv

#assignment_name = "Lab05"
package_name = "lab05"
tester_file_path = "/home/mllab/Desktop/CS140/Grading_Scripts/Testers/Labs/Lab05_Grader.java"

path_to_submissions = "/home/mllab/Desktop/CS140/Grading_Scripts/Lab05/"
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
student_folders.sort()
print("Grading", len(student_folders), "Assignments")


#Map student id to github id
id_to_github, id_to_name = get_student_info()


#Run tester for each folder
for student in student_folders:

	if(student != 'report.txt'):

		f = open(path_to_submissions+"report.txt",'a')

		#Append student name to report.txt
		print(student)
		f.write('\n\n' + id_to_name[student] + '\n')

		#Get path to particular students code
		path_to_code = path_to_submissions+student+'/'+package_name+'-'+id_to_github[student]+'/'

		print(path_to_code)
		#Copy tester file to students code
		call1 = os.system("cp " + tester_file_path + ' ' + path_to_code)

		if(call1 != 0):
			f.write("Failed to copy over tester, this message should never appear!!\n")

		#compile (including tester)
		#javac -cp /usr/share/java/junit4.jar TestBasicLinkedList.java
		#call2 = os.system("javac -cp .:/usr/share/java/junit4-4.12.jar -d . "+path_to_code+"*.java")		
		call2 = os.system("javac -d . "+path_to_code+"*.java")

		if(call2 != 0):
			f.write("FAILED TO COMPILE. IGNORE GIVEN GRADE AND CHECK MANUALLY\n")
			f.close()
		else:

			#Let grader take file during runtime
			f.close()

			#Run tester. The tester appends the grade and errors to report.txt
			#We don't need to point to students folder to run, as .class files
			#are saved directly to Grading_Scripts/

			#java -cp .:/usr/share/java/junit4-4.12.jar 
			#call3 = os.system("java -cp .:/usr/share/java/junit4-4.12.jar "+package_name+'.'+tester_file_name)
			call3 = os.system("java "+package_name+'.'+tester_file_name)

			if(call3 != 0):
				f = open(path_to_submissions+"report.txt",'a')
				f.write("RUNTIME ERROR!! Check manually unless the tester catches this\n")
				f.close()

			#Now remove .class files to ensure next student is fresh compile
			call4 = os.system("rm -r " + package_name + '/')
			if(call4 != 0):
				f = open(path_to_submissions+"report.txt",'a')
				f.write("Failed to remove .class files. This should never appear.\n")
				f.close()

