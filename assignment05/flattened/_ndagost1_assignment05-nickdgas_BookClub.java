package assignment05;

import java.util.Set;
import java.util.HashSet;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook i : readings) {
			bcm.addReading(i);
		}
	}
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	public double getAveragePercentRead(Book book) {
		if(members.size() == 0) {
			return 0;		
		}
		else {
			double val = 0;
			for(BookClubMember bcm : members) {
				val += bcm.getPercentRead(book);
			}
			double average = val / members.size();
			return average;
		}
	}
	public double getCompletionPercentage() {
		double val = 0;
		for(LeisureBook book : readings) {
			val += getAveragePercentRead(book);
		}
		double average = val / readings.size();
		return average;
	}
}
