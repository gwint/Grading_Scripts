package assignment05;

public class StudentTester {
	public static void main(String[] argc) {
		Person person = new Person("Kieran","Gaffney","003541020");
		Student student = new Student(person);
		TextBook text1 = new TextBook("John","Stewart",354,"CC",2015,"The Daily Book","Political Science");
		TextBook text2 = new TextBook("Ron","Johnson", 203,"Penguin", 1969,"The Chicken Game","Animal Husbandry");
		text1.addChapter(6);
		text1.addChapter(7);
		text2.addChapter(9);
		text2.addChapter(13);
		System.out.println(text1.getAssignedChapters());
		System.out.println(text2.getAssignedChapters());
		System.out.println(student);
	}
}
