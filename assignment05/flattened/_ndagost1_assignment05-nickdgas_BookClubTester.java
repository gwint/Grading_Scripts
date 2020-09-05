package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		//Make 2 LeisureBooks, 2 BookClubMembers, 1 BookClub with the two members and the 2 books. Test all the averages.
		LeisureBook book1 = new LeisureBook("Nigel", "Cornwall", 200, "Publisher Inc.", 1972, "The Cornwall Code", Genre.NON_FICTION);
		LeisureBook book2 = new LeisureBook("William", "Pinewood", 300, "Publish Inc.", 1874, "The Truth is Within the Pinewood", Genre.BIOGRAPHY);
		Person person1 = new Person("Juan", "Pablo", "123456789");
		Person person2 = new Person("Pablo", "Juan", "987654321");
		BookClubMember member1 = new BookClubMember(person1);
		BookClubMember member2 = new BookClubMember(person2);
		BookClub club = new BookClub();
		club.addMember(member1);
		club.addMember(member2);
		club.addNewReading(book1);
		club.addNewReading(book2);
		member1.setPageCount(book1, 20);
		member1.setPageCount(book2, 150);
		member2.setPageCount(book1, 80);
		member2.setPageCount(book2, 60);
		System.out.println("Percent read of books for first member: " + member1.getPercentRead(book1) +" and " + member1.getPercentRead(book2));
		System.out.println("Percent read of books for second member: " + member2.getPercentRead(book1) +" and " + member2.getPercentRead(book2));
		System.out.println("Average percent read of book1: " + club.getAveragePercentRead(book1));
		System.out.println("Average percent read of book2: " + club.getAveragePercentRead(book2));
		System.out.println("Complete percentage of all averages: " + club.getCompletionPercentage());	
	}
}
