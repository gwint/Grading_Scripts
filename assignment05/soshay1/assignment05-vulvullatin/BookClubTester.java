package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook book = new LeisureBook("Doug", "Lowe", 912, "Wiley", 2011, "Java All-in-One For Dummies", Genre.NON_FICTION);
		LeisureBook book2 = new LeisureBook("Doug", "Lowe", 700, "Penguin", 2000, "A good fantasy book", Genre.FANTASY);
		Person me = new Person("John","Doe","123-45-6789");
		Person me2 = new Person("Jane","Doe","987-65-4321");
		BookClubMember bcm = new BookClubMember(me);
		BookClubMember bcm2 = new BookClubMember(me2);
		BookClub bc = new BookClub();
		bc.addMember(bcm);
		bc.addMember(bcm2);
		bc.addNewReading(book);
		bc.addNewReading(book2);
		bcm.setPageCount(book, 400);
		bcm.setPageCount(book2, 400);
		bcm2.setPageCount(book, 500);
		bcm2.setPageCount(book2, 500);
		System.out.println("Average percent should be 49.3421% for java book and it is "+ bc.getAveragePercentRead(book));
		System.out.println("Average percent should be 64.2857% for fantasy book and it is "+ bc.getAveragePercentRead(book2));
		System.out.println("Average completion percent should be 56.8139% and it is "+ bc.getCompletionPercentage());
	}

}
