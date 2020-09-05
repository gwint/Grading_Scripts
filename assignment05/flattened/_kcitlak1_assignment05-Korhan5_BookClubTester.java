package assignment05;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class BookClubTester {

	public static void main(String[] args) {
		
		LeisureBook humpty = new LeisureBook("Conrad", "Telsea", 100, "Mirco", 2010, "Humpty", Genre.WESTERN);
		LeisureBook Gatsby = new LeisureBook("Steven", "Leius", 300, "Apple", 2009, "Gatsby", Genre.NON_FICTION);
		
		Person korhan = new Person("Korhan", "Citlak", "101000009");
		Person johnny = new Person("Johnny", "Boi", "231456789");
		BookClubMember Korhan = new BookClubMember(korhan);
		BookClubMember Johnny = new BookClubMember(johnny);
		
		BookClub anime = new BookClub();
		anime.addMember(Korhan);
		anime.addMember(Johnny);
		anime.addNewReading(Gatsby);
		anime.addNewReading(humpty);
		
		Korhan.SetPageCount(Gatsby, 100);
		Korhan.SetPageCount(humpty, 20);
		
		Johnny.SetPageCount(Gatsby, 20);
		Johnny.SetPageCount(humpty, 50);
		
		
		
		System.out.println("The Percent of how much Johnny Read of humpty");
		System.out.println(Johnny.getPercentRead(humpty));
		
		System.out.println("The Percent of how much Johnny Read of Gatsby");
		System.out.println(Johnny.getPercentRead(Gatsby));
		
		
		System.out.println("The Percent of how much Korhan Read of humpty");
		System.out.println(Korhan.getPercentRead(humpty));
		
		System.out.println("The Percent of how much Korhan Read of Gatsby");
		System.out.println(Korhan.getPercentRead(Gatsby));
		
		System.out.println("Total Average of everyone reading humpty");
		System.out.println(anime.getAveragePercentRead(humpty));
		
		System.out.println("Total Average of everyone reading Gatsby");
		System.out.println(anime.getAveragePercentRead(Gatsby));
		
		System.out.println("Total Average for reading every book combined");
		System.out.println(anime.getCompletionPercentage());
	}

}
