package assignment05;



public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook funBookOne = new LeisureBook("Aiman", "Alobahi", 100, "TelecomPublishing", 2019, "Diary of a Wimpy Kid", Genre.NON_FICTION);
		LeisureBook funBookTwo = new LeisureBook("Ricardo", "Tlatelpa", 200, "ThailandPublishing", 2018, "Captain UnderPants", Genre.MYSTERY);
		LeisureBook funBookThree = new LeisureBook("Ryan", "Meehan", 300, "TeacherPublishing", 2008, "Teaching 101", Genre.BIOGRAPHY);

		Person guy = new Person("Moen", "Aziz", "123456789");
		Person guyTwo = new Person("Benjamin", "Flores", "987654321");
		BookClubMember memberOne = new BookClubMember(guy);
		BookClubMember memberTwo = new BookClubMember(guyTwo);
		
		memberOne.setPageCount(funBookOne, 50);
		memberOne.setPageCount(funBookTwo, 40);
		
		memberTwo.setPageCount(funBookOne, 60);
		memberTwo.setPageCount(funBookTwo, 170);
		
		BookClub emptyClub = new BookClub();
		BookClub club = new BookClub();
		club.addMember(memberOne);
		club.addMember(memberTwo);
		club.addNewReading(funBookOne);
		club.addNewReading(funBookTwo);
		
		System.out.println(memberOne.getPercentRead(funBookThree));
		System.out.println(emptyClub.getCompletionPercentage());
		System.out.println(emptyClub.getAveragePercentRead(funBookThree));
		System.out.println(club.getAveragePercentRead(funBookOne));
		System.out.println(club.getAveragePercentRead(funBookTwo));
		System.out.println(club.getCompletionPercentage());
		
	
	
	}
	
}
