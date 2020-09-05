package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		Person me = new Person("John","Doe","123-45-6789");
		Student st = new Student(me);
		TextBook te2 = new TextBook("Mary", "Jane", 50, "Penguin publisher", 2008, "Microprocessors", "CS 120");
		TextBook te = new TextBook("Mary", "Jane", 50, "Penguin publisher", 2008, "Big Java", "CS 140");
		te.addChapter(2);
		te.addChapter(5);
		te2.addChapter(3);
		te2.addChapter(1);
		st.addBook(te);
		st.addBook(te2);
		System.out.println("Assigned chapters should be [2, 5] and it is:");
		System.out.println(te.getAssignedChapters());
		System.out.println("Assigned chapters should be [3, 1] and it is:");
		System.out.println(te2.getAssignedChapters());
		System.out.println(st);
	}

}
