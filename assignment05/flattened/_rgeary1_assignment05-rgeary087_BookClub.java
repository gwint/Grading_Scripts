package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook l : readings) {
			bcm.addReading(l);
		}
	} 
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
		
	}
	public double getAveragePercentRead(Book book) {
		double sum = 0.0;
		for(BookClubMember bcm : members) {
			sum += bcm.getPercentRead(book);
		}
		return sum/members.size();
	}
	public double getCompletionPercentage() {
		double sum = 0.0;
		for(LeisureBook lb : readings) {
			sum += this.getAveragePercentRead(lb);
		}
		return sum/readings.size();
	}
	
}
