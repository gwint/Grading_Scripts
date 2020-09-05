package assignment05;

import java.util.Set;
import java.util.HashSet;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for (var book: readings) {
			bcm.addReading(book);
		}
	}

	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for (var bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if (members.size() == 0) {
			return 0.0;
		}
		double avg = 0.0;
		for (var bcm: members) {
			avg += bcm.getPercentRead(book);
		}
		return avg / members.size();
	}
	
	public double getCompletionPercentage() {
		double avg = 0;
		for (var book: readings) {
			avg += getAveragePercentRead(book);
		}
		return avg / readings.size();
	}
}
