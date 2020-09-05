package assignment05;

public class BookClubTester {
	public static void main(String[] args) {
		LeisureBook obj = new LeisureBook("Gilbert", "Arenas", 400, "Hill", 2016, "Scary Stories", Genre.HORROR);
		LeisureBook obj1 = new LeisureBook("Mark", "Jones", 200, "Scholastic", 2014, "Zombies", Genre.SCIENCE_FICTION);
		BookClubMember obj2 = new BookClubMember(new Person("James", "Jones", "123456789"));
		BookClubMember obj3 = new BookClubMember(new Person("Hector", "Rock", "987654321"));
		
		BookClub theClub = new BookClub();
		theClub.addMember(obj2);
		theClub.addMember(obj3);
		theClub.addNewReading(obj);
		theClub.addNewReading(obj1);
		
		obj2.setPageCount(obj, 10);
		obj2.setPageCount(obj1, 30);
		obj3.setPageCount(obj, 20);
		obj3.setPageCount(obj1, 50);
		System.out.println( "James Jones is reading: " + obj2.getReadings());
		System.out.println("Hector Rock is reading: " + obj3.getReadings());
		System.out.println("LeisureBook obj should have average percent read 3.75" + "\n" +"Actual: " + theClub.getAveragePercentRead(obj));
		System.out.println("LeisureBoook obj1 should have averga percent reas 20.0" + "\n" + "Actual: " + theClub.getAveragePercentRead(obj1));
		System.out.println("Completion Percentage should be 11.875" +"\n" + "Actual: " + theClub.getCompletionPercentage());
		
	}

}
