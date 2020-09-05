package assignment05;

import java.util.Set;
import java.util.HashSet;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook item: readings) {
			bcm.addReading(item);
		}

	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember person:members) {
			person.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members == null || members.size() == 0) {
			return 0.0;
		}
		double total = 0;
		double count = 0;
		for(BookClubMember person: members) {
			total += person.getPercentRead(book);
			count++;
		}
		double average = total / count;
		return average;
	}
	
	public double getCompletionPercentage() {
		double total = 0;
		int divisor = 0;
		for(LeisureBook book : readings) {
			total += getAveragePercentRead(book);
			divisor++;
		}
		double average = total/divisor;
		return average;
	}
}
