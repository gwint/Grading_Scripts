package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person p = new Person("Colin", "McRae", "674628375");
		Student s = new Student(p);
		TextBook t1 = new TextBook("Cay", "Horstmann", 1444, "Wiley", 2015, "Big Java Early Objects", "CS140");
		TextBook t2 = new TextBook("Sebastien", "Loeb", 587, "Citroen", 2015, "Rally Driving", "WRC9000");
		t1.addChapter(3);
		t1.addChapter(5);
		t2.addChapter(10);
		t2.addChapter(11);
		s.addBook(t1);
		s.addBook(t2);
		System.out.println(t1.getAssignedChapters());
		System.out.println(t2.getAssignedChapters());
		System.out.println(s);
	}
}
