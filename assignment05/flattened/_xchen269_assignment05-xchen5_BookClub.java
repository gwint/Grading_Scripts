package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		for(LeisureBook l:readings) {
			bcm.addReading(l);
		}
		members.add(bcm);
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		double total = 0.0;
		for(BookClubMember bcm: members) {
			total += bcm.getPercentRead(book);
		}
		return total / members.size();
	}
	
	public double getCompletionPercentage() {
		double total = 0.0;
		for(Book b: readings) {
			total += getAveragePercentRead(b);
		}
		return total/readings.size();
	}
}
