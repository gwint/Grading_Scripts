package assignment05;


public class StudentTester {
	public static void main(String[] args) {
		System.out.println("************* Test For Student **************");
		Person person1 = new Person("Jane", "Doe", "670-08-9823");
		Student student1 = new Student(person1);
		TextBook book1 = new TextBook("Larry", "Gerstein", 340, "Springer", 2017, "Introduction to Mathematiccal Structures and Proofs", "Math330");
		TextBook book2 = new TextBook("Horstmann", "Cay", 967, "WIley", 2018, "Big Java: Early Objects", "CS140");
		
		student1.addBook(book1);
		student1.addBook(book2);
		
		book1.addChapter(9);
		book1.addChapter(5);
		book2.addChapter(6);
		book2.addChapter(3);
		
		
		System.out.println("Student: " + student1.toString());
		System.out.println("Class: " + book1.getCourseName() + " with assigned chapters: " + book1.getAssignedChapters());
		System.out.println("Class: " + book2.getCourseName() + " with assigned chapters: " + book2.getAssignedChapters());
		//System.out.println("Book 2 and its assigned chapters: " + book2.toString());
		//System.out.println(book1.getAssignedChapters());
		
	}
	
	
	
	
	
	
}
