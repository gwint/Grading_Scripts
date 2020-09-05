package assignment05;

public class Tester {
	public static void main(String args[]) {
		
		//Testing Student
		System.out.println("\nTesting Student class:\n");
		
		TextBook t1 = new TextBook("Jacob", "Smith", 534, "Cengage", 2001, "Math for Dummies", "Math 101");
		TextBook t2 = new TextBook("J.K.", "Rowling", 1532, "Penguin", 2019, "Potions and Spells", "Magic 440");
				
		t1.addChapter(1);
		t1.addChapter(3);
		
		t2.addChapter(42);
		t2.addChapter(7);
		
		Person p1 = new Person("Adiel", "Felsen", "123-45-6789");
		Student s = new Student(p1);
		
		s.addBook(t1);
		s.addBook(t2);
		
		System.out.println("Expected: [1, 3]");
		System.out.println("          " + t1.getAssignedChapters());
		
		System.out.println("Expected: [42, 7]");
		System.out.println("          " + t2.getAssignedChapters());
		
		System.out.println("Expected: Adiel Felsen (123-45-6789) taking [Magic 440, Math 101]");
		System.out.println("          " + s);
		
		
		//Testing BookClub
		System.out.println("\nTesting BookClub class:\n");
		
		LeisureBook l1 = new LeisureBook("Stephen", "King", 534, "Scribner", 2011, "11/22/63", Genre.SCIENCE_FICTION);
		LeisureBook l2 = new LeisureBook("F. Scott", "Fitzgerald", 218, "Penguin", 1925, "The Great Gatsby", Genre.HAIKU);
		
		Person p2 = new Person("Alex", "Trebek", "987-65-4321");
		
		BookClubMember m1 = new BookClubMember(p1);
		BookClubMember m2 = new BookClubMember(p2);
		
		BookClub bc = new BookClub();
		bc.addMember(m1);
		bc.addMember(m2);
		bc.addNewReading(l1);
		bc.addNewReading(l2);
		
		m1.setPageCount(l1, 200);
		m1.setPageCount(l2, 100);
		
		m2.setPageCount(l1, 50);
		m2.setPageCount(l2, 200);
		
		System.out.println("Expected: " + (200/534.0+50/534.0)/2*100.0);
		System.out.println("          " + bc.getAveragePercentRead(l1));
		
		System.out.println("Expected: " + (100/218.0+200/218.0)/2*100.0);
		System.out.println("          " + bc.getAveragePercentRead(l2));
		
		System.out.println("Expected: " + (23.408239700374533 + 68.80733944954129)/2);
		System.out.println("          " + bc.getCompletionPercentage());
		
	}
}
