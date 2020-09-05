package assignment05;

public class BookClubTester {

	public static void main(String[] args)
	{
		LeisureBook hg = new LeisureBook("Suzanne", "Collins", 200, "Scholastic", 2008, "The Hunger Games", Genre.DYSTOPIA);
		LeisureBook cw = new LeisureBook("E. B.", "White", 200, "Harper & Brothers", 1952, "Charlotte's Web", Genre.FANTASY);
		
		Person kid1 = new Person("Andrew", "Horihan", "111-22-3333");
		Person kid2 = new Person("Bob", "Smith", "122-22-3333");
		
		BookClubMember m1 = new BookClubMember(kid1);
		BookClubMember m2 = new BookClubMember(kid2);
		
		BookClub club = new BookClub();
		club.addMember(m1);
		club.addMember(m2);
		club.addNewReading(hg);
		club.addNewReading(cw);
		
		m1.setPageCount(hg, 0); //0%
		m1.setPageCount(cw, 0); //0%
		
		m2.setPageCount(hg, 200); //100%
		m2.setPageCount(cw, 50); //25%
		
		System.out.println("Expected Average Percent Read for Hunger Games: 50.0%\nActual: " + club.getAveragePercentRead(hg) + "%");
		System.out.println("Expected Average Percent Read for Charlotte's Web: 12.5%\nActual: " + club.getAveragePercentRead(cw) + "%");
		
		System.out.println("Expected Completion Percentage: 31.25%\nActual: " + club.getCompletionPercentage() + "%");
		
	}
	
}
