package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook lb1 = new LeisureBook("John", "Green", 300, "Penguin", 2003, "TFIOS", Genre.NON_FICTION);
		LeisureBook lb2 = new LeisureBook("Jodi", "Piccoult", 450, "Publisher Company", 2006, "My Sister's Keeper", Genre.MEMOIR);
		LeisureBook lb3 = new LeisureBook("Jodi", "Piccoult", 450, "Publisher Company", 2007, "19 Minutes", Genre.MEMOIR);
		Person p1 = new Person("Ally", "Waring", "1234567");
		Person p2 = new Person("Maddy", "Smith", "3456789");
		BookClubMember bcm1 = new BookClubMember(p1);
		BookClubMember bcm2 = new BookClubMember(p2);
		bcm1.addReading(lb1);
		bcm2.addReading(lb2);
		bcm2.addReading(lb1);
		bcm1.setPageCount(lb1, 20);
		bcm1.setPageCount(lb2, 20);
		bcm1.getPercentRead(lb2);
		System.out.println(bcm1.getPercentRead(lb2));
		bcm2.setPageCount(lb2, 30);
		System.out.println(bcm1.getReadings());
		System.out.println(bcm2.getReadings());
		
		BookClub bookC1 = new BookClub();
		bookC1.addMember(bcm1);
		bookC1.addMember(bcm2);
		bookC1.addNewReading(lb3);
		bookC1.addNewReading(lb2);
		System.out.println(bookC1.getAveragePercentRead(lb2));
		System.out.println(bookC1.getCompletionPercentage());
		
		
	}
}
