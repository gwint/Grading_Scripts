import os
import csv
import sys

STUDENT_INFO_FILE = "studentGithubUsernames.csv"

submissions_folder_name = sys.argv[1]
package_name = submissions_folder_name
tester_file_path = sys.argv[2]
path_to_submissions = \
           f'/home/gregory/Grading_Scripts/{submissions_folder_name}/'

#Get just the tester name, without the .java extension
tester_file_name = tester_file_path.split('/')[-1]
tester_file_name = tester_file_name.replace(".java", "") #Remove .java

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

    return (name_to_info_mapping, id_to_name)

#Get name of all student folders
student_folders = [name for name in os.listdir(path_to_submissions)]
student_folders.sort()
print("Grading", len(student_folders), "Assignments")

#Map student id to github id
id_to_github, id_to_name = get_student_info()

#Run tester for each folder
for student in student_folders:
	if(student != 'report.txt'):

		f = open(path_to_submissions + "report.txt", 'a')

		#Append student name to report.txt
		print(student)
		try:
			f.write('\n\n' + id_to_name[student] + '\n')
		except:
			continue

		#Get path to particular students code
		github_username = id_to_github[student]
		path_to_code = \
		  path_to_submissions+student+'/'+f'sem202020-lab01-{github_username}/'
		print(f'Path to Code: {path_to_code}')

		#Copy tester file to students code
		call1 = os.system("cp " + tester_file_path + ' ' + path_to_code)

		if(call1 != 0):
			f.write("Failed to copy over tester, this message should never appear!!\n")

		#Add temp file to student directory (to grade number of junits passed)
		call11 = os.system('touch temp.txt')
		if(call11 != 0):
			f.write("Failed to add temp.txt, this message should never appear!!\n")

		#compile (including tester)
		compilationCmd = f'javac -d . {path_to_code}*.java -cp .:/home/gregory/Downloads/junit-platform-console-standalone-1.5.0.jar:/home/gregory/Downloads/opentest4j-1.0.0-M1.jar:/home/gregory/gradingplatform.jar'
		print(f'compilation command: {compilationCmd}')
		call2 = os.system(compilationCmd)

		if(call2 != 0):
			f.write("FAILED TO COMPILE. IGNORE GIVEN GRADE AND CHECK MANUALLY\n")
			f.close()
		else:
			#Let grader take file during runtime
			f.close()

			#Run tester. The tester appends the grade and errors to report.txt
			#We don't need to point to students folder to run, as .class files
			#are saved directly to Grading_Scripts/
			runCmd = f'java -jar /home/gregory/Downloads/junit-platform-console-standalone-1.5.0.jar --class-path .:./{package_name}:/home/gregory/gradingplatform.jar --scan-class-path > temp.txt'
			print(f'Run Command: {runCmd}')
			call3 = os.system(runCmd)

			#For junit, add number PASSED tokens in temp file with FAILED tokens for grade
			f = open('temp.txt', 'r')
			results = f.read()
			'''
			results = f.read().split(' ')
			f.close()
			num_passed = 0
			num_failed = 0
			for token in results:
				if(token == "PASSED"):
					num_passed += 1
				if(token == "FAILED"):
					num_failed += 1
			'''
			f = open(path_to_submissions+"report.txt", 'a')
			f.write(results + '\n')
			#f.write("Grade: " + str(num_passed/(num_passed+num_failed)) + '\n')
			f.close()

			call34 = os.system('rm temp.txt')
			if(call34 != 0):
				print("Failed to remove temp.txt")

			#Now remove .class files to ensure next student is fresh compile
			#call4 = os.system("rm -r " + package_name + '/')
			#if(call4 != 0):
			#	f = open(path_to_submissions + "report.txt", 'a')
			#	f.write("Failed to remove .class files. This should never appear.\n")
			#	f.close()

	#break
