package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		for(LeisureBook l : readings) {
			bcm.addReading(l);
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
		double pSum = 0;
		int mSum = 0;
		for(BookClubMember bcm : members) {
			pSum += bcm.getPercentRead(book);
			mSum++;
		}
		if(mSum == 0) {
			return 0.0;
		}
		else {
			double retVal = pSum / mSum;
			return retVal;
		}
	}
	
	public double getCompletionPercentage() {
		double pSum = 0;
		int bSum = 0;
		for(LeisureBook l : readings) {
			pSum += getAveragePercentRead(l);
			bSum++;
		}
		double retVal = pSum / bSum;
		return retVal;
	}

}
