package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook book1 = new LeisureBook("J.R.R.", "Tolkien", 423, "Allen & Unwin", 
				1954, "The Fellowship of the Ring", Genre.FANTASY);
		LeisureBook book2 = new LeisureBook("J.R.R.", "Tolkien", 352, "Allen & Unwin", 
				1954, "The Two Towers", Genre.FANTASY);
		BookClubMember bcm1 = new BookClubMember(new Person("Adam", "Kunz", "123456789"));
		bcm1.setPageCount(book1, 200);
		bcm1.setPageCount(book2, 150);
		BookClubMember bcm2 = new BookClubMember(new Person("John", "Smith", "987654321"));
		bcm2.setPageCount(book1, 50);
		bcm2.setPageCount(book2, 250);
		BookClub bc = new BookClub();
		bc.addMember(bcm1);
		bc.addMember(bcm2);
		bc.addNewReading(book1);
		bc.addNewReading(book2);
		System.out.print("Average percent of pages read for book 1: ");
		System.out.println(String.format("%.2f", bc.getAveragePercentRead(book1)));
		System.out.print("Average percent of pages read for book 2: "); 
		System.out.println(String.format("%.2f", bc.getAveragePercentRead(book2)));
		System.out.print("Average percent of pages read for both books: "); 
		System.out.println(String.format("%.2f", bc.getCompletionPercentage()));
	}
}