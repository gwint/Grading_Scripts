package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		for(LeisureBook e : readings) {
			bcm.addReading(e);
		}
		members.add(bcm);
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		Iterator<BookClubMember> it = members.iterator();
		while(it.hasNext()) {
			it.next().addReading(book);
		}
	}

	public double getAveragePercentRead(Book book) {
		if(members.isEmpty())
			return 0.0;
		else {
			double totalPercent = 0.0;
			int numOfBcm = 0;
			for(BookClubMember e : members) {
				totalPercent += e.getPercentRead(book);
				numOfBcm++;
			}
			return totalPercent / numOfBcm;
		}
	}
	
	public double getCompletionPercentage() {
		double totalPercent = 0.0;
		int numOfBook = 0;
		for(LeisureBook e : readings) {
			totalPercent += getAveragePercentRead(e);
			numOfBook++;
		}
		return totalPercent / numOfBook;
	}
}
