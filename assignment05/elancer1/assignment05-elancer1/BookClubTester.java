package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook book1 = new LeisureBook("George", "Martin", 500, "Bantam Books", 1996, "A Game of Thrones", Genre.FANTASY);
		LeisureBook book2 = new LeisureBook("George", "Martin", 600, "Bantam Books", 1999, "A Clash of Kings", Genre.FANTASY);
		
		Person p1 = new Person("Debrah", "Schmeal", "987654321");
		Person p2 = new Person("Lori", "Smori", "989344321");
		
		BookClubMember bcm1 = new BookClubMember(p1);
		BookClubMember bcm2 = new BookClubMember(p2);
		
		BookClub theClub = new BookClub();
		
		theClub.addMember(bcm1);
		theClub.addMember(bcm2);
		
		theClub.addNewReading(book1);
		theClub.addNewReading(book2);
		
		bcm1.setPageCount(book1, 500);
		bcm2.setPageCount(book1, 500);
		
		bcm1.setPageCount(book2, 250);
		bcm2.setPageCount(book2, 600);
		
		System.out.println(theClub.getAveragePercentRead(book1));
		System.out.println(theClub.getAveragePercentRead(book2));
		System.out.println(theClub.getCompletionPercentage());
		
	}

}
;