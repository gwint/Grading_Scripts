package assignment05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class StudentTester {

	Person aPerson = new Person("Barrett", "Sweet", "123-45-6789");
	
	Student aStudent = new Student(aPerson);
	
	TextBook book1 = new TextBook("Arthur", "Author", 100, "Penguin House", 1999, "Antartica Explored", "Exploring the World 101");
	TextBook book2 = new TextBook("Bonita", "Brown", 200, "Dogtown Books", 2019, "Fire Hydrants", "Taking a Leak 578");
	
	@Test
	void testGetAssignedChapters() {

		aStudent.addBook(book1);
		aStudent.addBook(book2);
		
		book1.addChapter(1);
		book1.addChapter(2);
		book2.addChapter(3);
		book2.addChapter(4);
		
		try {
			assertEquals("[1, 2]", book1.getAssignedChapters().toString());
			System.out.println("[1, 2] == " + book1.getAssignedChapters());
		}
		catch(AssertionError e) {
			System.out.println("TextBook's getAssignedChapters() method failed " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	void testToString() {

		aStudent.addBook(book1);
		aStudent.addBook(book2);
		
		book1.addChapter(1);
		book1.addChapter(2);
		book2.addChapter(3);
		book2.addChapter(4);
		
		try {
			assertEquals("Barrett Sweet (123-45-6789) taking [Exploring the World 101, Taking a Leak 578]", aStudent.toString());
			System.out.println("Barrett Sweet (123-45-6789) taking [Exploring the World 101, Taking a Leak 578] == " + aStudent.toString());
		}
		catch(AssertionError e) {
			System.out.println("Student's toString() method failed " + e.getMessage());
			throw e;
		}
	}
}
