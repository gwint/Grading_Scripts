package assignment05;

public class BookClubTester {

	
	public static void main(String[] args) {
		
		Person Jeff = new Person("Jeff","Golden","243-78-5079");
		Person Harry = new Person("Harry","Harrington","123-45-6789");
		BookClubMember J = new BookClubMember(Jeff);
		BookClubMember H = new BookClubMember(Harry);
		
		LeisureBook Orwell = new LeisureBook("George","Orwell",328,"Harvill Secker", 1949,"1984", Genre.DYSTOPIA);
		LeisureBook Mice = new LeisureBook("John","Steinbeck",187,"Pascal Covici",1937,"Of Mice and Men",Genre.TRAGEDY);
		
		BookClub Readers = new BookClub();
		Readers.addMember(J);
		Readers.addMember(H);
		
		Readers.addNewReading(Orwell);
		Readers.addNewReading(Mice);
		
		J.setPageCount(Orwell, 150);
		H.setPageCount(Orwell, 47);
		J.setPageCount(Mice, 23);
		H.setPageCount(Mice, 167);
		
		System.out.println("Testing getAveragePercentRead method for 1984 and Of Mice and Men respectively: ");
		System.out.println(Readers.getAveragePercentRead(Orwell));
		System.out.println(Readers.getAveragePercentRead(Mice));
		
		System.out.println("Testing getCompletitionPercent method for all books: ");
		System.out.println(Readers.getCompletionPercentage());
		
		
		
		
	}
}
