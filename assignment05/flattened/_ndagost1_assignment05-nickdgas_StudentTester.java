package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		//Make one Person, one Student using that Person, and two TextBooks. Assign 2 chapters to each TextBook. Print the getAssignedChapters() values and print the Student.
		Person person = new Person("Juan", "Pablo", "123456789");
		Student student = new Student(person);
		TextBook t1 = new TextBook("Nigel", "Cornwall", 245, "Publisher Inc.", 1972, "The Cornwall Code", "History");
		TextBook t2 = new TextBook("William", "Pinewood", 364, "Publish Inc.", 1874, "The Truth is Within the Pinewood", "Philosophy");
		t1.addChapter(4);
		t1.addChapter(5);
		t2.addChapter(1);
		t2.addChapter(2);
		System.out.println("Assigned Chpaters for TextBook1: " + t1.getAssignedChapters());
		System.out.println("Assigned Chpaters for TextBook2: " + t2.getAssignedChapters());
		System.out.println(student);
	}
}