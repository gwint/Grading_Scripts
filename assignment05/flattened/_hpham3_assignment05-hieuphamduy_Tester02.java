package assignment05;

public class Tester02 {
	public static void main(String[] args) {
		LeisureBook book1 = new LeisureBook("Hieu", "Pham", 800, "BU", 2019, "How to get an F", Genre.BIOGRAPHY);
		LeisureBook book2 = new LeisureBook("Doug", "Lowe", 900, "Wiley", 2011, "Java All-in-One For Dummies", Genre.NON_FICTION);
		
		Person person1 = new Person("Alex", "Scott", "123-13-1221");
		Person person2 = new Person("Dan", "Quinn", "124-23-8923");
		BookClubMember member1 = new BookClubMember(person1);
		BookClubMember member2 = new BookClubMember(person2);
		
		
		BookClub club = new BookClub();
		club.addNewReading(book1);
		club.addNewReading(book2);
		club.addMember(member1);
		club.addMember(member2);
		member1.setPageCount(book1, 400);
		member1.setPageCount(book2, 450);
		member2.setPageCount(book1, 200);
		member2.setPageCount(book2, 225);


		System.out.println(club.getCompletionPercentage());

	} 
}
