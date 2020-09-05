package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person ps = new Person("Willy","Dom","744176220");
		Student std = new Student(ps);
		TextBook tbk1 = new TextBook("Doras", "Floral", 200, "HTC", 2000, "Nice Book","ARTH");
		TextBook tbk2 = new TextBook("Fini", "Auri", 400, "APC", 2004, "Good Book","BIOL");
		tbk1.addChapter(2);
		tbk1.addChapter(4);
		tbk2.addChapter(3);
		tbk2.addChapter(6);
		std.addBook(tbk1);
		std.addBook(tbk2);
		System.out.println(tbk1.getAssignedChapters());
		System.out.println(tbk2.getAssignedChapters());
		System.out.println(std);
	}
}
