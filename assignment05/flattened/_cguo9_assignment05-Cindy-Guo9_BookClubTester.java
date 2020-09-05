package assignment05;

public class BookClubTester {

	public static void main(String args[]) {
		LeisureBook lb = new LeisureBook("William", "Golding", 250, "Faber and Faber", 1954,
				"Lord of the Flies", Genre.DYSTOPIA);
		LeisureBook lb2 = new LeisureBook("J.D.", "Salinger", 300, "Little, Brown and Company", 1951,
				"The Catcher in the Rye", Genre.SATIRE);
		Person per = new Person("Joey", "Le", "111-22-3333");
		Person per2 = new Person("Victora", "Lin", "444-55-6666");
		BookClubMember jo = new BookClubMember(per);
		BookClubMember vic = new BookClubMember(per2);
		BookClub bc = new BookClub();
		bc.addMember(jo);
		bc.addMember(vic);
		bc.addNewReading(lb);
		bc.addNewReading(lb2);
		
		jo.setPageCount(lb, 25);
		jo.setPageCount(lb2, 150);
		System.out.println("Test for Jo % read: Book1 " + jo.getPercentRead(lb) + "%");
		System.out.println("Expected: 25/250 --> 10.0%");
		System.out.println("Test for Jo % read: Book2 " + jo.getPercentRead(lb2) + "%");
		System.out.println("Expected: 150/300 --> 50.0%");
		System.out.println("");
		
		vic.setPageCount(lb, 250);
		vic.setPageCount(lb2, 3);
		System.out.println("Test for Vic % read: " + vic.getPercentRead(lb) + "%");
		System.out.println("Expected: 250/250 --> 100.0%");
		System.out.println("Test for Vic % read: " + vic.getPercentRead(lb2) + "%");
		System.out.println("Expected: 3/300 --> 1.0%");
		System.out.println("");
		
		System.out.println("Test for BC avg%: " + bc.getAveragePercentRead(lb) + "%");
		System.out.println("(10+100)/2 = 55.0%");
		System.out.println("Test for BC 2nd avg%: " + bc.getAveragePercentRead(lb2) + "%");
		System.out.println("(50+1)/2 = 25.5%");
		System.out.println("");
		
		System.out.println("Test for Completion %: " + bc.getCompletionPercentage() + "%");
		System.out.println("(55+25.5)/2 = 40.25%");
		
	}
	
}

//Make 2 LeisureBooks, 2 BookClubMembers, 1 BookClub with the 
//two members and the 2 books. Test all the averages.
