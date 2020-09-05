package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook lsBook1 = new LeisureBook("lil", "uzi", 110, "scream", 2018, "hereditary", Genre.HORROR);
		LeisureBook lsBook2 = new LeisureBook("kodak", "black", 183, "QC publication", 2013, "blade runner", Genre.SCIENCE_FICTION);

		BookClubMember bcm1 = new BookClubMember(new Person("AJ", "47", "210354687"));

		bcm1.addReading(lsBook1);
		bcm1.setPageCount(lsBook1, 25);
		bcm1.addReading(lsBook2);
		bcm1.setPageCount(lsBook2, 45);


		BookClubMember bcm2 = new BookClubMember(new Person("frank", "ocean", "657348225"));

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