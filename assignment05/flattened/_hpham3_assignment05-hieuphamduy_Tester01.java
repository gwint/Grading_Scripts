package assignment05;

public class Tester01 {
	public static void main(String[] args) {
		Person person = new Person("Alex", "Scott", "123-13-1221");
		Student student = new Student(person);
		
		TextBook book1 = new TextBook("Hieu", "Pham", 800, "BU", 2019, "How to get an F", "Procastination");
		TextBook book2 = new TextBook("Doug", "Lowe", 900, "Wiley", 2011, "Java All-in-One For Dummies", "Computer Science");
		
		book1.addChapter(11);
		book1.addChapter(22);
		book2.addChapter(33);
		book2.addChapter(44);
		
		student.addBook(book1);
		student.addBook(book2);

		System.out.println(book1.getAssignedChapters());
		System.out.println(book2.getAssignedChapters());
		System.out.println(student);

	}

}
