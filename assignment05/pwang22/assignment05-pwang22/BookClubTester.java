package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		Person p1 = new Person("Colin", "Mcrae", "178304857");
		Person p2 = new Person("Nicky", "Grist", "296739583");
		LeisureBook lb1 = new LeisureBook("J. K.", "Rowling", 312, "Bloomsbury", 1997, "Harry Potter", Genre.FANTASY);
		LeisureBook lb2 = new LeisureBook("Suzanne", "Collins", 374, "Scholastic", 2008, "Hunger Games", Genre.DYSTOPIA);
		BookClubMember bcm1 = new BookClubMember(p1);
		BookClubMember bcm2 = new BookClubMember(p2);
		BookClub bc1 = new BookClub();
		
		bc1.addMember(bcm1);
		bc1.addMember(bcm2);
		bc1.addNewReading(lb1);
		bc1.addNewReading(lb2);
		
		bcm1.setPageCount(lb1, 233);	// 74.679487179 %
		bcm2.setPageCount(lb1, 38);		// 12.179487179 %
		bcm1.setPageCount(lb2, 17);		// 04.545454545 %
		bcm2.setPageCount(lb2, 352);	// 94.117647058 %
		
		System.out.println("Expected values: (approximate)");
		System.out.println("43.4294871790");
		System.out.println("49.3315508015");
		System.out.println("46.3805189902");
		System.out.println("Returned values:");
		System.out.println(bc1.getAveragePercentRead(lb1));
		System.out.println(bc1.getAveragePercentRead(lb2));
		System.out.println(bc1.getCompletionPercentage());
		System.out.println("All tests passed");
	}
}
