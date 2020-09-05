package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person p1 = new Person("Ben", "Martinez", "1234567");
		Student s1 = new Student(p1);
		TextBook tb1 = new TextBook("Ernest", "Hemingway", 250, "Oak Park", 1990, "The Sun Also Rises", "English 101");
		TextBook tb2 = new TextBook("William", "Shakespeare", 800, "Birmingham", 1999, "Twelfth Night", "History 102");
		s1.addBook(tb1);
		tb1.addChapter(2);
		tb1.addChapter(3);
		tb2.addChapter(8);
		tb2.addChapter(9);
		
		System.out.println(tb1.getAssignedChapters());
		System.out.println(tb2.getAssignedChapters());
		System.out.println(s1);
	}
}
