package assignment01;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import java.io.FileWriter;

public class Assignment01Tester {
	
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


	Computer[] computers = new Computer[5];
	StreetUSAddress[] streets = new StreetUSAddress[5];
	DateAndPlaceOfBirth[] dateplaces = new DateAndPlaceOfBirth[8];
	Person[] persons = new Person[5];
	
	@Before
	public void setUp() throws Exception {

		fw = new FileWriter("temp.txt", true); //write a token in temp file	

		computers[0] = new Computer("Dell", "Intel Core i5", 16, 500, true, 800.99);
		computers[1] = new Computer("Dell", "Intel Core i7", 8, 1500, false, 1100.99);
		computers[2] = new Computer("Dell", "Intel Core i5", 24, 500, true, 800.99);
		computers[3] = new Computer("Dell", "Intel Core i7", 32, 1500, false, 1100.99);
		computers[3] = new Computer("Dell", "Intel Core i7", 16, 1000, false, 1100.99);
		streets[0] = new StreetUSAddress("800 Main St", "Appt 15A", "Binghamton", "NY", "13905");
		streets[1] = new StreetUSAddress("80 State St", "", "Endicott", "NY", "13760");
		streets[2] = new StreetUSAddress("100 Water St", "Appt 3", "Vestal", "NY", "13850");
		streets[3] = new StreetUSAddress("80 Hooper Rd", "", "Endwell", "NY", "13762");
		streets[4] = new StreetUSAddress("80 Front St", "", "Owego", "NY", "13827");
		dateplaces[0] = new DateAndPlaceOfBirth(1990, 10, 21, "Binghamton", "NY", "USA");
		dateplaces[1] = new DateAndPlaceOfBirth(2000, 3, 9, "London", "NY", "USA");
		dateplaces[2] = new DateAndPlaceOfBirth(2004, 7, 8, "London", "UK");
		dateplaces[3] = new DateAndPlaceOfBirth(2006, 6, 9, "Elmira", "NY", "USA");
		dateplaces[4] = new DateAndPlaceOfBirth(2006, 6, 10, "Moscow", "Russia");
		dateplaces[5] = new DateAndPlaceOfBirth(2006, 7, 8, "Utica", "NY", "USA");
		dateplaces[6] = new DateAndPlaceOfBirth(2006, 7, 8, "Syracuse", "NY", "USA");
		dateplaces[7] = new DateAndPlaceOfBirth(2010, 7, 8, "Paris", "France");
		persons[0] = new Person("John", "Smith", "999999999", dateplaces[0], streets[0]);
		persons[1] = new Person("Joan", "Stevens", "001020003", dateplaces[1], streets[1]);
		persons[2] = new Person("Mary", "Hall", "01020003", dateplaces[2], streets[2]);
		persons[3] = new Person("Jane", "Williams", "123456789", dateplaces[3], streets[3]);
		persons[4] = new Person("Steven", "Walker", "1020003", dateplaces[4], streets[4]);
	}

	@Test
	public void testGetAddressLine1() {
		assertEquals("80 State St", streets[1].getAddressLine1());
	}

	@Test
	public void testGetAddressLine2() {
		assertEquals("", streets[1].getAddressLine2().trim());
		assertEquals("Appt 15A", streets[0].getAddressLine2().trim());
	}

	@Test
	public void testGetCity() {
		assertEquals("Vestal", streets[2].getCity());
	}

	@Test
	public void testGetStateAbbreviation() {
		assertEquals("NY", streets[3].getStateAbbreviation());
	}

	@Test
	public void testGetZipCode() {
		assertEquals("13827", streets[4].getZipCode());
	}

	@Test
	public void testHasSameBirthDayAs() {
		assertTrue(dateplaces[2].hasSameBirthDayAs(dateplaces[5]));
		assertTrue(dateplaces[5].hasSameBirthDayAs(dateplaces[6]));
		assertTrue(dateplaces[6].hasSameBirthDayAs(dateplaces[7]));
		assertTrue(dateplaces[7].hasSameBirthDayAs(dateplaces[2]));
		for(int i = 1; i < dateplaces.length; i++) {
			assertFalse(dateplaces[0].hasSameBirthDayAs(dateplaces[i]));
		}			
		for(int i = 2; i < dateplaces.length; i++) {
			assertFalse(dateplaces[1].hasSameBirthDayAs(dateplaces[i]));
		}			
		for(int i = 4; i < dateplaces.length; i++) {
			assertFalse(dateplaces[3].hasSameBirthDayAs(dateplaces[i]));
		}			
		for(int i = 5; i < dateplaces.length; i++) {
			assertFalse(dateplaces[4].hasSameBirthDayAs(dateplaces[i]));
		}			
	}
	
	@Test
	public void testGetPlaceDob() {
		assertEquals(dateplaces[0], persons[0].getPlaceDob());
	}

	@Test
	public void testGetAddress() {
		assertEquals(streets[0], persons[0].getAddress());
	}

	/*@Test
	public void testToStringPerson() {
		System.out.println("Expected persons[0] toString:");
		System.out.println("John Smith (999-99-9999),\n"
				+ "Date and place of birth: 1990-10-21, Binghamton, NY, USA\n"
				+ "800 Main St\nAppt 15A\nBinghamton, NY 13905");
		System.out.println();
		System.out.println("Actual:");
		System.out.println(persons[0]);
		System.out.println();
		System.out.println("Expected persons[4] toString:");
		System.out.println("Steven Walker (001-02-0003),\n"
				+ "Date and place of birth: 2006-06-10, Moscow, Russia\n"
				+ "80 Front St\nOwego, NY 13827");
		System.out.println();
		System.out.println("Actual:");
		System.out.println(persons[4]);
		System.out.println();
		String[] parts1 = persons[0].toString().trim().split("\n");
		String[] parts2 = persons[4].toString().trim().split("\n");


		assertEquals("John Smith (999-99-9999),", parts1[0].trim());
		assertEquals("Date and place of birth: 1990-10-21, Binghamton, NY, USA", parts1[1].trim());
		assertEquals("800 Main St", parts1[2].trim());
		assertEquals("Appt 15A", parts1[3].trim());
		assertEquals("Binghamton, NY 13905", parts1[4].trim());
		assertEquals("Steven Walker (001-02-0003),", parts2[0].trim());
		assertEquals("Date and place of birth: 2006-06-10, Moscow, Russia", parts2[1].trim());
		assertEquals("80 Front St", parts2[2].trim());
		assertEquals("Owego, NY 13827", parts2[3].trim());
	}*/

	@Test
	public void testSimpleDateBefore1() {
		assertTrue(SimpleDate.of(2000, 10, 20).before(SimpleDate.of(2001, 5, 3)));
		assertFalse(SimpleDate.of(2010, 10, 20).before(SimpleDate.of(2000, 11, 23)));
	}
	@Test
	public void testSimpleDateBefore2() {
		assertTrue(SimpleDate.of(2000, 10, 20).before(SimpleDate.of(2000, 11, 3)));
		assertFalse(SimpleDate.of(2000, 11, 20).before(SimpleDate.of(2000, 10, 33)));
	}
	@Test
	public void testSimpleDateBefore3() {
		assertTrue(SimpleDate.of(2000, 10, 20).before(SimpleDate.of(2000, 10, 23)));
		assertFalse(SimpleDate.of(2000, 10, 23).before(SimpleDate.of(2000, 10, 20)));
	}

	@Test
	public void testSimpleDateBefore4() {
		assertFalse(SimpleDate.of(2000, 10, 20).before(SimpleDate.of(2000, 10, 20)));
	}


}