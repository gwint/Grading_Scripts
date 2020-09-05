package assignment05;


public class StudentTester{
	public static void main(String[] args) {
		Person person = new Person("Anjali", "Kapur", "123-45-6789");
	    Student student = new Student(person);
	    TextBook textbook1  = new TextBook("Timothy", "Banken", 786, 2010, "EnglishRocks", "How to Write", "English");
	    TextBook textbook2 = new TextBook("John", "Smith", 1000, 1997, "ScienceAcademy", "Thermodynamics", "Physics");
	    
	    textbook1.addChapter(3);
        textbook1.addChapter(4);
        textbook2.addChapter(5);
        textbook2.addChapter(6);
        student.addBook(textbook1);
        student.addBook(textbook2);
        
        System.out.println("Testing getAssignedChapters() for textbook1");
        System.out.println("Expected: [3, 4]");
        System.out.println("Actual: " + textbook1.getAssignedChapters());
        System.out.println("\n");
       
        System.out.println("Testing getAssignedChapters() for textbook2");
        System.out.println("Expected: [5, 6]");
        System.out.println("Actual: " + textbook2.getAssignedChapters());
        System.out.println("\n");
        
        System.out.println("Printing out student");
        System.out.println("Expected: Anjali Kapur (123-45-6789) taking [English, Physics]");

        System.out.println("Actual: " + student.toString());
	
	}
}
































/*
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

class StudentTester{
    Person person;
    Student student;
    Textbook textbook1;
    Textbook textbook2;

    @BeforeEach
    void initalize(){
        person = new Person("Anjali", "Kapur", "123-45-6789");
        student = new Student(person);
        textbook1  = new Textbook("Timothy", "Banken", 786, 2010, "EnglishRocks", "How to Write", "English");
        textbook2 = new Textbook("John", "Smith", 1000, 1997, "ScienceAcademy", "Thermodynamics", "Physics");
    }

    @Test
    @DisplayName("Tests addChapter() method in Textbook")
    void testTextbookAddChapter(){
		textbook1.addChapter(3);
        textbook1.addChapter(4);
        textbook2.addChapter(5);
        textbook2.addChapter(6);
		try {
			//when comparing two doubles, we need to give it some small value for it to see
			//if the expected and actual value are close enough to equaling one another
			assertEquals([3,4], textbook1.getAssignedChapters());
            assertEquals([5,6], textbook2.getAssignedChapters());
            System.out.println(textbook1.getAssignedChapters());
            System.out.println(textbook2.getAssignedChapters());
            System.out.println(student);
		}
		//here if there is an assertion error, we can catch it
		//and print the error message out, then throw the AssertionError
		//so that the test still fails.
		catch(AssertionError e){
			System.out.println("BankAccount's deposit() method failed: " + e.getMessage());
			throw e;
		}
    }


}
*/