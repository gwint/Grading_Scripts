package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook l1 = new LeisureBook("John", "Smith", 1000, "Pearson", 2000, "Diary of a Wimpy Kid", Genre.NON_FICTION);
		LeisureBook l2 = new LeisureBook("Jane", "Doe", 200, "Not Pearson", 2010, "Twilight", Genre.HAIKU);
		Person p1 = new Person ("Samson", "Grimm", "111223333");
		Person p2 = new Person ("Juliette", "Bell", "444556666");
		BookClubMember bcm1 = new BookClubMember(p1);
		BookClubMember bcm2 = new BookClubMember(p2);
		BookClub bc = new BookClub();
		bc.addMember(bcm1);
		bc.addMember(bcm2);
		bc.addNewReading(l1);
		bc.addNewReading(l2);
		bcm1.setPageCount(l1, 100);
		bcm1.setPageCount(l2, 100);
		bcm2.setPageCount(l1, 200);
		bcm2.setPageCount(l2, 50);
		System.out.println("Average % of 'Diary of a Wimpy Kid' read: ");
		System.out.println("Expected: 15.0");
		System.out.println("Actual: " + bc.getAveragePercentRead(l1));
		System.out.println("Average % of 'Twilight' read: ");
		System.out.println("Expected: 37.5");
		System.out.println("Actual: " + bc.getAveragePercentRead(l2));
		System.out.println("Average % of all books read: ");
		System.out.println("Expected: 26.25");
		System.out.println("Actual: " + bc.getCompletionPercentage());

	}

}
