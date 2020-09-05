package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person author = new Person("Rainbow", "Rowell", "012-34-5678");
		Student newsie = new Student(author);
		TextBook book1 = new TextBook("Rainbow", "Rowell", 345, "Penguin Books", 2015, "Carry On", "War in Fantasy");
		TextBook book2 = new TextBook("Leo", "Tolstoy", 1225, "The Russian Messenger", 1869, "War and Peace", "1800s Russian Lit");
		
		book1.addChapter(61);
		book1.addChapter(62);
		book2.addChapter(1);
		book2.addChapter(2);
		
		System.out.println(book1.getAssignedChapters());
		System.out.println(book2.getAssignedChapters());
		System.out.println(newsie);
	}
}
