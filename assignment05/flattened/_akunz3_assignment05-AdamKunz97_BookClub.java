package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for (LeisureBook book : readings) {
			bcm.addReading(book);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for (BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		double numerator = 0.0;
		double denominator = 0.0;
		if (members.size() == 0) {
			return 0.0;
		} else {
			for (BookClubMember bcm : members) {
				numerator += bcm.getPercentRead(book);
				denominator += 100.0;
			}
		}
		return ((numerator/denominator)*100);
	}
	
	public double getCompletionPercentage() {
		double numerator = 0.0;
		double denominator = 0.0;
		for (LeisureBook book : readings) {
			numerator += getAveragePercentRead(book);
			denominator += 100.0;
		}
		return ((numerator/denominator)*100);
	}
}