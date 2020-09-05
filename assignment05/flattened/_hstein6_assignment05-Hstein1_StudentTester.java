package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		Person person1 = new Person("Hank", "Stein", "012345678");
		Student student1 = new Student(person1);
		TextBook textbook1 = new TextBook("John", "Wilkins", 587, "Penguin Publishing House", 
				2007, "Learning Java", "CS 140");
		TextBook textbook2 = new TextBook("Mike", "Thomas", 722, "Binghamton Printing", 
				1992, "How to write in English", "ENG 101");
		textbook1.addChapter(1);
		textbook1.addChapter(2);
		textbook2.addChapter(1);
		textbook2.addChapter(2);
		System.out.println(textbook1.getAssignedChapters());
		System.out.println(textbook2.getAssignedChapters());
		System.out.println(student1);

	}

}
