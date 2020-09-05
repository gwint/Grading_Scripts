package assignment05;

import java.util.*;

public class BookClub {

	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		
		for(LeisureBook book : readings) {
			bcm.addReading(book);
		}
		
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.size() == 0) {
			return 0.0;
		}
		double sum = 0;
		for(BookClubMember bcm : members) {
			sum += bcm.getPercentRead(book);
			
		}
		return sum / (double) members.size();
	}
	
	public double getCompletionPercentage() {
		if(readings.size() == 0) {
			return 0;
		}
		double sum = 0;
		for(Book book : readings) {
			sum += getAveragePercentRead(book);
		}
		
		return sum / (double) readings.size();
	}
	
}
