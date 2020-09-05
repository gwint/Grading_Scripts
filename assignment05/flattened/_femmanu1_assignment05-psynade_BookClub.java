package assignment05;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		Iterator<LeisureBook> iterator = readings.iterator();
		while(iterator.hasNext()){
			bcm.addReading(iterator.next());
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		double retVal = 0.00;
		if(members.size() == 0) {
			return 0.0;
		}
		for(BookClubMember bcm: members) {
			retVal = retVal + bcm.getPercentRead(book);
		}
		retVal = retVal/members.size();
		return retVal;
	}
	
	public double getCompletedPercentage() {
		double retVal = 0.0;
		for(LeisureBook read: readings) {
			retVal = retVal + getAveragePercentRead(read);
		}
		return retVal;
	}
	
	
}
