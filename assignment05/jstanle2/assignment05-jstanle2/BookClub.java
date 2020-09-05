package assignment05;
import java.util.Set;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook b: readings) {
			bcm.addReading(b);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		double avg = 0.0;
		double total = 0;
		if(members.isEmpty() && readings.isEmpty()) {
			return avg;
		}
		for(BookClubMember bcm: members) {
			total += bcm.getPercentRead(book);
		}
		avg = total / members.size();
		return avg;
	}
	
	public double getCompletionPercentage() {
		double total = 0;
		for(LeisureBook book: readings) {
			total += getAveragePercentRead(book);
		}
		double avg = total / readings.size();
		return avg;
	}
	
	@Test
	@DisplayName("Tests getPercentRead method of BookClubMember")
	public void testGetPercentRead() {
		Person person1 = new Person("Jesse", "McCree", "121121212");
		LeisureBook book1 = new LeisureBook("Rick", "Riordan", 573, "Fake Publisher", 2010, "Percy Jackson", Genre.FANTASY);
		BookClubMember member1 = new BookClubMember(person1);
		member1.addReading(book1);
		member1.setPagesCount(book1, 200);
		try {
			assertEquals(34.9, member1.getPercentRead(book1), 1e-1);
		}
		catch(AssertionError e) {
			System.out.println("BookClubMember's getPercentRead method failed" + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests getAveragePercentRead method of BookClub")
	public void testGetAveragePercentRead() {
		Person person1 = new Person("Jesse", "McCree", "121121212");
		Person person2 = new Person("John", "Travolta", "123456789");
		LeisureBook book1 = new LeisureBook("Rick", "Riordan", 573, "Fake Publisher", 2010, "Percy Jackson", Genre.FANTASY);
		BookClubMember member1 = new BookClubMember(person1);
		BookClubMember member2 = new BookClubMember(person2);
		member1.setPagesCount(book1, 200);
		member2.setPagesCount(book1, 573);
		BookClub bookClub = new BookClub();
		try {
			assertEquals(0.0, bookClub.getAveragePercentRead(book1), 1e-1);
		}
		catch(AssertionError e) {
			System.out.println("BookClub's getAveragePercentRead method failed" + e.getMessage());
			throw e;
		}
		bookClub.addMember(member1);
		bookClub.addMember(member2);
		bookClub.addNewReading(book1);
		try {
			assertEquals(67.4, bookClub.getAveragePercentRead(book1), 1e-1);
		}
		catch(AssertionError e) {
			System.out.println("BookClub's getAveragePercentRead method failed" + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests getCompletionPercentage method of BookClub")
	public void testGetCompletionPercentage() {
		Person person1 = new Person("Jesse", "McCree", "121121212");
		Person person2 = new Person("John", "Travolta", "123456789");
		LeisureBook book1 = new LeisureBook("Rick", "Riordan", 573, "Fake Publisher", 2010, "Percy Jackson", Genre.FANTASY);
		LeisureBook book2 = new LeisureBook("J.R.R.", "Tolkien", 1031, "Houghton Mifflin Harcourt", 1954, "Lord of the Rings", Genre.FANTASY);
		BookClubMember member1 = new BookClubMember(person1);
		BookClubMember member2 = new BookClubMember(person2);
		member1.setPagesCount(book1, 200);
		member1.setPagesCount(book2, 120);
		member2.setPagesCount(book1, 573);
		member2.setPagesCount(book2, 500);
		BookClub bookClub = new BookClub();
		bookClub.addMember(member1);
		bookClub.addMember(member2);
		bookClub.addNewReading(book1);
		bookClub.addNewReading(book2);
		try {
			assertEquals(48.7, bookClub.getCompletionPercentage(), 1e-1);
		}
		catch(AssertionError e) {
			System.out.println("BookClub's getCompletionPercentage method failed" + e.getMessage());
			throw e;
		}
	}
}
