package assignment05;
import java.util.*;


class StudentTester {
	public static void main(String[] args) {
		Person p1 = new Person("notjavier", "notliu", "888888888");
		Student s1 = new Student(p1);
		Textbook t1 = new Textbook("CS140", "cbafirstname", "abclastname", 140, "real publisher", 2019, "java objects");
		t1.addChapter(1);
		t1.addChapter(21);
		Textbook t2 = new Textbook("CS240", "hehaw", "hawhe", 240, "fake publisher", 9102, "avaj objects");
		t1.addChapter(31);
		t2.addChapter(125);
		s1.addBook(t1);
		s1.addBook(t2);
		System.out.println("t1 assigned chapters: " + t1.getAssignedChapters() + "\n");
		System.out.println("t2 assigned chapters: " + t2.getAssignedChapters() + "\n");
		System.out.println(s1);
	}
}
