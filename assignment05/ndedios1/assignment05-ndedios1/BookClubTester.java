package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("*********************TESTER FOR BOOK CLUB*********************\n");
		System.out.println("\nLEISURE BOOKS:");
		LeisureBook lbook1 = new LeisureBook("Dragon", "Yang", 100, "GYEOROO Publishing", 1993, "Symphony Tales", Genre.MYSTERY);
		System.out.println(lbook1.toString());
		LeisureBook lbook2 = new LeisureBook("Devin", "Henry", 500, "Henry's House", 2007, "The Affair", Genre.HORROR);
		System.out.println(lbook2.toString());
		
		System.out.println("\nBOOK CLUB MEMBERS:");
		Person person1 = new Person("Richard", "Bellino", "023-11-2365");
		Person person2 = new Person("Saad", "Salman", "088-90-2222");
		System.out.println(person1.toString());
		System.out.println(person2.toString());
		
		BookClubMember bcm1 = new BookClubMember(person1);
		BookClubMember bcm2 = new BookClubMember(person2);
		
		BookClub theBookClub = new BookClub();
		theBookClub.addMember(bcm1);
		theBookClub.addMember(bcm2);
		theBookClub.addNewReading(lbook1);
		theBookClub.addNewReading(lbook2);
		System.out.println("\nREADINGS FOR BOOK CLUB MEMBERS");
		System.out.println("This is the readings for bcm1: " + bcm1.getReadings());
		System.out.println("This is the readings for bcm2: " + bcm2.getReadings()+ "\n");
		

		System.out.println("********TESTING AVERAGE % READ OF BOOK 1 ***********\n");
		bcm1.setPageCount(lbook1, 50);
		bcm2.setPageCount(lbook1, 70);
		System.out.println("bcm1 read " + bcm1.getPercentRead(lbook1) + " of book 1");
		System.out.println("bcm2 read " + bcm2.getPercentRead(lbook1) + " of book 1");
		System.out.println("Expected: 60.0\n" +"Acual: "+ theBookClub.getAveragePercentRead(lbook1));
		
		
		System.out.println("********TESTING AVERAGE % READ OF BOOK 2 ***********\n");
		bcm1.setPageCount(lbook2, 100);
		bcm2.setPageCount(lbook2, 200);
		System.out.println("bcm1 read " + bcm1.getPercentRead(lbook2) + " of book 2");
		System.out.println("bcm2 read " + bcm2.getPercentRead(lbook2) + " of book 2");
		System.out.println("Expected: 30.0\n" +"Acual: "+ theBookClub.getAveragePercentRead(lbook2));
		
		System.out.println("\nCOMPLETION PERCENTAGE of BOOKS:\n" + "Expected: 45.0\n" + "Actual: " + theBookClub.getCompletionPercentage());
	
		System.out.printf("*********************TESTER COMPLETED*********************\n");
	}
	

}
