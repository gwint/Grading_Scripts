package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person person = new Person("John", "Smith", "420698008");
		Student student = new Student(person);
		TextBook text1 = new TextBook("Marcus", "Muffoletto", 420, "Penguin Inc.", 1999, "How to not Suck", "Self Improvement 101");
		TextBook text2 = new TextBook("Nick", "Dags", 1000, "LifeSaver Inc.", 2019, "Why You Shouldn't Be Like Me", "Self Improvement 101");
		text1.addChapter(1);
		text1.addChapter(2);
		text2.addChapter(1);
		text2.addChapter(2);
		System.out.println(text1.getAssignedChapters());
		System.out.println(text2.getAssignedChapters());
		System.out.println(student);
	}
}