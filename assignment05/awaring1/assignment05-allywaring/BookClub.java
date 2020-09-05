package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		for(LeisureBook i: readings) {
			bcm.addReading(i);
		}
		members.add(bcm);
	}
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember i: members) {
			i.addReading(book);
		}
			
	}
	public double getAveragePercentRead(Book book) {
		double counter = 0.0;
		double average = 0.0;
		if(members.size() == 0) {
			return 0.0;
		}
		else {
			for(BookClubMember j : members) {
				counter += 1.0;
				average += j.getPercentRead(book);
			}
		}
	
		return(average/counter);
	}
	public double getCompletionPercentage() {
		double counter1 = 0.0;
		double average1 = 0.0;
		for(LeisureBook i : readings) {
			counter1 += 1.0;
			average1 += getAveragePercentRead(i);
		}
		return(average1/counter1);
	}
}
