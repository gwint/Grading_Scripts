package assignment05;

import java.util.HashSet;
import java.util.Set;
public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook e : readings) {
			bcm.addReading(e);
		}
	}
	//**********
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember e : members) {
			e.addReading(book);
		}
	}
	public double getAveragePercentRead(Book book) {
		if(members.size() == 0) {
			return 0.0;
		}
		double averages = 0.0;
		for(BookClubMember e : members) {
			averages += e.getPercentRead(book);
			
		}
		return averages/members.size();
	}
	public double getCompletionPercentage() {
		double average = 0.0;
		for(LeisureBook e : readings) {
			average += getAveragePercentRead(e);
		}
		return average / readings.size();
	}

}
