package assignment05;

public class PersonTester{
	public static void main(String[] args) {
		Person person = new Person("John", "Smith", "200-20-2000");
		Student student = new Student("John", "Smith", "200-20-2000", person);
		TextBook tbook = new TextBook("Williams", "Johnson", 250, "Persona", 1976, "The Great Big Whale", "History");
		TextBook tbook2 = new TextBook("Joe", "Wright", 200, "LightNovel", 1999, "The Shinning Star", "English");
		tbook.addChapter(2);
		tbook.addChapter(3);
		tbook2.addChapter(4);
		tbook2.addChapter(5);
		student.addBook(tbook);
		
		System.out.println("The assigned chapter for tbook is " + tbook.getAssignedChapters());
		System.out.println("The assigned chapter for tbook2 is " + tbook2.getAssignedChapters());
		System.out.println("The student is " + student);
	}
}
