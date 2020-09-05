package assignment05;

public class Tester {
//Make 2 LeisureBooks, 2 BookClubMembers, 
//1 BookClub with the two members and the 2 books. Test all the averages.
	public static void main(String[]args) {
		LeisureBook b1 = new LeisureBook("JK", "Rowling", 870, "Scholastic", 2003, "Order of the Phoenix", Genre.FANTASY);
		LeisureBook b2 = new LeisureBook("JRR", "Tolkien", 320, "George Allen & Unwin", 1937, "The Hobbit", Genre.FANTASY);
		//TextBook b3 = new TextBook("JRR", "Tolkien", 320, "George Allen & Unwin", 1937, "The Hobbit", "CS140");
		BookClubMember m1 = new BookClubMember(new Person("Eric", "Shapiro", "666-66-6666"));
		BookClubMember m2 = new BookClubMember(new Person("Jane", "Doe", "123-45-6789"));
		BookClubMember m3 = new BookClubMember(new Person("Barack", "Obama", "230-05-3043"));
		BookClub c = new BookClub();
		c.addMember(m1);
		c.addMember(m2);
		c.addMember(m3);
		c.addNewReading(b1);
		c.addNewReading(b2);
		m1.setPageCount(b1, 870);
		m2.setPageCount(b1, 470);
		m3.setPageCount(b1, 370);
		m1.setPageCount(b2, 80);
		m2.setPageCount(b2, 270);
		m3.setPageCount(b2, 310);
		System.out.println(c.getAveragePercentRead(b1));
		System.out.println(c.getCompletionPercentage());
		//b3.addChapter(2);
		//System.out.println(b3);
	}
}
