package assignment05;
import java.util.Set;
import java.util.HashSet;

public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook book: readings) {
			bcm.addReading(book);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		double percentRead = 0.0;
		if(members.size() != 0) {
			for(BookClubMember bcm: members) {
				percentRead += bcm.getPercentRead(book);
			}
			double avg = percentRead/members.size();
			return avg;
		}
		return 0.0;
	}
	
	public double getCompletionPercentage() {
		double percentBooks = 0.0;
		for(LeisureBook book: readings) {
			percentBooks += getAveragePercentRead(book);
		}
		double avgBooks = percentBooks/readings.size();
		return avgBooks;
	}
}
