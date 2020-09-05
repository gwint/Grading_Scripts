package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		System.out.println("-----TESTER FOR BOOK CLUB-----");
		LeisureBook book1 = new LeisureBook("JRR", "Tolkien", 423, "Allen & Unwin", 1954, "Fellowship of the Ring", Genre.FANTASY);
		LeisureBook book2 = new LeisureBook("George", "Orwell", 328, "Harvill Secker", 1949, "1984", Genre.DYSTOPIA);
		Person stacy = new Person("Stacy", "Baker", "987654321");
		Person chad = new Person("Chad", "Armstrong", "321654987");
		BookClubMember bcmStacy = new BookClubMember(stacy);
		BookClubMember bcmChad = new BookClubMember(chad);
		BookClub bc = new BookClub();
		bc.addMember(bcmChad);
		bc.addMember(bcmStacy);
		bc.addNewReading(book1);
		bc.addNewReading(book2);
		System.out.println(bc);
		bcmStacy.addReading(book1);
		bcmStacy.addReading(book2);
		bcmChad.addReading(book1);
		bcmChad.addReading(book2);
		bcmStacy.setPageCount(book1, 200);
		bcmStacy.setPageCount(book2, 310);
		bcmChad.setPageCount(book1, 421);
		bcmChad.setPageCount(book2, 115);
		System.out.println("% of Stacy thru FotR: " + bcmStacy.getPercentRead(book1));
		System.out.println("% of Chad thru FotR: " + bcmChad.getPercentRead(book1));
		System.out.println("% of Stacy thru 1984: " + bcmStacy.getPercentRead(book2));
		System.out.println("% of Chad thru 1984: " + bcmChad.getPercentRead(book2));
		
		
		System.out.println("Average percentage of Fellowship of the Ring completed: " + bc.getAveragePercentRead(book1));
		System.out.println("Average percentage of 1984 completed: " + bc.getAveragePercentRead(book2));
		System.out.println("Average class completion: " + bc.getCompletionPercentage());
		
		
		
		
	}
}
