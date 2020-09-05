package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		System.out.println("*********** TEST FOR BOOK CLUB ************\n");
		
		LeisureBook fun_book1 = new LeisureBook("Jeff", "Bill", 55, "Springer", 2015, "The Dog Who Could", Genre.ROMANCE);
		LeisureBook fun_book2 = new LeisureBook("Mark", "Thomas", 23, "Booking", 2007, "The Cat and Her Friend", Genre.SCIENCE_FICTION);
		System.out.println("LEISURE BOOKS: ");
		System.out.println(fun_book1.toString());
		System.out.println(fun_book2.toString() + "\n");
		
		Person person1 = new Person("James", "Brown", "897-09-1234");
		Person person2 = new Person("Lisa", "West", "342-45-8623");
		
		System.out.println("BOOK MEMBERS: ");
		BookClubMember member1 = new BookClubMember(person1);
		BookClubMember member2 = new BookClubMember(person2);
		System.out.println(person1.toString());
		System.out.println(person2.toString() + "\n");
		
		
		
		BookClub club1 = new BookClub();
		
		
		club1.addMember(member1);
		club1.addMember(member2);
		
		
		club1.addNewReading(fun_book1);
		club1.addNewReading(fun_book2);
		
		
		member1.setPageCount(fun_book1, 30);
		member1.setPageCount(fun_book2, 20);
		
		member2.setPageCount(fun_book1, 18);
		member2.setPageCount(fun_book2, 10);
		
		
		//double val1 = member1.getPercentRead(fun_book1);
		System.out.println("************ Test for Percent Read **********\n");
		System.out.println("The Percent read by Jeff of 'The Dog Who Could' is " + member1.getPercentRead(fun_book1) +"%");
		System.out.println("The Percent read by Mark of 'The Dog Who Could' is " + member2.getPercentRead(fun_book1) +"%"+"\n");
		
		System.out.println("The Percent read by Mark of 'The Cat and Her Friend' is " + member2.getPercentRead(fun_book2) +"%");
		System.out.println("The Percent read by Jeff of 'The Cat and Her Friend' is " + member1.getPercentRead(fun_book2) +"%" + "\n");
		
		System.out.println("************** Test for Average Percent Read **********\n");
		System.out.println("The average percent read for 'The Dog Who Could' is: " + club1.getAveragePercentRead(fun_book1) +"%");
		System.out.println("The average percent read for 'The Cat and Her Friend' is: " + club1.getAveragePercentRead(fun_book2)+"%" + "\n");
		
		System.out.println("****** Test for Completion Average Percentage **********");
		System.out.println("The Completion Percentage for both books is: " +  club1.getCompletionPercentage() + "%");
		
		
	}
	
	
}
