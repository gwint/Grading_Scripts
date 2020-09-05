package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for (LeisureBook book: readings) {
			bcm.addReading(book);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.isEmpty()) {
			return 0;
		}
		double total = 0;
		for(BookClubMember bcm : members) {
			total += bcm.getPercentRead(book);
		}
		return total/members.size();
	}
	
	public double getCompletionPercentage() {
		double total = 0;
		for (LeisureBook book : readings) {
			total += getAveragePercentRead(book);
		}
		return total/readings.size();
	}
}
