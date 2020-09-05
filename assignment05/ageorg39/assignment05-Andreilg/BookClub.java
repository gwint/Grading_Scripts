package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for (LeisureBook e : readings) {
			bcm.addReading(e);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for (BookClubMember e : members) {
			e.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if (members.isEmpty()) {
			return 0.0;
		} else {
			double percentage = 0.0;
			
			for (BookClubMember e : members) {
				for (LeisureBook f : readings) {
					e.setPageCount(f, f.getNumPages());	
				}
				percentage += e.getPercentRead(book);
			}
			
			return percentage / members.size();
		}
	}
	
	public double getCompletionPercentage() {
		double percentage = 0.0;
		int inc = 0;
		
		for (BookClubMember e : members) {
			for (LeisureBook f : readings) {
				percentage += e.getPercentRead(f);
				inc++;
			}
		}
		
		return percentage / inc;
	}
}
