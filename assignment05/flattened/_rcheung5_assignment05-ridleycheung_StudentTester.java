package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		final Person person = new Person("John", "Smith", "1234567890");
		final Student student = new Student(person);
		final TextBook text1 = new TextBook("James", "Johnson", 500, "Best Publisher", 2016, "Java", "CS 140");
		final TextBook text2 = new TextBook("Sara", "Miller", 600, "Bestest Publisher", 2014, "Python", "CS 110");
		
		text1.addChapter(1);
		text1.addChapter(2);
		text2.addChapter(1);
		text2.addChapter(2);
		
		System.out.println(text1.getAssignedChapters());
		System.out.println(text2.getAssignedChapters());
		System.out.println(student);
	}
}
