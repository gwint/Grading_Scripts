package assignment05;

public class BookClubTester {

	public static void main(String[] args)
	{
		//List<Person> recommended = new ArrayList<>();
		Person person1 = new Person("Brandon", "Nimmo", "876544321");
		Person person2 = new Person("Jake", "deGrom", "123445678");
		
		LeisureBook book1 = new LeisureBook("Bill", "Bryson", 300,
				"Random House", 2003, "A Short History of Nearly Everything",
				Genre.NON_FICTION);
		LeisureBook book2 = new LeisureBook("Richard", "Dawkins", 350,
				"Penguin", 2004, "The God Delusion", Genre.NON_FICTION);
	
		BookClubMember member1 = new BookClubMember(person1);
		BookClubMember member2 = new BookClubMember(person2);
		
		member1.addReading(book1);
		member1.addReading(book2);
		
		member1.setPageCount(book1, 100);
		member1.setPageCount(book2, 150);
		
		System.out.println("Book one percentages: ");
		System.out.println(member1.getPercentRead(book1));
		System.out.println(member1.getPercentRead(book2));
		
		member2.addReading(book1);
		member2.addReading(book2);
		
		member2.setPageCount(book1, 120);
		member2.setPageCount(book2, 160);
		
		System.out.println("Book two percentages: ");
		System.out.println(member2.getPercentRead(book1));
		System.out.println(member2.getPercentRead(book2));
		
		BookClub club = new BookClub();
		club.addMember(member1);
		club.addMember(member2);
		club.addNewReading(book1);
		club.addNewReading(book2);
		
		System.out.println("Book one average completion: ");
		System.out.println(club.getAveragePercentRead(book1));
		System.out.println("Book two average completion: ");
		System.out.println(club.getAveragePercentRead(book2));
		
		System.out.println("Total completion percentage: ");
		System.out.println(club.getCompletionPercentage());
	}
}
