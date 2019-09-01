The repository contains scripts and files that help ease the grading process.

## clone.py - Automated cloning of student repositories

Dependencies: Python >= 3.6, [pydotenv](https://pypi.org/project/pydotenv/)

How to Clone:
1) Head over to MyCourses and download the commit hashes for the assignment
   of interest.
2) Once it has been extracted, point the "COMMIT_HASHES_FOLDER_PATH" value
   from the .env file to this folder.
3) Run the following command, using values that make sense for you: python3 clone.py <\assignment name> [-a51] [-a52] [-a53] [-a54]

A directory named <\assignment name> will be created and all student
repositories for assignment <\assignment name> will be cloned into it.
The particular commit checked out for each cloned repository will depend on
the commit hash submitted to MyCourses by the student.


Steps to grade an assignment:

1. Clone ALL assignments into some folder folder_name (can be any name)

2. Write rubric, add in rubrics/assignments or rubrics/labs folder

3. Write tester, add in Testers/Assignments or Testers/Labs folder.
	
	- In your tester, make sure to append errors and final grade 
	of student to ../Grading_Scripts/folder_name/report.txt
	- See Grading_Scripts/Testers/Labs/Lab01_Grader.java for an example

4. Change the following in runTester.py:

	- assignment_name must be folder_name
	- package_name must be name of package that students wrote code in
	- tester_file_path must be path where tester is located


5. Run python3 runTester.py. Results for each student, along with your tester error messages will appear in report.txt, located in folder_name


