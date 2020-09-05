package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		Person person1 = new Person("Joe", "Smith", "123456789");
		Student student1 = new Student(person1);
		
		TextBook textbook1 = new TextBook("John", "Jacobs", 700, "Facts on File", 2000, "Fundementals of Physics", "Physics");
		TextBook textbook2 = new TextBook("John", "Jacobs", 900, "Facts on File", 2004, "Fundementals of Pyschology", "Pyschology");
		
		textbook1.addChapter(1);
		textbook1.addChapter(2);
		
		textbook2.addChapter(3);
		textbook2.addChapter(4);
		
		System.out.println(textbook1.getAssignedChapters());
		System.out.println(textbook2.getAssignedChapters());
		
		student1.addBook(textbook1);
		student1.addBook(textbook2);
		
		System.out.println(student1);
		
		}
}
