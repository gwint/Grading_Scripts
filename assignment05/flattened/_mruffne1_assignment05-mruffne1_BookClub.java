package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	
	 Set<BookClubMember> members = new HashSet<>();
	 Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook lb : readings) {
			bcm.addReading(lb);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.size() <= 0) {
			return 0.0;
		}
		double sum = 0.0;
		for(BookClubMember bcm : members) {
			sum += bcm.getPercentRead(book);
		}
		return sum / members.size();
	}
	
	public double getCompletionPercentage() {
		double sum = 0.0;
		for(LeisureBook book : readings) {
			sum += getAveragePercentRead(book);
		}
		return sum / readings.size();
	}
}
