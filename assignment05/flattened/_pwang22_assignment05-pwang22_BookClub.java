package assignment05;

import java.util.Set;
import java.util.HashSet;
//import java.util.TreeSet;
//import java.util.Map;
//import java.util.HashMap;
//import java.util.TreeMap;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		// switch order?
		members.add(bcm);
		for(var e : readings) {
			bcm.addReading(e);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(var bcm : members) {
			bcm.addReading(book);			
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.size() == 0) {
			return 0;
		}
		double sum = 0;
		for(var bcm : members) {
			sum += bcm.getPercentRead(book);
		}
		return sum / members.size();
	}
	
	public double getCompletionPercentage() {
		double sum = 0;
		int count = 0;
		for(var e : readings) {
			sum += getAveragePercentRead(e);
			count++;
		}
		return sum / count;
	}
}
