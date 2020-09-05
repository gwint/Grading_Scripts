package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {

	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for (LeisureBook b : readings) {
			bcm.addReading(b);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for (BookClubMember m : members) {
			m.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if (members.isEmpty()) {
			return 0.0;
		} else {
			double total = 0;
			double mbers = 0;
			for (BookClubMember m : members ) {
				total += m.getPercentRead(book);
				mbers ++;
			}
			return total / mbers;
		}
	}
	
	public double getCompletionPercentage() {
		double total = 0;
		double bks = 0;
		for (LeisureBook b : readings) {
			total += getAveragePercentRead(b);
			bks ++;
		}
		return total / bks;
	}
	
}
