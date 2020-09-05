package assignment05;

public class studentTester {
	public static void main(String[] args) {
		Person prsn1 = new Person("Darren", "Lama", "023-16-2995");
		Student stdnt1 = new Student(prsn1);
		TextBook tb1 = new TextBook("John", "Doe", 300, "Penguin", 2005, "Who is John?", "English");
		TextBook tb2 = new TextBook("Jane", "Ode", 2, "Seal", 2015, "Where is Jane?", "Geography");
		tb1.addChapter(1);
		tb1.addChapter(2);
		tb2.addChapter(3);
		tb2.addChapter(4);
		stdnt1.addBook(tb1);
		stdnt1.addBook(tb2);
		System.out.println(tb1.getAssignedChapters());
		System.out.println(tb2.getAssignedChapters());
		System.out.println(stdnt1);
		
	}
}
