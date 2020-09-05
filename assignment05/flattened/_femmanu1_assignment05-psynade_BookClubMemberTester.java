package assignment05;

import org.junit.jupiter.api.Test;

public class BookClubMemberTester {
 
	@Test
	public static void main(String[] args) {
		LeisureBook lb1 = new LeisureBook("John", "Smith", 300, "Cindy Hopper", 2016,"A Title for a Book", Genre.NON_FICTION);
		LeisureBook lb2 = new LeisureBook("Billy", "Johnson", 6034, "Big Publisher INC.", 2020, "Generic Title", Genre.MUSICAL);
		BookClubMember bcm1 = new BookClubMember(new Person("Dennis", "Johnson","123456789"));
		BookClubMember bcm2 = new BookClubMember(new Person("William", "Hartman","349620168"));
		BookClub club = new BookClub();
		club.addMember(bcm1);
		club.addMember(bcm2);
		club.addNewReading(lb1);
		club.addNewReading(lb2);
		club.getAveragePercentRead(lb1);
		club.getAveragePercentRead(lb2);
		club.getCompletedPercentage();
	}
}
