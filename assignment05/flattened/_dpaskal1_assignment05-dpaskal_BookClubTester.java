package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook bookOne = new LeisureBook("Joanne", "Rowling", 500, "Penguin Books", 2012, "HarryPotter", Genre.FANTASY);
		System.out.println("bookOne = " + bookOne);
		LeisureBook bookTwo = new LeisureBook("Noam", "Chomsky", 1000, "Penguin Books", 2005, "Linguistics", Genre.NON_FICTION);
		System.out.println("bookTwo = " + bookTwo);
		Person me = new Person("Daniel", "Paskalev", "123-45-6789");
		Person me2 = new Person("John", "Doe", "9876-54-321");
		
		BookClubMember bcm1 = new BookClubMember(me);
		BookClubMember bcm2 = new BookClubMember(me2);
		
		BookClub club = new BookClub();
		club.addMember(bcm1);
		club.addMember(bcm2);
		club.addNewReading(bookOne);
		club.addNewReading(bookTwo);
		System.out.println("Testing averages when 0 total pages read:");
		System.out.println("getAveragePercentRead book1: " + club.getAveragePercentRead(bookOne) + "%");
		System.out.println("getAveragePercentRead book2: " + club.getAveragePercentRead(bookTwo) + "%");
		System.out.println("getCompletionPercentage:     " + club.getCompletionPercentage() + "%");
		
		bcm1.setPageCount(bookOne, 250);
		bcm1.setPageCount(bookTwo, 400);
		
		bcm2.setPageCount(bookOne, 250);
		bcm2.setPageCount(bookTwo, 300);
		System.out.println("bcm1 reads 250/500  pages of book 1");
		System.out.println("bcm1 reads 400/1000 pages of book 2");
		System.out.println("bcm2 reads 250/500  pages of book 1");
		System.out.println("bcm2 reads 300/1000 pages of book 2");
		
		System.out.println("getAveragePercentRead book1: " + club.getAveragePercentRead(bookOne) + "%");
		System.out.println("getAveragePercentRead book2: " + club.getAveragePercentRead(bookTwo) + "%");
		System.out.println("getCompletionPercentage:     " + club.getCompletionPercentage() + "%");
		try {
			System.out.println("Attempting to read a negative amount of pages (-5)");
			System.out.println("Expected output: Bad input.");
			bcm1.setPageCount(bookOne, -5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
