package assignment05;

public class StudentTester {

	public static void main(String[] args)
	{
		Person kid = new Person("Andrew", "Horihan", "1111-22-3333");
		Student collegeKid = new Student(kid);
		TextBook geology = new TextBook("John", "Smith", 512, "Cengage", 2010, "Rocks and Stuff", "Geology");
		geology.addChapter(5);
		geology.addChapter(6);
		
		TextBook cs = new TextBook("Mark", "Jones", 479, "Pearson", 2015, "Computer Science Basics", "Computer Science");
		cs.addChapter(17);
		cs.addChapter(20);
		
		collegeKid.addBook(geology);
		collegeKid.addBook(cs);
		
		System.out.println(geology.getAssignedChapters());
		System.out.println(cs.getAssignedChapters());
		System.out.println(collegeKid);
	}
}
