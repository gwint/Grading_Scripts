package assignment05;

public class Tester {
	public static void main(String[] args) {
		Person person1 = new Person("Bob", "Green", "123456789");
		Student Josh = new Student(person1);
		TextBook historyBook = new TextBook("John", "Carter", 200, "Penguin", 1993,
				"History Book", "History");
		TextBook mathBook = new TextBook("Dan", "Greene", 300, "Pengu", 1593,
				"Math Book", "Math");
		
		historyBook.addChapter(2);
		historyBook.addChapter(3);
		mathBook.addChapter(6);
		mathBook.addChapter(7);
		Josh.addBook(historyBook);
		Josh.addBook(mathBook);
		System.out.println(historyBook.getAssignedChapters());
		System.out.println(mathBook.getAssignedChapters());
		System.out.println(Josh);
		System.out.println("");
		
		LeisureBook funBook1 = new LeisureBook("Babe", "Ruth", 400, "Pepa",
				2014, "Peppa Pig", Genre.DETECTIVE_STORY);
		LeisureBook funBook2 = new LeisureBook("Caleb", "Ruth", 540, "Pepa",
				2016, "Pingu", Genre.DYSTOPIA);
		Person person2 = new Person("Cob", "Green", "123456749");
		Person person3 = new Person("Stob", "Green", "123456289");
		BookClubMember bcm1 = new BookClubMember(person2);
		BookClubMember bcm2 = new BookClubMember(person3);
		BookClub bookClub = new BookClub();
		bookClub.addMember(bcm1);
		bookClub.addMember(bcm2);
		bookClub.addNewReading(funBook1);
		bookClub.addNewReading(funBook2);
		System.out.println(bookClub.getAveragePercentRead(funBook1));
		System.out.println(bookClub.getAveragePercentRead(funBook2));
		System.out.println(bookClub.getCompletionPercentage());
	}
}
