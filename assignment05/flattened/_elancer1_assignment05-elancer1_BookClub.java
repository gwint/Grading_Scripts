package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();

	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for (LeisureBook l: readings) {
			bcm.addReading(l);
		}
	}

	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for (BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if (members.size() == 0) {return 0;}
		double total = 0.0;
		double divisor = members.size();
		for (BookClubMember bcm: members) {
			total += bcm.getPercentRead(book);
		}
		
		return total/divisor;
	}
	
	public double getCompletionPercentage() {
		double total = 0.0;
		double divisor = readings.size();
		for (LeisureBook l: readings) {
			total += getAveragePercentRead(l);
		}
		return total/divisor;
	}

}
