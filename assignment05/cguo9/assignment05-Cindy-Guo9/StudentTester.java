package assignment05;

public class StudentTester {
	public static void main(String args[]) {
		Person per = new Person("Bob", "Smith", "111-22-3333");
		Student s = new Student(per);
		TextBook cs = new TextBook("Horstmann", "Cay", 700, "Wiley", 2018, "Big Java", "CS140");
		cs.addChapter(6);
		cs.addChapter(7);
		System.out.println("Assigned Chapters: " + cs.getAssignedChapters());
		TextBook chem = new TextBook("Kirst", "Gilbert", 600, "Norton", 2017, "Chemistry", "CHEM107");
		chem.addChapter(2);
		chem.addChapter(3);
		System.out.println("Assigned Chapters: " + chem.getAssignedChapters());
		s.addBook(cs);
		s.addBook(chem);
		System.out.println(s);
	}
}

