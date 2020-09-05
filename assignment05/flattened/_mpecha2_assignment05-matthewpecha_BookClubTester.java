package assignment05;

import java.text.DecimalFormat;

public class BookClubTester {
	static DecimalFormat df = new DecimalFormat("###.##");
	public static void main (String args[]) {
		test();
	}

	public static void test() {
		LeisureBook lb = new LeisureBook("George", "Orwell", 328, "Secker & Warbug", 1949, "1984", Genre.DYSTOPIA);
		LeisureBook lb2 = new LeisureBook("Ayn", "Rand", 1168, "Random House", 1957, "Atlas Shrugged", Genre.SCIENCE_FICTION);
		Person p1 = new Person("Joaquin", "Phoenix", "99-143-1325");
		Person p2 = new Person("Arthur", "Fleck", "01-124-9315");
		BookClubMember newBCM = new BookClubMember(p1);
		BookClubMember newBCM2 = new BookClubMember(p2);
		BookClub newBC = new BookClub();
		newBC.addMember(newBCM);
		newBC.addMember(newBCM2);
		newBC.addNewReading(lb);
		newBC.addNewReading(lb2);
		newBCM.setPageCount(lb, 190);
		newBCM.setPageCount(lb2, 750);
		newBCM2.setPageCount(lb, 300);
		newBCM2.setPageCount(lb2, 300);
		lb.addRecommendation(new Person("Jimmy George", "Huston", "93-153-3151"));
		lb2.addRecommendation(new Person("Savannah", "Jamieson", "11-351-9414"));
		lb2.addRecommendation(new Person("Kayla", "Mayheart", "35-31-6139"));

		System.out.println("The members in Book Club are " + newBCM.getName() + " and " + newBCM2.getName());
		System.out.println("The readings in Book Club are " + newBCM.getReadings());
		System.out.println("The recommendations for "+ lb.getTitle() + " are " + lb.getRecommended());
		System.out.println("The recommendations for "+ lb2.getTitle() + " are " + lb2.getRecommended() + "\n");
		System.out.println(newBCM.getName() + " is reading " + newBCM.getReadings());
		System.out.println(newBCM2.getName() + " is reading " + newBCM2.getReadings());
		System.out.println(newBCM.getFirstNames() + " has read " + df.format(newBCM.getPercentRead(lb))  + "% of " + lb.getTitle());
		System.out.println(newBCM.getFirstNames() + " has read " + df.format(newBCM.getPercentRead(lb2))  + "% of " + lb2.getTitle());
		System.out.println(newBCM2.getFirstNames() + " has read " + df.format(newBCM2.getPercentRead(lb)) + "% of " + lb.getTitle());
		System.out.println(newBCM2.getFirstNames() + " has read " + df.format(newBCM2.getPercentRead(lb2)) + "% of " + lb2.getTitle());

		System.out.println("\n\n**** Testing Averages ****");
		System.out.println("The average percent read for " + lb.getTitle() + " is " + 
				df.format(newBC.getAveragePercentRead(lb)) + "%.");
		System.out.println("The average percent read for " + lb2.getTitle() + " is " + 
				df.format(newBC.getAveragePercentRead(lb2)) + "%.");

		System.out.println("The completion percentage for " + lb.getTitle() + " and " + 
				lb2.getTitle() + " is " + df.format(newBC.getCompletionPercentage()) + "%.");
	}
}
