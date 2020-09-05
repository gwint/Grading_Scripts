package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook lbk1 = new LeisureBook("Doras", "Floral", 200, "HTC", 2000, "Nice Book", Genre.BIOGRAPHY);
		LeisureBook lbk2 = new LeisureBook("Fini", "Auri", 400, "APC", 2004, "Good Book",Genre.DETECTIVE_STORY);
		Person ps1 = new Person("Willy","Dom","744176220");
		Person ps2 = new Person("Oculis","April","744176220");
		BookClubMember bcm1 = new BookClubMember(ps1);
		BookClubMember bcm2 = new BookClubMember(ps2);
		BookClub bc = new BookClub();
		bc.addMember(bcm1);
		bc.addMember(bcm2);
		bc.addNewReading(lbk1);
		bc.addNewReading(lbk2);
		bcm1.setPageCount(lbk1, 100);
		bcm1.setPageCount(lbk2, 200);
		bcm2.setPageCount(lbk1, 200);
		bcm2.setPageCount(lbk2, 400);
		System.out.println("All 3 expected to be 75.0");
		System.out.println(bc.getAveragePercentRead(lbk1));
		System.out.println(bc.getAveragePercentRead(lbk2));
		System.out.println(bc.getCompletionPercentage());
	}
}
