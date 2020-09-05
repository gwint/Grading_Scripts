package assignment05;

public class BookClubTester {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeisureBook book1 = new LeisureBook("Doug", "Lowe", 912, "Wiley", 2011, "Java All-in-One For Dummies", Genre.NON_FICTION);
		LeisureBook book2 = new LeisureBook("J.R.R", "Tolkien", 303, "publisher", 1990, "Lord of the Rings: The Fellowship of the Ring", Genre.FANTASY);
		Person person1 = new Person("Anthony", "Longo", "123456789");
		Person person2 = new Person("Mike", "Davis", "111111111");
		BookClubMember member1 = new BookClubMember(person1);
		BookClubMember member2 = new BookClubMember(person2);
		BookClub club = new BookClub();
		club.addMember(member1);
		club.addMember(member2);
		club.addNewReading(book1);
		club.addNewReading(book2);
		
		member1.setPageCount(book1, 524);
		member1.setPageCount(book2, 124);
		member2.setPageCount(book1, 127);
		member2.setPageCount(book2, 202);
		System.out.println("member 1 average for book 1: " + member1.getPercentRead(book1));
		System.out.println("member 1 average for book2: " + member1.getPercentRead(book2));
		System.out.println("member 2 average for book 1: " + member2.getPercentRead(book1));
		System.out.println("member 2 average for book 2: " + member2.getPercentRead(book2));
		System.out.println("club average for book 1: " + club.getAveragePercentRead(book1));
		System.out.println("club average for book 2: " + club.getAveragePercentRead(book2));
		System.out.println("club composite average: " + club.getCompletionPercentage());
	}

}
