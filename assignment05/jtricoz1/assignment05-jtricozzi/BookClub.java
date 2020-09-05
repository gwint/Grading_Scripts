package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub{
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook b : readings) {
			bcm.addReading(b);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember m : members) {
			m.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.size() == 0) {
			return 0.0;
		}else {
			double sum = 0;
			for (BookClubMember m : members) {
				sum += m.getPercentRead(book);
			}
			return (sum / members.size());
		}
	}
	
	public double getCompletionPercentage() {
		double sum = 0;
		for(Book b : readings) {
			sum += getAveragePercentRead(b);
		}
		return(sum / readings.size());
	}
	
	
	
}