package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person person1 = new Person("Kevin", "Agyapong", "4444444");
		Student student1 = new Student(person1);
		TextBook textBook1 = new TextBook("Lois", "Lowry", 197, "Houghton Mifflin Harcourt", 1993, "The Giver", "WRIT 111");
		TextBook textBook2 = new TextBook("Ray", "Bradbury", 275, "Ballantine Books", 1953, "Fahrenheit 451", "CRW 231");
		student1.addBook(textBook1);
		textBook1.addChapter(7);
		textBook1.addChapter(4);
		textBook2.addChapter(6);
		textBook2.addChapter(5);
		
		System.out.println(textBook1.getAssignedChapters());
		System.out.println(textBook2.getAssignedChapters());
		System.out.println(student1);
	}
}