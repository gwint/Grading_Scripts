package lab04;

import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.io.PrintWriter;


class Lab04_Grader {

	public static void main(String[] args) throws IOException{
 
		double grade = 0.2;
		//FileWriter fw = new FileWriter("/home/mllab/Desktop/CS140/Grading_Scripts/lab04/report.txt", true);
		
		String content = Files.readString(Paths.get("EchoArgs.java"), StandardCharsets.US_ASCII);
		if(content.contains("1. []") || content.contains("1.[]")){
			grade += 0.2;
		}
		if(content.contains("2. [hello]") || content.contains("2.[hello]")){
			grade += 0.2;
		}
		if(content.contains("3. [hello, world]") || content.contains("3.[hello, world]")){
			grade += 0.2;
		}
		if(content.contains("4. [hello world]") || content.contains("4.[hello world]")){
			grade += 0.2;
		}
		//if(grade != 1.0){
			//fw.write("EchoArgs.java comments\n");
		//}

		//Write an input file to the students directory to use as test
		PrintWriter writer = new PrintWriter("test_file.txt", "UTF-8");
		writer.println("82");
		writer.println("8");
		writer.println("2");
		writer.println("1");
		writer.println("0");
		writer.println("50");
		writer.println("101");
		writer.close();

		//fw.write("Grade: " + grade + "\n");
		//fw.close();


	}

	
}