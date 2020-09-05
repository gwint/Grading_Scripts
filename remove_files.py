#Remove specified files and directories from each folder

import os
import shutil


rootdir = 'assignment05/'

folder_to_delete = "flattened"
file_to_delete = "README.md"

#Loop through all subdirectories
for subdir, dirs, files in os.walk(rootdir):

	for file in files:
		if(file_to_delete == file):
			path = os.path.join(subdir, file)
			os.system('rm ' + path)
			print("Removed", path)

	if(folder_to_delete in subdir):
		shutil.rmtree(subdir)
		print("Removed", subdir)