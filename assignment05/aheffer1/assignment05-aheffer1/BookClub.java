package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for (LeisureBook i : readings) {
			bcm.addReading(i);
		}
	}
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for (BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	public double getAveragePercentRead(Book book) {
		if(members.isEmpty()) {
			return 0.0;
		}
		double avg = 0;
		for (BookClubMember bcm : members) {
			avg = avg + bcm.getPercentRead(book);
		}
		avg = avg / members.size();
		return avg;
	}
	public double getCompletionPercentage() {
		double avg = 0;
		for (Book book : readings) {
			avg = avg + getAveragePercentRead(book);
		}
		avg = avg / readings.size();
		return avg;
	}
}
