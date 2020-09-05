package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<BookClubMember>();
	private Set<LeisureBook> readings = new HashSet<LeisureBook>();
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook lb : readings) {
			bcm.addReading(lb);
		}
	}
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members)
			bcm.addReading(book);
	}
	public double getAveragePercentRead(Book book) {
		double sum = 0.0;
		for(BookClubMember bcm : members) {
			sum+=bcm.getPercentRead(book);
		}
		return sum/members.size();
	}
	public double getCompletionPercentage() {
		double sum=0;
		for(Book b : readings)
			sum+=getAveragePercentRead(b);
		return sum/readings.size();
	}
}
