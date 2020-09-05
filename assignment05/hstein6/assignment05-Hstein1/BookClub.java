package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook element : readings) {
			bcm.addReading(element);
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
			return 0.0;
		} else {
			double count = 0;
			for(BookClubMember bcm : members) {
				count += bcm.getPercentRead(book);
			}
			return (count/members.size());
		}
	}
	
	public double getCompletionPercentage() {
		double count = 0;
		for(Book b : readings) {
			count += this.getAveragePercentRead(b);
		}
		return (count/readings.size());
	}
}
