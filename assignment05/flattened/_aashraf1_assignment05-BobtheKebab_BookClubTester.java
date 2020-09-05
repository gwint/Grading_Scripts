package assignment05;

public class BookClubTester {
	
	public static void main(String[] args) {
		
		LeisureBook b1 = new LeisureBook("Alan", "Smith", 100, "Harper", 2010, "Book 1", Genre.NON_FICTION);
		LeisureBook b2 = new LeisureBook("Rob", "Lee", 500, "Union", 2019, "Book 2", Genre.MYSTERY);
		
		Person p1 = new Person("John", "Doe", "123456789");
		BookClubMember m1 = new BookClubMember(p1);
		Person p2 = new Person("Jane", "Eyre", "987654321");
		BookClubMember m2 = new BookClubMember(p2);
		
		BookClub club = new BookClub();
		club.addMember(m1);
		club.addMember(m2);
		club.addNewReading(b1);
		club.addNewReading(b2);
		
		m1.setPageCount(b1, 25);
		m1.setPageCount(b2, 500);
		m2.setPageCount(b1, 75);
		m2.setPageCount(b2, 300);
		
		System.out.println(club.getAveragePercentRead(b1));
		System.out.println(club.getAveragePercentRead(b2));
		System.out.println(club.getCompletionPercentage());
		
	}

}
