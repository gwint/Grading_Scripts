package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook lb1 = new LeisureBook("F. Scott", "Fitzgerald", 218, "Charles Scibner's Sons", 1925, "The Great Gatsby", Genre.ROMANCE);
		LeisureBook lb2 = new LeisureBook("John", "Steinbeck", 187, "Covici Friede", 1937, "Of Mice and Men", Genre.THRILLER);
		BookClubMember bcm1 = new BookClubMember(new Person("James", "Irwin", "222-11-8888"));
		BookClubMember bcm2 = new BookClubMember(new Person("Isabel", "Friedberg", "444-55-7777"));
		
		bcm1.setPageCount(lb1, 100);
		bcm1.setPageCount(lb2, 100);
		
		bcm2.setPageCount(lb1, 150);
		bcm2.setPageCount(lb2, 150);
		
		BookClub club = new BookClub();
		
		club.addMember(bcm1);
		club.addMember(bcm2);
		club.addNewReading(lb1);
		club.addNewReading(lb2);
		
		System.out.println(club.getAveragePercentRead(lb1));
		System.out.println(club.getAveragePercentRead(lb2));
		System.out.println(club.getCompletionPercentage());

	}

}
