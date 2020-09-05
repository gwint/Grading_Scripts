package assignment05;

public class BookClubTester{
	public static void main(String[] args) {
	    LeisureBook leisure_book1 = new LeisureBook("JK", "Rowling", 768, 1993, "MagicBooks", "Deathly Hallows", Genre.FANTASY);
	    LeisureBook leisure_book2 = new LeisureBook("Thomas", "McKiernan", 203, 2000, "FunBooks", "All About Dolphins", Genre.NON_FICTION);
	    Person person1 = new Person("Evan", "Daprano", "111-22-3333");
	    Person person2 = new Person("Rohit", "Kapur", "444-55-6666");
	    BookClubMember bookclub_member1 = new BookClubMember(person1);
	    BookClubMember bookclub_member2 = new BookClubMember(person2);
	    BookClub book_club = new BookClub();
	    
	    book_club.addMember(bookclub_member1);
	    book_club.addMember(bookclub_member2);
//	    System.out.println(book_club.toString());
	    
	    book_club.addNewReading(leisure_book1);
	    book_club.addNewReading(leisure_book2);
//	    System.out.println(bookclub_member1.getReadings());
	    
	    bookclub_member1.setPageCount(leisure_book1, 150);
	    bookclub_member2.setPageCount(leisure_book2, 53);
	  
	    System.out.println("Testing getPercentRead() for bookclub_member1 and leisure_book1");
	    System.out.println("Expected: 19.53125");
	    System.out.println("Actual: " + bookclub_member1.getPercentRead(leisure_book1));
	    System.out.println("\n");
	    
	    System.out.println("Testing getPercentRead() for bookclub_member2 and leisure_book2");
	    System.out.println("Expected: 26.108374384236456");
	    System.out.println("Actual: " + bookclub_member2.getPercentRead(leisure_book2));
	    System.out.println("\n");
	    
	    System.out.println("Testing getAveragePercentRead() for book_club and leisure_book1");
	    System.out.println("Expected: 9.765625");
	    System.out.println("Actual: " + book_club.getAveragePercentRead(leisure_book1));
	    System.out.println("\n");
	    
	    System.out.println("Testing getAveragePercentRead() for book_club and leisure_book2");
	    System.out.println("Expected: 13.054187192118228");
	    System.out.println("Actual: " + book_club.getAveragePercentRead(leisure_book2));
	    System.out.println("\n");

	    System.out.println("Testing getCompletionPercentage() for book_club and leisure_book1");
	    System.out.println("Expected: 11.409906096059114");
	    System.out.println("Actual: " + book_club.getCompletionPercentage());
	    System.out.println("\n");
	    
	  
	    
	}


}
