package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook leisure1 = new LeisureBook("John","Stewart",354,"CC",2015,"The Daily Book",Genre.SATIRE);
		LeisureBook leisure2 = new LeisureBook("Ron","Johnson", 203,"Penguin", 1969,"The Chicken Game",Genre.DYSTOPIA);
		BookClubMember bcm1 = new BookClubMember(new Person("Kieran","Gaffney","003541020"));
		BookClubMember bcm2 = new BookClubMember(new Person("Timmy","McGraw","153789312"));
		BookClub bookClub = new BookClub();
		bookClub.addMembers(bcm1);
		bookClub.addMembers(bcm2);
		bookClub.addNewReading(leisure1);
		bookClub.addNewReading(leisure2);
		bcm1.setPageCount(leisure1, 200);
		bcm2.setPageCount(leisure1, 100);
		bcm1.setPageCount(leisure2, 150);
		bcm2.setPageCount(leisure2, 120);
		System.out.println(bookClub.getAveragePercentRead(leisure1));
		System.out.println(bookClub.getAveragePercentRead(leisure2));
		System.out.println(bookClub.getCompletionPercentage());
	}
}
