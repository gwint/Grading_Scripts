package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings =  new HashSet<>();
	
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
		double averagePercent = 0.0;
		int count = 0;
		if(!members.isEmpty()) {
			for(BookClubMember bcm : members) {
				averagePercent += bcm.getPercentRead(book);
				count += 1;
			}
			averagePercent /= (double)count;
		}
		return averagePercent;
	}
	
	public double getCompletionPercentage() {
		double percent = 0.0;
		double count = 0.0;
		for (LeisureBook book : readings) {
			percent += getAveragePercentRead(book);
			count += 1.0;
		}
		percent /= count;
		return percent;
	}
}
