package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook l1 = new LeisureBook("first", "second", 100, "publisher", 2019, "title", Genre.FANTASY);
		LeisureBook l2 = new LeisureBook("first2", "second2", 100, "publisher2", 2018, "title2", Genre.SCIENCE_FICTION);
		Person p1 = new Person("Xavier", "Chen", "111001111");
		Person p2 = new Person("Second", "Person", "000110000");
		BookClubMember bcm1 = new BookClubMember(p1);
		BookClubMember bcm2 = new BookClubMember(p2);
		BookClub bc1 = new BookClub();
		bc1.addMember(bcm1);
		bc1.addMember(bcm2);
		//test all averages
		bc1.addNewReading(l1);
		bc1.addNewReading(l2);
		bcm1.setPageCount(l1,50);
		bcm1.setPageCount(l2, 100);
		bcm2.setPageCount(l1, 25);
		bcm2.setPageCount(l2, 75);
		//should be 37.5
		System.out.println(bc1.getAveragePercentRead(l1));
		//should be 87.5
		System.out.println(bc1.getAveragePercentRead(l2));
		//should be 62.5
		System.out.println(bc1.getCompletionPercentage());

	}

}
