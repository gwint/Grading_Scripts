package assignment05;

import java.util.HashSet;
import java.util.Set;

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
		double average = 0.0;
		int count = 0;
		double result = 0.0;
		if(members.size() == 0) {
			return 0.0;
		}
		for(BookClubMember bcm : members) {
			average += bcm.getPercentRead(book);
			count++;
		}	
		result = average / count;
		return result;
		
	}

	public double getCompletionPercentage() {
		double average = 0.0;
		int count = readings.size();
		double result = 0.0;
		for(LeisureBook i : readings) {
			average += getAveragePercentRead(i);
		}
		result = average / count;
		return result;
	}	
	
	
}
