package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook b1 = new LeisureBook("J. K.", "Rowling", 336,"Scholastic", 1999, "Harry Potter And The Sorcerer's Stone",Genre.SCIENCE_FICTION);
		LeisureBook b2 = new LeisureBook("Suzanne", "Collins", 374,"Scholastic Press", 2008, "The Hunger Games",Genre.SCIENCE_FICTION);
		Person pete= new Person("Pete", "Davidson","123-45-6789");
		Person dave= new Person("Pete", "Davidson","987-65-4321");
		BookClubMember m1 =new BookClubMember(pete);
		BookClubMember m2 =new BookClubMember(dave);
		BookClub c1 = new BookClub();
		c1.addMember(m1);
		c1.addMember(m2);
		c1.addNewReading(b1);
		c1.addNewReading(b2);
		m1.setPageCount(b1, 123);
		m1.setPageCount(b2, 223);
		m2.setPageCount(b1, 300);
		m2.setPageCount(b2, 274);
		System.out.println("");
		System.out.println("Numbers are not exact since I am not using Assertions");
		System.out.println("");
		System.out.println("Testing BookClubMember  getPercentRead");
		System.out.println("Expected Output for pete book 1: " +  36.6);
		System.out.println(m1.getPercentRead(b1));
		System.out.println("Expected Output for pete book 2: " +  59.6);
		System.out.println(m1.getPercentRead(b2));
		System.out.println("Expected Output for dave book 1: " +  89.2);
		System.out.println(m2.getPercentRead(b1));
		System.out.println("Expected Output for dave book 2: " +  73.2);
		System.out.println(m2.getPercentRead(b2));
		System.out.println("");
		System.out.println("Testing BookClub  getAveragePercentRead");
		System.out.println("Expected Output for book 1: " +  62.9);
		System.out.println(c1.getAveragePercentRead(b1));
		System.out.println("Expected Output for book 2: " +  66.4);
		System.out.println(c1.getAveragePercentRead(b2));
		System.out.println("");
		System.out.println("Testing BookClub  getCompletionPercentage");
		System.out.println("Expected Output for the BookClub: " +  64.7);
		System.out.println(c1.getCompletionPercentage());
		
	}

}
