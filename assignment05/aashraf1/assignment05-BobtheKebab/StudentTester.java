package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		
		Person p = new Person("John", "Doe", "123456789");
		Student s = new Student(p);
		
		TextBook t1 = new TextBook("Alan", "Smith", 100, "Harper", 2010, "English Textbook", "English");
		t1.addChapter(1);
		t1.addChapter(3);
		System.out.println(t1.getAssignedChapters());
		
		TextBook t2 = new TextBook("Rob", "Lee", 500, "Union", 2019, "History Textbook", "History");
		t2.addChapter(2);
		t2.addChapter(4);
		System.out.println(t2.getAssignedChapters());
		
		s.addBook(t1);
		s.addBook(t2);
		System.out.println(s);
	}
	
}
