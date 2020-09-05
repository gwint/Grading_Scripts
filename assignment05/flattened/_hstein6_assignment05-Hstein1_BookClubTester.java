package assignment05;

public class BookClubTester {

	public static void main(String[] args) {
		LeisureBook lb1 = new LeisureBook("Daniel", "Silva", 433, "Johnson Publishing", 
				2018, "The New Girl", Genre.NON_FICTION);
		LeisureBook lb2 = new LeisureBook("Harlan", "Coben", 372, "Mystery Publications", 
				2017, "Grey Mountain", Genre.DETECTIVE_STORY);
		Person p1 = new Person("Johnathan", "Castle", "356728303");
		Person p2 = new Person("Kim", "Angel", "847263940");
		BookClubMember bcm1 = new BookClubMember(p1);
		BookClubMember bcm2 = new BookClubMember(p2);
		BookClub bc = new BookClub();
		bc.addMember(bcm1);
		bc.addMember(bcm2);
		bc.addNewReading(lb1);
		bc.addNewReading(lb2);
		
		System.out.println(bc.getCompletionPercentage());
		System.out.println(bc.getAveragePercentRead(lb1));
		System.out.println(bc.getAveragePercentRead(lb2));
		System.out.println(bcm1.getPercentRead(lb1));
		System.out.println(bcm1.getPercentRead(lb2));
		System.out.println(bcm2.getPercentRead(lb1));
		System.out.println(bcm2.getPercentRead(lb2));

	}

}
