package assignment05;

import java.util.Set;
import java.util.HashSet;
public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	public BookClub() {
		// TODO Auto-generated constructor stub
	}
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook b : readings) {
			bcm.addReading(b);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember b : members) {
			b.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.isEmpty()) {
			return 0.0;
		}
		int count = 0;
	    double total = 0;
		for(BookClubMember b : members) {
			total += b.getPercentRead(book);
			count ++;
		}
		return total/count;
	}
	
	public double getCompletionPercentage() {
		double total = 0;
		int count = 0;
		for(LeisureBook b : readings) {
			total += getAveragePercentRead(b);
			count ++;
		}
		return total/count;
	}

}
