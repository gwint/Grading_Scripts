package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		Person p = new Person("Jack", "Ruffner", "555-33-9999");
		Student stu = new Student(p);
		TextBook t1 = new TextBook("John", "Doe", 550, "Penguin Publishing", 2001, "Organic Chemistry 3rd Edition", "CHEM 231");
		TextBook t2 = new TextBook("Maria", "Smith", 478, "Smith Publishers", 2011, "Digital Design and Computer Architecture", "CS 120");
		t1.addChapter(2);
		t1.addChapter(3);
		t2.addChapter(5);
		t2.addChapter(7);
		stu.addBook(t1);
		stu.addBook(t2);
		
		System.out.println(t1.getAssignedChapters());
		System.out.println(t2.getAssignedChapters());
		System.out.println(stu);
		
	}

}
