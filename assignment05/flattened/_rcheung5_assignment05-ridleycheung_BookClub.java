package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook leisure : readings) {
			bcm.addReading(leisure);
		}
	}

	public void addNewReading(LeisureBook book) {
		readings.add(book);
	}
	
	public double getAveragePercentRead(Book book) {
		double avgPercentRead = 0.0;
		//avgPercentRead = (members.get(book).getPercentRead(book) / members.get(book));
		return avgPercentRead;
	}
	
	public double getCompletionPercentage() {
		double completionPercent = 0.0;
		//completionPercent = readings.getAveragePercentRead(book);
		return completionPercent;
	}
}