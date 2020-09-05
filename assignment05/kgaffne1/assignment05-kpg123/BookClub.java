package assignment05;

import java.util.Set;
import java.util.HashSet;

public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();
	public void addMembers(BookClubMember bcm) {
		for(LeisureBook x : readings) {
			bcm.addReading(x);
		}
		members.add(bcm);
	}
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	public double getAveragePercentRead(Book book) {
		if(members.isEmpty()) {
			return 0;
		}
		double sum = 0;
		for(BookClubMember bcm: members) {
			sum += bcm.getPercentRead(book);
		}
		return sum/members.size();
	}
	public double getCompletionPercentage() {
		double sum = 0;
		for(LeisureBook book: readings) {
			sum += getAveragePercentRead(book);
		}
		return sum/readings.size();
	}
}
