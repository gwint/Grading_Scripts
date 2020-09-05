package assignment05;
import java.util.*;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook l1 = new LeisureBook("john", "pie", 152, "pubblish", 1922, "real book", Genre.NON_FICTION);
		LeisureBook l2 = new LeisureBook("apple", "man", 1245, "coedison", 2004, "fake book", Genre.FANTASY);
		Person p1 = new Person("javier", "liu", "123456789");
		Person p2 = new Person("orange", "haha", "987654321");
		BookClubMember b1 = new BookClubMember(p1);
		BookClubMember b2 = new BookClubMember(p2);

		b1.setPageCount(l1,120);
		b1.setPageCount(l2,900);
		b2.setPageCount(l1,39);
		b2.setPageCount(l2,1244);

		BookClub bc = new BookClub();
		bc.addMember(b1);
		bc.addMember(b2);
		bc.addNewReading(l1);
		bc.addNewReading(l2);

		System.out.println(bc.getAveragePercentRead(l1) + "\n");
		System.out.println(bc.getAveragePercentRead(l2) + "\n");
		System.out.println(bc.getCompletionPercentage());
	}
}
