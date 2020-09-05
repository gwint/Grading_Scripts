package assignment05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookClubTester {
	LeisureBook book1;
	LeisureBook book2;
	Person person1;
	Person person2;
	BookClubMember member1;
	BookClubMember member2;
	BookClub bookLovers = new BookClub();

	@BeforeEach
	void initialize() {
		book1 = new LeisureBook("Arthur Conan","Doyle",1234,"Penguin Books",2019,"The Adventures of Sherlock Homes",Genre.DETECTIVE_STORY);
		book2 = new LeisureBook("Douglas","Adams",523,"Zimbell House Publishing",2002,"The Ultimate Hitchhiker's Guide to the Galaxy",Genre.FANTASY);
		
		person1 = new Person("Mary", "Joseph", "012-34-5678");
		person2 = new Person("Alex", "Rudolph", "432-65-0987");
		
		member1 = new BookClubMember(person1);
		member2 = new BookClubMember(person2);
		
		bookLovers.addMember(member1);
		bookLovers.addMember(member2);
		bookLovers.addNewReading(book1);
		bookLovers.addNewReading(book2);
		
		member1.setPageCount(book1, 320);
		member1.setPageCount(book2, 423);
		member2.setPageCount(book1, 576);
		member2.setPageCount(book2, 112);
	}
	
	@Test
	@DisplayName("Tests AveragePercentRead")
	void testAveragePercentRead(){
		try {
			assertEquals(36.3047001621,bookLovers.getAveragePercentRead(book1), 1e-6);
			assertEquals(51.1472275335,bookLovers.getAveragePercentRead(book2), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("BookClub's getAveragePercentRead() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests CompletionPercentage")
	void testCompletionPercentage(){
		try {
			assertEquals(43.7259638478,bookLovers.getCompletionPercentage(), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("BookClub's getCompletionPercentage() method failed: " + e.getMessage());
			throw e;
		}
	}
}
