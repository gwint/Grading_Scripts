package assignment05;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


public class BookClubTester {
	Book le1 = new LeisureBook("DJ", "Lemahieu", 200, "Yankees", 1903, "Hitting for Dummies", Genre.SCIENCE_FICTION);
	Book le2 = new LeisureBook("Alrodis", "Chapman", 300, "Cubs", 1899, "Throwing Heat", Genre.HORROR);
	BookClubMember bcm1 = new BookClubMember(new Person("Chad", "Green", "454-54-5544"));
	BookClubMember bcm2 = new BookClubMember(new Person("Masahiro", "Tanaka", "157-19-2014"));
	BookClub bc1 = new BookClub();


		
		@Test
		@DisplayName("Gets the average of the percent read for the club")
		public void getAvergaePercentReadTest() {
			assertEquals(0, bc1.getAveragePercentRead(le1), 1e-6);
			bc1.addMember(bcm1);
			bc1.addMember(bcm2);
			bc1.addNewReading((LeisureBook) le1);
			bc1.addNewReading((LeisureBook)le2);
			bcm1.setPageCount((LeisureBook) le1, 50);
			bcm1.setPageCount((LeisureBook) le2, 150);
			bcm2.setPageCount((LeisureBook) le1, 180);
			bcm2.setPageCount((LeisureBook) le2, 30);
			try {
				assertEquals(57.5, bc1.getAveragePercentRead(le1), 1e-6);
				assertEquals(30, bc1.getAveragePercentRead(le2), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("getAveragePercentRead Method failed " + e.getMessage());
				throw e;
		
	}
}

		@Test
		@DisplayName("Tests deposit method of bank account")
		public void getPercentReadTest() {
			bcm1.setPageCount((LeisureBook) le1, 50);
			bcm1.setPageCount((LeisureBook) le2, 150);
			bcm2.setPageCount((LeisureBook) le1, 180);
			bcm2.setPageCount((LeisureBook) le2, 30);
			Book le3 = new LeisureBook("Luis", "Severino", 2018, "DR Baseball", 2011, "The Best That Ever Was", Genre.HORROR);
			try {
				assertEquals(25, bcm1.getPercentRead(le1), 1e-6);
				assertEquals(50, bcm1.getPercentRead(le2), 1e-6);
				assertEquals(90, bcm2.getPercentRead(le1), 1e-6);
				assertEquals(10, bcm2.getPercentRead(le2), 1e-6);
				assertEquals(0, bcm1.getPercentRead(le3), 1e-6);
				assertEquals(0, bcm2.getPercentRead(le3), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("getPercentRead Method failed " + e.getMessage());
				throw e;
		
	}
}
		@Test
		@DisplayName("Tests getCompletionPercentageTester")
		public void getCompletionPercentageTester() {
			bc1.addMember(bcm1);
			bc1.addMember(bcm2);
			bc1.addNewReading((LeisureBook) le1);
			bc1.addNewReading((LeisureBook)le2);
			bcm1.setPageCount((LeisureBook) le1, 50);
			bcm1.setPageCount((LeisureBook) le2, 150);
			bcm2.setPageCount((LeisureBook) le1, 180);
			bcm2.setPageCount((LeisureBook) le2, 30);
			try {
				assertEquals(43.75, bc1.getCompletionPercentage(), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("getCompletionPercentageRead Method failed " + e.getMessage());
				throw e;
		
	}
		}
		
		
}
