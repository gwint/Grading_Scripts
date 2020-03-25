## clone - automated cloning of student repos

Dependencies: Python >= 3.6, [pydotenv](https://pypi.org/project/python-dotenv/)

Quick Note: This has been tested on linux ubuntu only.  Nothing in this repo will run on Windows.

How to Clone:
1) Head over to MyCourses and download the commit hashes for the assignment
   of interest.
2) Once it has been extracted, point the "COMMIT_HASHES_FOLDER_PATH" value
   from the .env file to this folder.
3) Run the following command, using values that make sense for you: ./clone <assignmentName> [-a51] [-a52] [-a53] [-a54] [-full] [-organization_name=an-organization-name]
(An example call would be ./clone exam01-a54 -a54 -organization_name Binghamton-University-CS140-A0)

A directory named <\assignment name> will be created and all student
repositories for assignment <\assignment name> will be cloned into it.
The particular commit checked out for each cloned repository will depend on
the commit hash submitted to MyCourses by the student.

run ./clone -h for more info.

## runtester - automated JUnit testing

1) Download the [junit5 jar](https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone/1.5.0).
2) Add the junit jar file to your CLASSPATH.
3) We also need to set the "JUNIT_JAR_PATH" field in the .env file.
4) Clone the desired labs/assignments using the clone directions above.
5) Write your tester, and add it to Testers/Assignments or Testers/Labs folder.  The location does not matter, but this is
   where we are currently storing the testers.
6) Run ./runtester <assignmentName> <testerPath>. Results for each student, will be in
   <assignmentName>/report.txt.
7) For students whose code does not compile, you will need to manually compile/run their code after handling any
   errors in their submission.

(An example call would be ./runtester exam01-a54 /home/gregory/Downloads/A53_54junitTests.java)

run ./runtester -h for more info.

## Running a single junit tester via the command line (not via runtester)

1) Download the [junit5 jar](http://www.java2s.com/example/jar/j/download-junit412jar-file.html).
2) Add the junit jar file to your CLASSPATH.
3) Create your junit tester.
5) Compile code with the following command: javac -d . *.java
6) Run the tests using the following command: java -jar /path/to/junit5/jarfile -cp . --scan-class-path

## Misc. Comments
1) I'll be using a different set of options for (6) so that I can remove --scan-class-path at some point
2) If you have cloned multiple sets of assignments (e.g lab01 and lab02) and then try to execute the runtester
script to grade lab02 after running it to grade lab01, the testers for lab01 will be rerun and will appear in the
generated report.  This is a consequence of using --scan-class-path and the reason for comment (1).
3) One consequence of using --scan-class-path is that all junit test class names must end in "Tests" so that they
 can be found by the ConsoleLauncher.

## TODO's
1) Incorporate stylechecker into runtester to generate a separate code style report.
