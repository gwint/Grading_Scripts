package assignment05;

public class BookClubTester {

	public static void main (String [] args) {
		LeisureBook b1 = new LeisureBook("Jackson", "Michael",145,"Hee Hee Publishing Co.", 1990,"Annie Was Okay", Genre.THRILLER);
		LeisureBook b2 = new LeisureBook("Bale", "Christian",230,"Dark Knight Publishing Co.", 2015,"I'm Batman", Genre.NON_FICTION);
		Person p1 = new Person("Obama","Barack","1234567890");
		Person p2 = new Person("Trump","Donald","0987654321");
		BookClubMember Obama = new BookClubMember(p1);
		BookClubMember Trump = new BookClubMember(p2);
		BookClub club = new BookClub();
		club.addMember(Obama);
		club.addMember(Trump);
		club.addNewReading(b1);
		club.addNewReading(b2);
		Obama.setPageCount(b1, 29);
		System.out.println(Obama.getPercentRead(b1));
		Trump.setPageCount(b1, 87);
		Obama.setPageCount(b2, 230);
		System.out.println(Obama.getPercentRead(b2));
		Trump.setPageCount(b2, 0);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println("Expected Average Percent Read of \"Annie Was Ok\": 40.0%");
		System.out.println("Expected Average Percent Read of \"I'm Batman\": 50.0%");
		System.out.println("Expected Completion Percentage: 45.0%");
		System.out.println("Actual Average Percent Read of \"Annie Was Ok\": " + club.getAveragePercentRead(b1) + "%");
		System.out.println("Actual Average Percent Read of \"I'm Batman\": " + club.getAveragePercentRead(b2) + "%");
		System.out.println("Actual Completion Percentage: " + club.getCompletionPercentage() + "%");
	}
}
