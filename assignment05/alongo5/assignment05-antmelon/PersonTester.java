package assignment05;

public class PersonTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person testPerson = new Person("Anthony", "Longo", "123456789");
		Student testStudent = new Student(testPerson);
		TextBook book1 = new TextBook("James", "Clear", 200, "Avery", 2010, "Atomic Habits", "Philosophy 101" );
		TextBook book2 = new TextBook("Jeff", "Guy", 220, "Avery", 1997, "C Programming", "CS 120" );
		book1.addChapter(12);
		book1.addChapter(3);
		book2.addChapter(1);
		book2.addChapter(15);
		testStudent.addBook(book1);
		testStudent.addBook(book2);
		System.out.println(book1.getAssignedChapters());
		System.out.println(book2.getAssignedChapters());
		System.out.println(testStudent);
	}

}
