import os
import sys
import subprocess
import csv
from dotenv import load_dotenv
from argparse import ArgumentParser
from html.parser import HTMLParser

NAME_IDX = 0
HASH_IDX = 6
COMMENT_IDX = 9
NO_ENTRY_MESSAGE = "There is no student submission text data for this assignment."

'''
Return list containing names of all students present on a lab roster.

@param str rosterFile Name of file containing student first and last names
@return List[str] A list of strings containing student names (first then last, seperated by a space)
'''
def get_roster(rosterFile):
    roster = []
    rosterFileObj = open(rosterFile, 'r')
    line = rosterFileObj.readline()
    while(line):
        pieces = line.split(',')
        name = f'{pieces[1].strip()} {pieces[0].strip()}'
        roster.append(name)
        line = rosterFileObj.readline()
    rosterFileObj.close()

    return roster

'''
Return a mapping from student name to assignment/lab commit hash.

@return Dict[str] => str A mapping between student name and commit hash found either as a text submission or in a comment.
'''
def get_name_to_hash_mapping():
    nameToHashMapping = {}

    class HashParser(HTMLParser):
        def __init__(self):
            self._hash = ""
            HTMLParser.__init__(self)

        def handle_data(self, data):
            if(data.strip()):
                self._hash = data.strip()

        def get_hash(self):
            return self._hash

    commitHashesFolder = os.getenv("COMMIT_HASHES_FOLDER_PATH")
    for filename in os.listdir(commitHashesFolder):
        commitFileObj = open(f'{commitHashesFolder}/{filename}', 'r')
        lines = commitFileObj.readlines()
        name = lines[0].strip().split("Name:")[1].strip().split('(')[0].strip()

        parser = HashParser()
        parser.feed(lines[HASH_IDX])

        hash = parser.get_hash()

        if(hash == NO_ENTRY_MESSAGE):
            hash = lines[COMMENT_IDX].strip()

        nameToHashMapping[name] = hash
        commitFileObj.close()

    return nameToHashMapping

'''
Returns a mapping from student name to a list containing student id and
student name.

@return Dict[str] => [str, str] A dictionary mapping student name to a list
where the first element is the corresponding student id and the second element
is the student's github username.
'''
def get_student_info():
    nameToInfoMapping = {}
    with open(os.getenv("STUDENT_INFO_FILE"), 'r') as csvFile:
        csvReader = csv.reader(csvFile)
        for row in csvReader:
            studentName = row[0]
            studentId = row[1]
            githubUsername = row[2]
            nameToInfoMapping[studentName] = [studentId, githubUsername]

    return nameToInfoMapping

'''
Returns url representing a student's remote repository.

@param str assignmentName Name of assignment being cloned.
@param str studentGithubUsername GitHub username of student of interest.
@param str organizationName Name of course organization.
@return str A string representing the full url of the requested student repo.
'''
def getFullRepositoryPath(assignmentName, studentGithubUsername, organizationName):
    return f'https://github.com/{organizationName}/{assignmentName}-{studentGithubUsername}.git'

'''
Clone student repositories into a directory specifically for a particular
assignment.
*** Make sure that assignment/lab directory does not already exist ***
'''
def main():
    load_dotenv()

    studentsWoGithubs = []
    studentsWoCommitHash = []

    nameToInfoMapping = get_student_info()
    nameToHashMapping = get_name_to_hash_mapping()

    parser = ArgumentParser()
    parser.add_argument("assn_name", type=str, nargs=1)
    parser.add_argument("-a51", action="store_true")
    parser.add_argument("-a52", action="store_true")
    parser.add_argument("-a53", action="store_true")
    parser.add_argument("-a54", action="store_true")

    studentsOfInterest = []
    args = parser.parse_args()

    assnName = args.assn_name

    if(args.a51):
        studentsOfInterest += get_roster(os.getenv("A51_ROSTER_FILE"))
    if(args.a52):
        studentsOfInterest += get_roster(os.getenv("A52_ROSTER_FILE"))
    if(args.a53):
        studentsOfInterest += get_roster(os.getenv("A53_ROSTER_FILE"))
    if(args.a54):
        studentsOfInterest += get_roster(os.getenv("A54_ROSTER_FILE"))

    os.system("mkdir " + sys.argv[1])
    numReposCloned = 0
    error = []

    for studentName in studentsOfInterest:
        if studentName not in nameToInfoMapping:
            studentsWoGithubs.append(studentName)
            continue
        bID = nameToInfoMapping[studentName][0]
        gitusername = nameToInfoMapping[studentName][1]
        if(nameToInfoMapping[studentName][1] != "NA"):
            if(studentName in nameToHashMapping):
                os.system("echo -------------" + studentName + "---------------------")
                x = os.system(f'git clone https://github.com/binghamton-cs140-a0-fall-2019/{sys.argv[1]}-{gitusername.strip()}.git')
                #x = os.system(f'git clone git@github.com:Binghamton-CS140-A0-Fall-2019/{sys.argv[1]}-{gitusername.strip()}.git')
                if x != 0:
        	        error.append(studentName + " " + bID)
        	        continue
                p = subprocess.Popen(["mkdir", bID], shell=True)
                p.wait()
                p = subprocess.Popen(["mv", sys.argv[1] + "-" + gitusername.strip(), bID])
                p.wait()
                p = subprocess.Popen(["mv", bID, sys.argv[1]])
                p.wait()

                ##now we want to ensure we get the commit that the student wants graded
                origCWD = os.getcwd()
                os.chdir(sys.argv[1] + os.sep + bID)
                p = subprocess.Popen(["git", "checkout",\
                             nameToHashMapping[studentName]])
                os.chdir(origCWD)

                numReposCloned += 1
                p.wait()
            else:
                studentsWoCommitHash.append(studentName + " " + bID)

    print(f'Successfully cloned repos from {numReposCloned} students out of a possible {len(studentsOfInterest)}.')
    print(f'{len(error)} users had errors occur.')
    print(error)
    errors = open(sys.argv[1] + "_errors.txt", 'w')
    for name in error:
        errors.write(name + "\n")
    errors.close()
    print(f'{len(studentsWoCommitHash)} have no commit hash on file.')
    print(studentsWoCommitHash)
    hash = open(sys.argv[1] + "_noHash.txt", 'w')
    for name in studentsWoCommitHash:
        hash.write(name + "\n")
    hash.close()

main()
