package lab02;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.io.FileWriter;

class Lab02Tests {

	public static void main(String[] args) throws IOException{
 
		int grade = 0;
	
		FileWriter fw = new FileWriter("/home/mllab/Desktop/CS140/Grading_Scripts/lab-02/report.txt", true);
		Book b1 = new Book("abc", 10);
		Book b2 = new Book("def", 20);
		Book b3 = new Book("g1d", 5);
		Book b4 = new Book("asgwrt", 65);

		Book[] booksArray1 = new Book[4];
		booksArray1[0] = b1;
		booksArray1[1] = b2;
		booksArray1[2] = b3;
		booksArray1[3] = b4;

		Book[] booksArray2 = new Book[1];
		booksArray2[0] = b2;


		//Check Getters/Setters for Book (2 pts)
		if(b1.getTitle().equals("abc")){
			grade++;
		}else{
			fw.write("getTitle() error\n");
		}
		if(b1.getNumPages() == 10){
			grade++;
		}else{
			fw.write("getNumPages() error\n");
		}

		//Check numPagesInLibrary(Book[]) (4 pts)

		if(Library.numPagesInLibrary(booksArray1) == 100){
			grade += 2;
		}else{
			fw.write("numPagesInLibrary() error Case 1\n");			
		}
		if(Library.numPagesInLibrary(booksArray2) == 20){
			grade += 2;
		}else{
			fw.write("numPagesInLibrary() error Case 2\n");			
		}

		//Check mostPages(Book[]) (4 pts)

		Book[] booksArray3 = new Book[2];
		booksArray3[0] = new Book("a", 43);
		booksArray3[1] = new Book("b", 43);

		Book[] booksArray4 = new Book[4];
		booksArray4[0] = b2;
		booksArray4[1] = b1;
		booksArray4[2] = b4;
		booksArray4[3] = b3;

		if(Library.mostPages(booksArray1) == 65){
			grade += 2;
		}else{
			fw.write("mostPages() error Case 1\n");			
		}
		if(Library.mostPages(booksArray3) == 43){
			grade += 1;
		}else{
			fw.write("mostPages() error Case 2\n");			
		}
		if(Library.mostPages(booksArray4) == 65){
			grade += 1;
		}else{
			fw.write("mostPages() error Case 3\n");			
		}

		fw.write("Grade: " + grade + "\n");
		fw.close();


	}

	
}
