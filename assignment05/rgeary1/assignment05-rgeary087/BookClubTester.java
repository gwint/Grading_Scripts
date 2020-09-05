package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook book1 = new LeisureBook("Ryan", "Geary", 500, "Penguin", 2001, 
				"Harry Potter", Genre.FANTASY);
		LeisureBook book2 = new LeisureBook("Ryan", "Geary", 1000, "Penguin", 2001, 
				"LOTR", Genre.NON_FICTION);
		System.out.println(book1);
		System.out.println(book2);
		Person p1 = new Person("Ryan", "Geary", "400-00-0000");
		Person p2 = new Person("Caitlyn", "Geary", "111-11-1111");
		BookClubMember bcm1 = new BookClubMember(p1);
		BookClubMember bcm2 = new BookClubMember(p2);
		
		BookClub bc = new BookClub();
		bc.addMember(bcm1);
		bc.addMember(bcm2);
		
		bc.addNewReading(book1);
		bc.addNewReading(book2);
		
		bcm1.setPageCount(book1, 250);
		bcm1.setPageCount(book2, 500);
		
		bcm2.setPageCount(book1, 50);
		bcm2.setPageCount(book2, 100);
		
		
		System.out.println("Expected: 50.0: " + bcm1.getPercentRead(book1));
		System.out.println("Expected: 50.0: " + bcm1.getPercentRead(book2));
		
		System.out.println("Expected: 10.0: " + bcm2.getPercentRead(book1));
		System.out.println("Expected: 10.0: " + bcm2.getPercentRead(book2));
		
		System.out.println("Expected: 30.0: " + bc.getAveragePercentRead(book1));
		System.out.println("Expected: 30.0: " + bc.getAveragePercentRead(book2));
		
		System.out.println("Expected: 30.0: " + bc.getCompletionPercentage());
		
		System.out.println("-----------------------------------");
		System.out.println("***TESTS FOR STUDENT AND CLASSES***");
		Student s = new Student(p1);
		TextBook t1 = new TextBook("Phillip", "Giancoli", 1350, "Scholastic", 1994, "Physics for Students", "Physics");
		TextBook t2 = new TextBook("James", "Stewart", 800, "Scholastic", 2000, "Calculus Textbook", "Calculus");
		
		s.addBook(t1);
		s.addBook(t2);
		
		System.out.println(s);
		
	}
}
