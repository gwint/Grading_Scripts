package assignment05;
import java.util.*;

public class Tester {

	public static void main(String[] args) {
	//Tester for Student
		Person person1;
		Student student1;
		List<Integer> assignment = new ArrayList<>();
		List<Integer> assignment2 = new ArrayList<>();

		person1 = new Person("John", "Doe", "123445678");
		student1 = new Student(person1);
		
		assignment.add(3);
		assignment.add(4);
		
		TextBook textbook1 = new TextBook("Sarah", "Baase", 400,
		"Pearson", 2016, "A Gift of Fire", "CS 301", assignment);
		
		assignment2.add(1);
		assignment2.add(7);
		
		TextBook textbook2 = new TextBook("Jane", "Davis", 350,
		"Pearson", 2018, "Intro to Java", "CS 140", assignment2 );
		
		System.out.println(textbook1.getAssignedChapters());
		System.out.println(textbook2.getAssignedChapters());
		
		
		
		student1.addBook(textbook1);
		student1.addBook(textbook2);
		
		System.out.println(student1.getCourseNames());
		
		System.out.println(student1);
		}
		
		
		//LeisureBook book1 = new LeisureBook()
	}

