package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		final LeisureBook leisure1 = new LeisureBook("Bill", "Brown", 200, "Best Publisher", 2016, "Ghost", Genre.HORROR);
		final LeisureBook leisure2 = new LeisureBook("Dan", "Li", 300, "Best Publisher", 2016, "Dragon", Genre.FANTASY);
		final Person person1 = new Person("John", "Smith", "1234567890");
		final BookClubMember member1 = new BookClubMember(person1);
		final Person person2 = new Person("Jane", "Doe", "0987654321");
		final BookClubMember member2 = new BookClubMember(person2);
		final BookClub club = new BookClub();
		
		club.addMember(member1);
		club.addMember(member2);
		club.addNewReading(leisure1);
		club.addNewReading(leisure2);
	}
}
