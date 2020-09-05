package assignment05;

import java.util.Scanner;

public class BookClubTester {
		
	public static void main(String[] args) {		
		var aBook1 = new LeisureBook("Joanne", "Rowling", 350, "London Books", 1999, "Harry Potter", Genre.FANTASY);
		var aBook2 = new LeisureBook("Ashlee", "Vance", 402, "HarperCollins", 2015, "Elon Musk", Genre.BIOGRAPHY);
		var aMember1 = new BookClubMember(new Person("Anthony", "Russo", "674324546"));
		var aMember2 = new BookClubMember(new Person("Jacklyn", "Yoon", "345267892"));
		var Library = new BookClub();
		
		//Just an Experiment
		@SuppressWarnings("resource")
		var input = new Scanner(System.in);
		System.out.println("Input: ");
		int count = input.nextInt();
		
		
		Library.addMember(aMember1);
		Library.addMember(aMember2);
		Library.addNewReading(aBook1);
		Library.addNewReading(aBook2);
		aMember1.setPageCount(aBook1, count);
		aMember2.setPageCount(aBook1, 250);
		aMember1.setPageCount(aBook2, 400);
		aMember2.setPageCount(aBook2, 102);

		System.out.println("aMember1 percent from aBook1: " + aMember1.getPercentRead(aBook1));
		System.out.println("aMember1 percent from aBook2: " + aMember1.getPercentRead(aBook2));
		System.out.println("aMember2 percent from aBook1: " + aMember2.getPercentRead(aBook1));
		System.out.println("aMember2 percent from aBook2: " + aMember2.getPercentRead(aBook2));
		System.out.println("Average percent read aBook1 from both members in the Book Club: " + Library.getAveragePercentRead(aBook1));
		System.out.println("Average percent read aBook2 from both members in the Book Club: " + Library.getAveragePercentRead(aBook2));
		System.out.println(aBook1);
		
	}

}



