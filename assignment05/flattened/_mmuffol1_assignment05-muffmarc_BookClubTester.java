package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		Person person1 = new Person("Nick", "Dags", "420698008");
		Person person2 = new Person("John", "Smith", "123456789");
		BookClubMember bcm1 = new BookClubMember(person1);
		BookClubMember bcm2 = new BookClubMember(person2);
		LeisureBook book1 = new LeisureBook("Marcus", "Muffoletto", 420, "Penguin Inc.", 1999, "How to not Suck", Genre.DIY);
		LeisureBook book2 = new LeisureBook("Nick", "Dags", 1000, "LifeSaver Inc.", 2019, "Why You Shouldn't Be Like Me", Genre.MEMOIR);
		BookClub bClub = new BookClub();
		bClub.addMember(bcm1);
		bClub.addNewReading(book1);
		bClub.addMember(bcm2);
		bClub.addNewReading(book2);
		bcm1.setPageCount(book1, 42);
		bcm1.setPageCount(book2, 100);
		bcm2.setPageCount(book1, 84);
		bcm2.setPageCount(book2, 200);
		System.out.println("Test getPercentRead():");
		System.out.println("Expected: 10");
		System.out.println(bcm1.getPercentRead(book1));
		System.out.println("Expected: 10");
		System.out.println(bcm1.getPercentRead(book2));
		System.out.println("Expected: 20");
		System.out.println(bcm2.getPercentRead(book1));
		System.out.println("Expected: 20");
		System.out.println(bcm2.getPercentRead(book2));
		System.out.println("Test getAveragePercentRead():");
		System.out.println("Expected: 15");
		System.out.println(bClub.getAveragePercentRead(book1));
		System.out.println("Test getCompletionPercentage:");
		System.out.println("Expected: 15");
		System.out.println(bClub.getCompletionPercentage());
	}
}
