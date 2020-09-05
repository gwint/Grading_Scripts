package assignment05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class BookClubTester {

	
	LeisureBook book1 = new LeisureBook("David", "Baldacci", 250, "Baldacci Books", 2018, "One Good Deed", Genre.ACTION);
	LeisureBook book2 = new LeisureBook("Kevin", "Hart", 275, "Audible", 2016, "Can't Hurt Me", Genre.COMEDY);
	
	Person p1 = new Person("Dirk", "Digler", "123-45-6789");
	Person p2 = new Person("Eric", "Echelheimer", "234-56-7891");
	
	BookClubMember member1 = new BookClubMember(p1);
	BookClubMember member2 = new BookClubMember(p2);
	
	BookClub aBookClub = new BookClub();
	
	@Test
	void TestGetPercentRead() {
		member1.addReading(book1);
		member1.addReading(book2);
		member2.addReading(book1);
		member2.addReading(book2);
		
		
		aBookClub.addNewReading(book1);
		aBookClub.addNewReading(book2);
		aBookClub.addMember(member1);
		aBookClub.addMember(member2);
		
		member1.setPageCount(book1, 40);
		member2.setPageCount(book2, 50);
		try {
			assertEquals(16.0, member1.getPercentRead(book1));
			System.out.println("16.0 == " + member1.getPercentRead(book1));
		}
		catch(AssertionError e) {
			System.out.println("BookClubMember's getPercentRead() method failed " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	void TestAveragePercentRead() {
		member1.addReading(book1);
		member1.addReading(book2);
		member2.addReading(book1);
		member2.addReading(book2);
		
		
		aBookClub.addNewReading(book1);
		aBookClub.addNewReading(book2);
		aBookClub.addMember(member1);
		aBookClub.addMember(member2);
		
		member1.setPageCount(book1, 40);
		member2.setPageCount(book2, 50);
		try {
			assertEquals(8.0, aBookClub.getAveragePercentRead(book1));
			System.out.println("8.0 == " + aBookClub.getAveragePercentRead(book1));
		}
		catch(AssertionError e) {
			System.out.println("BookClub's getAveragePercentRead() method failed " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	void TestCompletionPercentRead() {
		member1.addReading(book1);
		member1.addReading(book2);
		member2.addReading(book1);
		member2.addReading(book2);
		
		
		aBookClub.addNewReading(book1);
		aBookClub.addNewReading(book2);
		aBookClub.addMember(member1);
		aBookClub.addMember(member2);
		
		member1.setPageCount(book1, 40);
		member2.setPageCount(book2, 50);
		try {
			assertEquals(8.545454502105713, aBookClub.getCompletionPercentage(), 1e-6);
			System.out.println("8.545454502105713 == " + aBookClub.getCompletionPercentage());
		}
		catch(AssertionError e) {
			System.out.println("BookClub's getCompletionPercentage() method failed " + e.getMessage());
			throw e;
		}
	}
	
}
