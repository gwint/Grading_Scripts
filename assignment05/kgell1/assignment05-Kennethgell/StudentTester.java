package assignment05;
//import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class StudentTester {
	public static void main(String args[]){
	Person p = new Person("Kenny","Gell","132-99-073");
	Student kenny = new Student(p);
	List<Integer> chapters = new ArrayList<>();
	List<Integer> chapters2 = new ArrayList<>();
	 
	
	TextBook textBook1 = new TextBook("James","Mcdonald",500,"Steven Lay",2015,"Linear Algebra and its Applications", "Linear Algebra",chapters);
	TextBook textBook2 = new TextBook("Leslie","Lander",300,"BingU",2019,"Java for Dummies", "Computer Science",chapters2);
	
	textBook1.addChapter(1);
	textBook1.addChapter(2);
	textBook2.addChapter(4);
	textBook2.addChapter(7);
	kenny.addBook(textBook1);
	kenny.addBook(textBook2);
	
	
	System.out.println("****Testing Assgined Chapters, Expected: [1,2] , [4,7]****");
	System.out.println(textBook1.getAssignedChapters());
	System.out.println(textBook2.getAssignedChapters());
	System.out.println("****Testing Printing Student *****");
	System.out.println(kenny);
	
	
	}
}
