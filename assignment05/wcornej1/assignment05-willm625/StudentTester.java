package assignment05;


public class StudentTester {
	public static void main(String[] args) {
		Person per = new Person("Jim", "Ross", "111111111");
		Student stu = new Student(per);
		TextBook t1 = new TextBook("Will", "Ali", 300, "Pearson", 2019, "Learning Physcology", "Physcology");
		TextBook t2 = new TextBook("Mo", "Campbell", 400, "Gutenberg", 2018, "How to Improve Writing", "Writing");
		stu.addBook(t1);
		stu.addBook(t2);
		t1.addChapter(1);
		t1.addChapter(2);
		t2.addChapter(4);
		t2.addChapter(3);
		System.out.println(t1.getAssignedChapters());
		System.out.println(t2.getAssignedChapters());
		System.out.println(stu);
		
	}

}
