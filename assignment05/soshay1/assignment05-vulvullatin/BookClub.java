package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook l: readings) {
			bcm.addReading(l);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.size()==0) {
			return 0.0;
		}
		double divisor = members.size();
		double sum = 0.0;
		for(BookClubMember bcm: members) {
			sum+=bcm.getPercentRead(book);
		}
		return sum/divisor;
	}
	
	public double getCompletionPercentage() {
		if(readings.size()==0) {
			return 0.0;
		}
		double divisor= readings.size();
		double sum=0.0;
		for(LeisureBook l: readings) {
			sum+=getAveragePercentRead(l);
		}
		return sum/divisor;
	}

}
