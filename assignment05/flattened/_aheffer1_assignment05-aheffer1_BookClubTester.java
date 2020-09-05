package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook lei1 = new LeisureBook("Gary", "Weissberg", 209, "IBM",
				2019, "A book about something", Genre.MEMOIR);
		LeisureBook lei2 = new LeisureBook("Mary", "Susan", 353, "Macmillan", 2017, "Astronaut", Genre.SCIENCE_FICTION);
		BookClubMember mem1 = new BookClubMember(new Person("Donald", "Trump", "111111"));
		BookClubMember mem2 = new BookClubMember(new Person("Hillary", "Clinton", "222222"));
		BookClub club = new BookClub();
		club.addMember(mem1);
		club.addMember(mem2);
		club.addNewReading(lei1);
		club.addNewReading(lei2);
		mem1.setPageCount(lei1, 52);
		mem2.setPageCount(lei1, 63);
		mem1.setPageCount(lei2, 140);
		mem2.setPageCount(lei2, 172);
		System.out.println(club.getAveragePercentRead(lei1));
		System.out.println(club.getAveragePercentRead(lei2));
		System.out.println(club.getCompletionPercentage());
	}
}
