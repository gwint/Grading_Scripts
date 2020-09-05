package assignment05;


public class BookClubTester {
	public static void main(String args[]) {
		Person aRod = new Person ("Alex", "Rodriguez", "122-55-7893");
		Person judge = new Person("Aaron", "Judge","255-66-7892");
		LeisureBook book1  = new LeisureBook("Kenny", "Gell", 500, "Wiley", 2000, "Harry Potter", Genre.FANTASY);
		LeisureBook book2  = new LeisureBook("National", "Geographic", 1000, "Gell", 2019, "WILD LIFE", Genre.NON_FICTION);
		BookClubMember member1 = new BookClubMember(aRod);
		BookClubMember member2 = new BookClubMember(judge);
		member1.setPageCount(book1,400);
		member2.setPageCount(book1, 300);
		member1.setPageCount(book2,900);
		member2.setPageCount(book2, 500);
		BookClub kennysBookClub = new BookClub();
		kennysBookClub.addMember(member1);
		kennysBookClub.addMember(member2);
		kennysBookClub.addNewReading(book1);
		kennysBookClub.addNewReading(book2);
		
		
		System.out.println("**** Member 1 getPercentRead Books 1 and 2 Expected: 80.0 , 90.0 ****");
		System.out.println("Book1: " + " " + member1.getPercentRead(book1));
		System.out.println("Book2: " + " " + member1.getPercentRead(book2));
		
		System.out.println("**** Member 2 getPercentRead Books 1 and 2 Expected: 60.0, 50.0 ****");
		System.out.println("Book1: " + " " + member2.getPercentRead(book1));
		System.out.println("Book2: " + " " + member2.getPercentRead(book2));
		
		System.out.println("**** Test getAveragePercentRead Book1 Excpected: 70.0 ****");	
		System.out.println(kennysBookClub.getAveragePercentRead(book1));
		System.out.println("**** Test getAveragePercentRead Book2 Expected: 70.0 ****");	
		System.out.println(kennysBookClub.getAveragePercentRead(book2));
		System.out.println("**** Test getCompletionPercentage Expected: 70.0 ****");	
		System.out.println(kennysBookClub.getCompletionPercentage());
		
		
	}
}
