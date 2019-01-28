import os

total_labs = 10
cloned = []
old_course_name = "Binghamton-CS140-A0-Fall-2018"
new_course_name = "Binghamton-CS140-Spring2019"


def cloneSemester():
	os.system('mkdir semester')
	# #start by cloning all assignments
	# for i in range(1, total_graded_assignments+1):
	# 	clone = ""
	# 	if(i <= 9):
	# 		x = os.system(f'git clone https://github.com/Binghamton-CS140-A0-Fall-2018/assignment0{i}-{student}.git')
	# 		clone = "assignment0" + str(i)
	# 	else:
	# 		x = os.system(f'git clone https://github.com/Binghamton-CS140-A0-Fall-2018/assignment{i}-{student}.git')
	# 		clone = "assignment" + str(i)
	# 	if x != 0:
	# 		print("Error cloning assignment" + str(i))
	# 	else:
	# 		cloned.append(clone)

	#clone all labs
	for i in range(1, total_labs+1):
		clone = ""
		if(i <= 9):
			x = os.system(f'git clone https://github.com/{old_course_name}/lab0{i}.git')
			clone = "lab0" + str(i)
		else:
			x = os.system(f'git clone https://github.com/{old_course_name}/lab{i}.git')
			clone = "lab" + str(i)
		if x != 0:
			print("Error cloning lab" + str(i))
		else:
			cloned.append(clone)

	
	os.system(f'mv lab* semester')

def main():
	cloneSemester()

main()