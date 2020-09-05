package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		Person person = new Person("John", "Doe", "1321246101");
		Student student = new Student(person);
		TextBook text1 = new TextBook("James", "McCord", 6210, "Pub Lisher", 2013, "Criminal Law and Procedure for the Paralegal", "Law");
		TextBook text2 = new TextBook("Gridley", "Mark", 3000, "Stan Smith", 2011, "Jazz Styles: History and Analysis", "Music");
		text1.addChapter(3);
		text2.addChapter(2);
		student.addBook(text1);
		student.addBook(text2);
		System.out.println(text1.getAssignedChapters());
		System.out.println(text2.getAssignedChapters());
		System.out.println(student);
	}
}
