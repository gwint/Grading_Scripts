package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		
		Person guy = new Person("Moen", "Aziz", "123456789");
		Student guyStudent = new Student(guy);
		TextBook bookOne = new TextBook("Mustafa", "Hamdan", 100, "TelecomPublishing", 2019, "The Unfinished Nation", "APUSH");
		TextBook bookTwo = new TextBook("Calvin", "Micoli", 200, "AlabamaPublishing", 2017, "Guns, Germs, and Steel", "APWorld");
	
		bookOne.addChapter(3);
		bookOne.addChapter(5);
		
		bookTwo.addChapter(2);
		bookTwo.addChapter(6);
		
		guyStudent.addBook(bookOne);
		guyStudent.addBook(bookTwo);
		
		System.out.println(bookOne);
		System.out.println(bookTwo);
		System.out.println(guyStudent);
		
	}
}
