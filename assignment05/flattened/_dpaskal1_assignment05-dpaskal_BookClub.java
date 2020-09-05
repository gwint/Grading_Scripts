package assignment05;

import java.util.Set;
import java.util.HashSet;

public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(var c : readings) {
			bcm.addReading(c);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(var c : members) {
			c.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.isEmpty() || book == null) {
			return 0.0;
		}
		double totalPercentRead = 0;
		for( var c : members) {
			totalPercentRead += c.getPercentRead(book);
		}
		return (totalPercentRead / members.size());
	}
	
	public double getCompletionPercentage() {
		if(members.isEmpty() || readings.isEmpty()) {
			return 0.0;
		}
		double completionPercent = 0.0;
		for(var c : readings ) {
			completionPercent += getAveragePercentRead(c);
		}
		return (completionPercent / readings.size());
	}
}
