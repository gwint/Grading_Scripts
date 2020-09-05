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

## runTester.py - Automated JUnit testing for each student

1. Clone ALL assignments into some folder XXXX

2. Write rubric, add in rubrics/assignments or rubrics/labs folder

3. Write tester, add in Testers/Assignments or Testers/Labs folder.

	- See Testers/Assignments/Assignment01Tester.java for an example. Note that
	for each student we are making a temp file, and appending PASSED or FAILED for
	each test.

4. Change the following in runTester.py:

	- submissions_folder_name must be XXXX
	- package_name must be name of package that students wrote code in
	- tester_file_path must be path where tester is located
	- Change prefix in for loop to prefix of foldername before github username

	Note that runTester.py will add the tester file to each students code directory,
	compile and run JUnit. You might need to modify the compile and run commands if you
	are compiling and running JUnit differently.

	runTester.py is then counting the number of PASSED and FAILED tokens in temp.txt to determine the students grade.

5. Add report.txt in XXXX folder (parellel to students directories)

6. Run python3 runTester.py. Results for each student, will be in report.txt.
For students whose code didn't compile, we need to manually compile their code 
(at least the tester is already copied over). Also note that files never copy over
to Cat Tran's folder, due to permission issues.



## Running a junit tester via the command line

1) Download [junit-4.12.jar](http://www.java2s.com/example/jar/j/download-junit412jar-file.html) and [hamcrest-core-1.3.jar](https://search.maven.org/search?q=g:org.hamcrest).
2) Create your junit test class.
3) Compile your code and test class using the following command: javac -d . *.java -cp /path/to/junit/jar/file/junit-4.12.jar ./<Insert test class name here>.java
4) Run the tests using the following command: java -cp .:./path/to/junit/jar/file/junit-4.12.jar:/path/to/hamcrest/jar/file/hamcrest-core-1.3.jar org.junit.runner.JUnitCore packagename.<Insert test class name>
