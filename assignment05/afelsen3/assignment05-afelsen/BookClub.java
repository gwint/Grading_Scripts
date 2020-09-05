package assignment05;
import java.util.Set;
import java.util.HashSet;

public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		for (LeisureBook b : readings) {
			bcm.addReading(b);
		}
		
		members.add(bcm);
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		
		for (BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if (members.isEmpty()) {
			return 0.0;
		}
		
		double accum = 0;
		for (BookClubMember bcm : members) {
			accum += bcm.getPercentRead(book);
		}
		
		return accum / members.size(); 
	}
	
	public double getCompletionPercentage() {
		double accum = 0;
		for (LeisureBook book : readings) {
			accum += getAveragePercentRead(book);
		}
		
		return accum/readings.size();
	}
}
