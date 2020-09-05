package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person p = new Person("Adam", "Kunz", "123456789");
		Student s = new Student(p);
		TextBook t1 = new TextBook("Michael", "Chazan", 460, "Routledge", 2018, 
				"World Prehistory and Archaeology", "Introduction to Anthropology");
		TextBook t2 = new TextBook("Sara", "Baase", 536, "Pearson", 2018, 
				"A Gift of Fire: Social, Legal, and Ethical Issues for Computing Technology", 
				"Ethical, Social, and Global Issues in Computing");
		
		t1.addChapter(2);
		t2.addChapter(2);
		s.addBook(t1);
		s.addBook(t2);
		System.out.println(t1.getAssignedChapters());
		System.out.println(t2.getAssignedChapters());
		System.out.println(s.toString());
	}
}