The repository contains scripts and files that help ease the grading process.

## clone - Automated cloning of student repositories

Dependencies: Python >= 3.6, [pydotenv](https://pypi.org/project/pydotenv/)

How to Clone:
1) Head over to MyCourses and download the commit hashes for the assignment
   of interest.
2) Once it has been extracted, point the "COMMIT_HASHES_FOLDER_PATH" value
   from the .env file to this folder.
3) Run the following command, using values that make sense for you: ./clone [-a51] [-a52] [-a53] [-a54] [-full] <\assignment name>

A directory named <\assignment name> will be created and all student
repositories for assignment <\assignment name> will be cloned into it.
The particular commit checked out for each cloned repository will depend on
the commit hash submitted to MyCourses by the student.

## runtester - Automated JUnit testing

1. Clone all labs/assignments
2. Write tester, add in Testers/Assignments or Testers/Labs folder
3. Run ./runtester <\assignmentName> <\testerPath>. Results for each student, will be in report.txt.
For students whose code didn't compile, we need to manually compile their code 

## Running a junit tester via the command line

1) Download [junit 5 jar](http://www.java2s.com/example/jar/j/download-junit412jar-file.html) and [hamcrest-core-1.3.jar](https://search.maven.org/search?q=g:org.hamcrest).
2) Download [hamcrest jar](https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/)
3) Create your junit tester
4) Add both jar files to your CLASSPATH
5) Compile code: javac -d . *.java
6) Run the tests using the following command: 
