package assignment05;

public class StudentTester {
	
	public static void main(String[] args) {
		System.out.println("-----TESTER FOR STUDENT-----");
		Person john = new Person("John", "Smith", "123456789");
		Student studentJohn = new Student(john);
		TextBook book1 = new TextBook("Larry", "Jackson", 580, "BookPublishers, Inc.", 
						 2005, "Calculus for Dummies", "Calculus I");
		TextBook book2 = new TextBook("Thomas", "Page", 904, "Penguin, Inc.", 
				 2018, "Art History for Beginners", "Art History");
		studentJohn.addBook(book1);
		studentJohn.addBook(book2);
		book1.addChapter(7);
		book1.addChapter(8);
		book2.addChapter(2);
		book2.addChapter(3);
		System.out.println(studentJohn);
		System.out.println("Chapters assigned from " + book1.getTitle() + ": " + book1.getAssignedChapters());
		System.out.println("Chapters assigned from " + book2.getTitle() + ": " + book2.getAssignedChapters());
		
	}
}
