package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook lsBook1 = new LeisureBook("John", "Smith", 100, "123 Books", 2018, "Spooky Town", Genre.HORROR);
		LeisureBook lsBook2 = new LeisureBook("Barry", "Johnson", 180, "Good Books Publication", 2012, "Space Journey", Genre.SCIENCE_FICTION);
		
		BookClubMember bcm1 = new BookClubMember(new Person("Joe", "D", "012345678"));
		bcm1.addReading(lsBook1);
		bcm1.setPageCount(lsBook1, 25);
		bcm1.addReading(lsBook2);
		bcm1.setPageCount(lsBook2, 45);
		
		
		BookClubMember bcm2 = new BookClubMember(new Person("James", "Chavez", "567834552"));
		bcm2.addReading(lsBook2);
		bcm2.setPageCount(lsBook2, 90);
		bcm2.addReading(lsBook1);
		bcm2.setPageCount(lsBook1, 50);
		
		
		BookClub bc = new BookClub();
		bc.addMember(bcm1);
		bc.addMember(bcm2);
		bc.addNewReading(lsBook1);
		bc.addNewReading(lsBook2);
		
		
		

	}

}
