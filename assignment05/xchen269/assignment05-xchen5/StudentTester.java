package assignment05;

public class StudentTester {
	public static void main(String[]args) {
		Person p = new Person("Xavier", "Chen", "111001111");
		Student student = new Student(p);
		TextBook t1 = new TextBook("first", "second", 3212, "publisher", 2019, "title", "course1");
		TextBook t2 = new TextBook("first2", "second2", 310, "publisher2", 2018, "title2", "course2");
		t1.addChapter(3);
		t1.addChapter(4);
		t2.addChapter(1);
		t2.addChapter(2);
		System.out.println(t1.getAssignedChapters());
		System.out.println(t2.getAssignedChapters());
		System.out.println(student);
	}
}
