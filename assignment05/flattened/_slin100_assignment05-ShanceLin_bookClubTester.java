package assignment05;

public class bookClubTester {
	public static void main(String[] args) {
		LeisureBook lb1 = new LeisureBook("James", "Dome", 220, "Lion", 1995, "How is James?", Genre.FANTASY);
		LeisureBook lb2 = new LeisureBook("Jimmy", "Dee", 990, "Tiger", 1855, "What is Jimmy?", Genre.MYSTERY);
		Person prsn1 = new Person("Daniel", "Lucas", "032-61-5929");
		Person prsn2 = new Person("Damian", "Lamb", "016-23-5299");
		BookClubMember bcm1 = new BookClubMember(prsn1);
		BookClubMember bcm2 = new BookClubMember(prsn2);
		BookClub bc = new BookClub();
		bc.addMember(bcm1);
		bc.addNewReading(lb1);
		bc.addMember(bcm2);
		bc.addNewReading(lb2);
		
		bcm1.setPageCount(lb1, 50);
		bcm2.setPageCount(lb1, 200);
		bcm1.setPageCount(lb2, 500);
		bcm2.setPageCount(lb2, 10);
		
		System.out.println("AveragePercentRead for LeisureBook1: Expected: 56.81... Actual: " + bc.getAveragePercentRead(lb1) + "%");
		System.out.println("AveragePercentRead for LeisureBook2: Expected: 25.75... Actual: " + bc.getAveragePercentRead(lb2) + "%");
		System.out.println("CompletionRate: Expected: 41.28... Actual:  " + bc.getCompletionRate() + "%");
	}
}
