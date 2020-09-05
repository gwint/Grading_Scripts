package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();

	public void addMember(BookClubMember bcm) {
		for(LeisureBook lb : readings) {
			bcm.addReading(lb);
		}
		members.add(bcm);
	}

	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}

	public double getAveragePercentRead(Book book) {
		double total = 0;
		int divisor= 0;
		if(members.isEmpty()) return 0;
		for(BookClubMember bcm : members) {
			total += bcm.getPercentRead(book);
			divisor++;
		}
		return total / divisor;
	}

	public double getCompletionPercentage() {
		double total = 0;
		int divisor = 0;
		if(readings.isEmpty()) return 0;
		for(LeisureBook lb : readings) {
			total += getAveragePercentRead(lb);
			divisor ++;
		}
		return total / divisor;
	}
}
