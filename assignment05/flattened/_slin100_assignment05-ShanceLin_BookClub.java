package assignment05;

import java.util.Set;
import java.util.HashSet;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for (LeisureBook lb : readings) {
			bcm.addReading(lb);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for (BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		double sum = 0.0;
		double avg; 
		if (members.size() == 0) {
			return 0.0;
		} else {
			for (BookClubMember bcm : members) {
				sum += bcm.getPercentRead(book); 
			}
			avg = (sum/members.size());
			return avg;
		}
	}
	
	public double getCompletionRate() {
		double sum = 0.0;
		double avg;
		for (Book bk : readings) {
			sum += getAveragePercentRead(bk);
		}
		avg = (sum / readings.size());
		return avg;
	}
}
