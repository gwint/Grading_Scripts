package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person newPerson = new assignment05.Person("Farrukh", "Almatov", "637436577");
		Student newStudent = new assignment05.Student(newPerson);
		TextBook cs140 = new assignment05.TextBook("Cole", "Browm", 500, "BingLibraries", 2009, "Java", "CS140" );
		TextBook chem = new assignment05.TextBook("Don", "Frantz", 700, "Boston Books", 2012, "Chemistry", "CHEM107");
		newStudent.addBook(cs140);
		newStudent.addBook(chem);
		cs140.addChapter(5);
		cs140.addChapter(10);
		chem.addChapter(1);
		chem.addChapter(6);
		System.out.println(cs140.getAssignedChapters());
		System.out.println(chem.getAssignedChapters());
		System.out.println(newStudent);

	}	
}
