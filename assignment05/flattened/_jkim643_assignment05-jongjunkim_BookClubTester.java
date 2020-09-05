package assignment05;

public class BookClubTester {
	
	public static void main(String[] args) {

		
	Person human = new Person("jongjun" , "jun" , "999999999");
	Person human2 = new Person("Hana", "Choi", "888888888");
	
	BookClubMember bcm1= new BookClubMember(human);
	BookClubMember bcm2 = new BookClubMember(human2);
	
	LeisureBook leb1 = new LeisureBook("Henry", "Kim" , 40, "Johnson" , 2018, "Education"
										,Genre.NON_FICTION);
	LeisureBook leb2 = new LeisureBook("Gary" , "Choi" , 90, "Andicott", 1999, "Cutting", 
										Genre.MUSICAL);
	
	
	
	
	BookClub bc = new BookClub();
	
	

	bc.addMember(bcm1);
	bc.addMember(bcm2);
	bc.addNewReading(leb1);
	bc.addNewReading(leb2);
	
	bcm1.setPageCount(leb1, 20);
	bcm1.setPageCount(leb2, 50);
	
	bcm2.setPageCount(leb1, 30);
	bcm2.setPageCount(leb2, 40);
	
	System.out.println(bc.getAveragePercentRead(leb1));
	System.out.println(bc.getAveragePercentRead(leb2));
	System.out.println(bc.getCompletionPercentage());
	
	}
}