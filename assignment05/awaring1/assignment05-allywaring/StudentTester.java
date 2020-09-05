package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person p1 = new Person("Ally", "Waring", "1234567");
		Student s1 = new Student(p1);
		TextBook tb1 = new TextBook("William", "Shakespeare", 250, "Binghamton", 1997, "Hamlet", "English 101");
		TextBook tb2 = new TextBook("John", "Green", 750, "Setauket", 2005, "Paper Towns", "History 107");
		s1.addBook(tb1);
		tb1.addChapter(2);
		tb1.addChapter(4);
		tb2.addChapter(7);
		tb2.addChapter(9);
		
		System.out.println(tb1.getAssignedChapters());
		System.out.println(tb2.getAssignedChapters());
		System.out.println(s1);
	}
}
