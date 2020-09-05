package assignment05;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

public class Assignment05Tester {
	
	FileWriter fw;	

	@Rule
	public TestWatcher watchman= new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			try{ 
    			fw.write("FAILED ");// Write FAILED token to file for each failed test
    			fw.close();
    		}catch(Exception ex){}
  		}

		@Override
		protected void succeeded(Description description) {
			try{ 
    			fw.write("PASSED ");// Write PASSED token to file for each successful test
    			fw.close();
    		}catch(Exception ex){}
		}
	};

	TextBook[] textbooks = new TextBook[3];
	LeisureBook[] leisureBooks = new LeisureBook[3];
	Person[] people = new Person[3];
	BookClubMember[] bcms = new BookClubMember[3];
	
	@Before
	public void setUp() throws Exception {

		fw = new FileWriter("temp.txt", true); //write a token in temp file

		people[0] = new Person("Dave", "DeFazio", "54345");
		people[1] = new Person("Person2", "Person2Last", "12321");
		people[2] = new Person("aaa", "bbb", "77777");

		textbooks[0] = new TextBook("fname1", "lname1", 123, "pub1", 2019, "This is textbook 1", "CS120");
		textbooks[1] = new TextBook("fname2", "lname2", 234, "pub2", 2020, "This is textbook 2", "CS220");
		textbooks[2] = new TextBook("fname3", "lname3", 209, "pub3", 2021, "This is textbook 3", "CS320");

		leisureBooks[0] = new LeisureBook("fname4", "lname4", 666, "pub4",
		 2080, "This is leisure book 1", Genre.WESTERN);
		leisureBooks[1] = new LeisureBook("fname5", "lname5", 777, "pub5",
		 2081, "This is leisure book 2", Genre.WESTERN);
		leisureBooks[2] = new LeisureBook("fname6", "lname6", 678, "pub6",
		 2088, "This is leisure book 3", Genre.PLAY);

		bcms[0] = new BookClubMember(people[0]);
		bcms[1] = new BookClubMember(people[1]);
		bcms[2] = new BookClubMember(people[2]);

	}

	/*@Test
	public void testBookToString() {
		Book b1 = new Book("Dave", "DeFazio", 97, "pub1", 2019, "This is book 1");
		String answer1 = "DeFazio. Dave. This is book 1. pub1. 2019.";
		String answer2 = "DeFazio Dave This is book 1 pub1 2019";
		String answer3 = "DeFazio, Dave, This is book 1, pub1, 2019";

		System.out.println(b1.toString());

		assertTrue((b1.toString().equals(answer1))
		 || (b1.toString().equals(answer2)) 
		 || (b1.toString().equals(answer3)));
	}*/

	@Test
	public void testAddChapters() {
		TextBook t1 = new TextBook("Dave", "DeFazio", 111, "pub1", 2019, "This is textbook 1", "CS240");
		t1.addChapter(1);
		t1.addChapter(4);
		List<Integer> chapters = t1.getAssignedChapters();
		assertTrue(chapters.size() == 2);
	}

	@Test
	public void testGetCourseNames() {
		Student s = new Student(people[0]);
		s.addBook(textbooks[0]);
		s.addBook(textbooks[2]);
		Set<String> courses = s.getCourseNames();
		assertTrue(courses.contains(textbooks[0].getCourseName())
			&& courses.contains(textbooks[2].getCourseName())
			&& courses.size() == 2);
	}

	@Test
	public void testAddReading(){
		BookClubMember member1 = new BookClubMember(people[0]);
		member1.addReading(leisureBooks[0]);
		member1.addReading(leisureBooks[1]);
		member1.addReading(leisureBooks[2]);
		assertTrue(member1.getReadings().size() == 3);
	}

	@Test
	public void test1GetPercentRead(){
		BookClubMember member1 = new BookClubMember(people[0]);
		member1.addReading(leisureBooks[0]);
		member1.setPageCount(leisureBooks[0], 45);
		double percent = member1.getPercentRead(leisureBooks[0]);
		System.out.println("test1GetPercentRead()");
		System.out.println("percent " + percent);
		System.out.println("actual " + (45.0/666.0)*100.0);
		assertEquals(percent, ((45.0/666.0)*100.0), 1e-6);
		
	}

	@Test
	public void test2GetPercentRead(){
		BookClubMember member1 = new BookClubMember(people[1]);
		member1.addReading(leisureBooks[1]);
		member1.setPageCount(leisureBooks[1], 90);
		double percent = member1.getPercentRead(leisureBooks[1]);
		System.out.println("test2GetPercentRead()");
		System.out.println("percent " + percent);
		System.out.println("actual " + (90.0/777.0)*100.0);
		assertEquals(percent, (90.0/777.0)*100.0, 1e-6);
	}

	@Test
	public void test3GetPercentRead(){
		BookClubMember member1 = new BookClubMember(people[0]);
		member1.addReading(leisureBooks[0]);
		member1.setPageCount(leisureBooks[1], 55);

		//getting percent read on book that doesnt exist for member
		double percent = member1.getPercentRead(leisureBooks[0]);

		assertTrue(percent == 0.0);
	}


	//Test whether new members inherit all books from bookclub
	@Test
	public void testAddMember(){

		BookClub bc = new BookClub();

		//First add readings to bc
		bc.addNewReading(leisureBooks[0]);
		bc.addNewReading(leisureBooks[1]);
		bc.addNewReading(leisureBooks[2]);

		//Now add members. These members should also be populated with the books.
		bc.addMember(bcms[0]);
		bc.addMember(bcms[1]);

		assertTrue(bcms[0].getReadings().size() == 3);
		assertTrue(bcms[1].getReadings().size() == 3);
		assertTrue(bcms[2].getReadings().size() == 0);

	}


	//test whether new books are added to all members of bookclub
	@Test
	public void testAddNewReading(){
		BookClub bc = new BookClub();

		bc.addMember(bcms[0]);
		bc.addMember(bcms[1]);
		bc.addMember(bcms[2]);

		bc.addNewReading(leisureBooks[1]);
		bc.addNewReading(leisureBooks[2]);

		assertTrue(bcms[0].getReadings().size() == 2);
		assertTrue(bcms[1].getReadings().size() == 2);
		assertTrue(bcms[2].getReadings().size() == 2);

	}

	//
	@Test
	public void test1GetAveragePercentRead(){

		BookClub bc = new BookClub();

		bc.addMember(bcms[0]);
		bc.addMember(bcms[1]);
		bc.addMember(bcms[2]);

		bc.addNewReading(leisureBooks[1]);
		bc.addNewReading(leisureBooks[2]);

		bcms[0].setPageCount(leisureBooks[1], 94);
		bcms[1].setPageCount(leisureBooks[1], 294);
		bcms[2].setPageCount(leisureBooks[1], 720);

		double result = bc.getAveragePercentRead(leisureBooks[1]);
		System.out.println("test1GetAveragePercentRead()");
		System.out.println("result " + result);
		System.out.println("actual " + (((94.0/777)*100.0) + ((294.0/777)*100.0) + ((720.0/777)*100.0))/3.0);
		assertEquals(result, (((94.0/777)*100.0) + ((294.0/777)*100.0) + ((720.0/777)*100.0))/3.0, 1e-6);

	}

	@Test
	public void test2GetAveragePercentRead(){

		BookClub bc = new BookClub();

		bc.addMember(bcms[0]);

		bc.addNewReading(leisureBooks[1]);
		bc.addNewReading(leisureBooks[2]);

		bcms[0].setPageCount(leisureBooks[1], 94);
		bcms[1].setPageCount(leisureBooks[1], 294);
		bcms[2].setPageCount(leisureBooks[1], 720);

		double result = bc.getAveragePercentRead(leisureBooks[1]);
		System.out.println("test2GetAveragePercentRead()");
		System.out.println("result " + result);
		System.out.println("actual " + ((94.0/777)*100.0));
		assertEquals(result, (94.0/777)*100.0, 1e-6);

	}

	@Test
	public void test3GetAveragePercentRead(){

		BookClub bc = new BookClub();

		bcms[0].setPageCount(leisureBooks[1], 94);
		bcms[1].setPageCount(leisureBooks[1], 294);
		bcms[2].setPageCount(leisureBooks[1], 720);

		double result = bc.getAveragePercentRead(leisureBooks[1]);
		System.out.println("RESULT: " + (result == 0));
		assertTrue(result == 0);

	}
	
	@Test
	public void test1GetCompletePercentage(){

		BookClub bc = new BookClub();

		bc.addMember(bcms[0]);
		bc.addMember(bcms[1]);
		bc.addMember(bcms[2]);

		bc.addNewReading(leisureBooks[0]);
		bc.addNewReading(leisureBooks[1]);

		bcms[0].setPageCount(leisureBooks[0], 320);
		bcms[1].setPageCount(leisureBooks[0], 2);
		bcms[2].setPageCount(leisureBooks[0], 665);

		bcms[0].setPageCount(leisureBooks[1], 94);
		bcms[1].setPageCount(leisureBooks[1], 294);
		bcms[2].setPageCount(leisureBooks[1], 720);

		double result1 = bc.getAveragePercentRead(leisureBooks[0]);
		double result2 = bc.getAveragePercentRead(leisureBooks[1]);

		assertTrue(bc.getCompletionPercentage() == (result1+result2)/2.0 );


	}

	@Test
	public void test2GetCompletePercentage(){

		BookClub bc = new BookClub();

		bc.addMember(bcms[0]);


		bc.addNewReading(leisureBooks[0]);
		bc.addNewReading(leisureBooks[1]);

		bcms[0].setPageCount(leisureBooks[0], 320);
		bcms[1].setPageCount(leisureBooks[0], 2);
		bcms[2].setPageCount(leisureBooks[0], 665);
		bcms[0].setPageCount(leisureBooks[1], 94);
		bcms[1].setPageCount(leisureBooks[1], 294);
		bcms[2].setPageCount(leisureBooks[1], 720);

		double result1 = bc.getAveragePercentRead(leisureBooks[0]);
		double result2 = bc.getAveragePercentRead(leisureBooks[1]);

		assertTrue(bc.getCompletionPercentage() == (result1+result2)/2.0 );

	}

	@Test
	public void test3GetCompletePercentage(){

		BookClub bc = new BookClub();

		bc.addNewReading(leisureBooks[0]);
		bc.addNewReading(leisureBooks[1]);

		bcms[0].setPageCount(leisureBooks[0], 320);
		bcms[1].setPageCount(leisureBooks[0], 2);
		bcms[2].setPageCount(leisureBooks[0], 665);

		bcms[0].setPageCount(leisureBooks[1], 94);
		bcms[1].setPageCount(leisureBooks[1], 294);
		bcms[2].setPageCount(leisureBooks[1], 720);

		//results should both be 0
		double result1 = bc.getAveragePercentRead(leisureBooks[0]);
		double result2 = bc.getAveragePercentRead(leisureBooks[1]);

		assertTrue(bc.getCompletionPercentage() == (result1+result2)/2.0 );

	}


}