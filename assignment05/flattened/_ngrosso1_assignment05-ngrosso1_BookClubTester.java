package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook lb = new LeisureBook("William", "Philips", 300, "NightOwl", 2000, "The Wind Blows Again", Genre.SATIRE);
		LeisureBook lb2 = new LeisureBook("John", "King", 200, "EEP", 1917, "The Kings Tale of the Gold", Genre.WESTERN);
		Person person = new Person("John", "Smith", "200-20-2000");
		BookClubMember bcm = new BookClubMember(person);
		Person person2 = new Person("Nicky", "Vin", "230-56-2400");
		BookClubMember bcm2 = new BookClubMember(person2);
		BookClub bc = new BookClub();
		bc.addMember(bcm);
		bc.addMember(bcm2);
		bc.addNewReading(lb);
		bc.addNewReading(lb2);
		
		bcm.setPageCount(lb, 45);
		bcm.setPageCount(lb2, 50);
		bcm2.setPageCount(lb, 150);
		bcm2.setPageCount(lb2, 50);
		
		System.out.println("The average percentage of the pages read for lb is " + bc.getAveragePercentRead(lb) + "%");
		System.out.println("The average percentage of the pages read for lb2 is " + bc.getAveragePercentRead(lb2) + "%");
		System.out.println("The average percentage of the pages read in the club is " + bc.getCompletionPercentage() + "%");
	}
}
