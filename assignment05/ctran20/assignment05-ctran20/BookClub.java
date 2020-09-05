package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook t : readings) {
			bcm.addReading(t);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember m : members) {
			m.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		double retVal = 0.0;
		if(members.isEmpty()) {
			return 0.0;
		}
		else {
			for(BookClubMember m : members) {
				retVal += m.getPercentRead(book);
			}
			return retVal/members.size();
		}
	}
	
	public double getCompletionPercentage() {
		double retVal = 0.0;
		for(LeisureBook t : readings) {
			retVal += getAveragePercentRead(t);
		}
		return retVal;
	}
}
