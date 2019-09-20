package lab03;

import java.io.IOException;
import java.io.FileWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.ArrayIndexOutOfBoundsException;

class Lab03_Grader_P2{

	public static void main(String[] args) throws IOException{
 
		double grade = 0;
	
		FileWriter fw = new FileWriter("/home/mllab/Desktop/CS140/Grading_Scripts/lab-03/report.txt", true);

		ClassRoom classRoom = new ClassRoom();

		classRoom.addStudent(new Student(5, "Gina"));
		classRoom.addStudent(new Student(3, "Tyler"));
		classRoom.addStudent(new Student(4, "Arnold"));
		classRoom.addStudent(new Student(1, "Jessica"));
		classRoom.addStudent(new Student(2, "Richard"));

		//TEST ADD STUDENT
		if(classRoom.getRoster().size() == 5){
			grade += 1;
		}else{
			fw.write("addStudent() error\n");			
		}

		classRoom.dropStudent(3);

		//TEST DROP STUDENT CASE 1
		boolean correct = true;
		for(Student s : classRoom.getRoster()){
			if(s.getId() == 3){
				correct = false;
			}
		}
		if(classRoom.getRoster().size() != 4){
			correct = false;
		}
		if(correct){
			grade += 1;
		}else{
			fw.write("dropStudent() error case 1\n");			
		}

		//DROP STUDENT CASE 2
		classRoom = new ClassRoom();
		classRoom.addStudent(new Student(5, "Gina"));
		classRoom.addStudent(new Student(3, "Tyler"));
		classRoom.addStudent(new Student(4, "Arnold"));
		classRoom.addStudent(new Student(1, "Jessica"));
		classRoom.addStudent(new Student(2, "Richard"));


		classRoom.dropStudent(38);
		if(classRoom.getRoster().size() == 5){
			grade += 1;
		}else{
			fw.write("dropStudent() error case 2\n");			
		}


		//TEST SORT BY ID. 2 pts increasing order. 1.5 pts decreasing order

		try{
			classRoom.sortById();
		}catch(ArrayIndexOutOfBoundsException exception){
			fw.write("Classroom sort Array out of bounds!! Subtract 2 points\n");			
		}

		int min_id = 0;
		correct = true;
		for(Student s : classRoom.getRoster()){
			if(s.getId() >= min_id){
				min_id = s.getId();
			}else{
				correct = false;
			}
		}

		if(correct){
			grade += 2;
		}else{
			fw.write("sortById not increasing order\n");

			int max_id = 9999;
			correct = true;
			for(Student s : classRoom.getRoster()){
				if(s.getId() <= max_id){
					max_id = s.getId();
				}else{
					correct = false;
				}
			}
			if(correct){
				grade += 1.5;
			}else{
				fw.write("sortById Failed\n");
			}

		}

		fw.write("Grade: " + grade + "\n");
		fw.close();

	}



}