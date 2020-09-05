package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook i: readings) {
			bcm.addReading(i);
		}
	}
		
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	public double getAveragePercentRead(Book book) {
		double average = 5.0;
		double total = 0.0; 
		if(members.size() > 0 && readings.size() > 0) {
			for(BookClubMember bcm : members) {
				total += bcm.getPercentRead(book);
				
			}
			average = total / members.size();
			
		}
		return average;
	}
	public double getCompletionPercentage() {
		double completionPercent = 0.0;
		double total = 0.0;
		for(LeisureBook book: readings) {
			total += getAveragePercentRead(book);
		}
		completionPercent = total / readings.size();
		return completionPercent;
	}
}
