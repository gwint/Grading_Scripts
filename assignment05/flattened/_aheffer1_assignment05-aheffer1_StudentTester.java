package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person per = new Person("Amanda", "Williams", "333333");
		Student stu = new Student(per);
		TextBook txt1 = new TextBook("Joe", "Loreman", 358, "Binghamton University", 2018,
				"Intro to Number Systems", "Math");
		TextBook txt2 = new TextBook("Daniel", "Smith", 289, "Princeton University", 2019, "Introduction to Quantum Mechanics", "Physics");
		txt1.addChapter(1);
		txt1.addChapter(3);
		txt2.addChapter(1);
		txt2.addChapter(2);
		stu.addBook(txt1);
		stu.addBook(txt2);
		System.out.println(txt1.getAssignedChapters());
		System.out.println(txt2.getAssignedChapters());
		System.out.print(stu);
	}
}
