import os

total_graded_assignments = 10
total_graded_labs = 10
cloned = []
def findGitHubUserName(student):
	file = open("students.csv")
	for line in file.readlines():
		firstLast = line.split(',')[0]
		studentPods = line.split(',')[1]
		gituser = line.split(',')[2].replace("\n", "")
		if student in studentPods or student in firstLast:
			return gituser
	print("Error: student " + student + "not found!")
	exit(0) 


def cloneStudent(student):
	os.system(f'mkdir {student}')
	#start by cloning all assignments
	for i in range(1, total_graded_assignments+1):
		clone = ""
		if(i <= 9):
			x = os.system(f'git clone https://github.com/Binghamton-CS140-A0-Fall-2018/assignment0{i}-{student}.git')
			clone = "assignment0" + str(i)
		else:
			x = os.system(f'git clone https://github.com/Binghamton-CS140-A0-Fall-2018/assignment{i}-{student}.git')
			clone = "assignment" + str(i)
		if x != 0:
			print("Error cloning assignment" + str(i))
		else:
			cloned.append(clone)

	#next clone all labs
	for i in range(1, total_graded_labs+1):
		clone = ""
		if(i <= 9):
			x = os.system(f'git clone https://github.com/Binghamton-CS140-A0-Fall-2018/lab0{i}-{student}.git')
			clone = "lab0" + str(i)
		else:
			x = os.system(f'git clone https://github.com/Binghamton-CS140-A0-Fall-2018/lab{i}-{student}.git')
			clone = "lab" + str(i)
		if x != 0:
			print("Error cloning lab" + str(i))
		else:
			cloned.append(clone)

	
	os.system(f'mv *{student} {student}')

def main():
	name = input("Enter the student's binghamton username or first and Last name space separated: ")
	gitUserName = findGitHubUserName(name)
	cloneStudent(gitUserName)

main()