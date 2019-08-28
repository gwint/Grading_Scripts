The repository contains scripts and files that help ease the grading process.

## clone.py - Automated cloning of student repositories

Dependencies: Python >= 3.6, [pydotenv](https://pypi.org/project/pydotenv/)

Usage:
1) Head over to MyCourses and download the commit hashes for the assignment
   of interest.
2) Once it has been extracted, point the "COMMIT_HASHES_FOLDER_PATH" value
   from the .env file to this folder.
3) Run the following command, using values that make sense for you: python3 clone.py <\assignment name> [-a51] [-a52] [-a53] [-a54]

A directory named <\assignment name> will be created and all student
repositories for assignment <\assignment name> will be cloned into it.
The particular commit checked out for each cloned repository will depend on
the commit hash submitted to MyCourses by the student.
