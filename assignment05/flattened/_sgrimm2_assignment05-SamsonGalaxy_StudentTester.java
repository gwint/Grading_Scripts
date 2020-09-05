package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		Person p = new Person ("Samson", "Grimm", "111223333");
		Student s = new Student (p);
		TextBook t1 = new TextBook("John", "Smith", 1000, "Pearson", 2000, "Intro to Coding", "CS 140");
		t1.addChapter(1);
		t1.addChapter(2);
		s.addBook(t1);
		TextBook t2 = new TextBook("Jane", "Doe", 1001, "Scholastic", 2010, "Intro to Math", "MATH 101");
		t2.addChapter(10);
		t2.addChapter(11);
		s.addBook(t2);
		System.out.println("Assigned for CS 140: " + t1.getAssignedChapters());
		System.out.println("Assigned for MATH 101: " + t2.getAssignedChapters());
		System.out.println(s);
		s.getCourseNames();
		
	}

}
