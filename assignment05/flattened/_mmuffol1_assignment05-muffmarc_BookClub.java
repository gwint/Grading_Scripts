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
		for(LeisureBook i : readings) {
			bcm.addReading(i);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.size() == 0){
			return 0.0;
		}
		double total = 0.0;

		for(BookClubMember bcm : members) {
			total += bcm.getPercentRead(book);
		}
		double average = total/members.size();
		return average;
	}
	
	public double getCompletionPercentage() {
		double total = 0.0;
		for(LeisureBook book : readings) {
			total += getAveragePercentRead(book);
		}
		double completionPercentage = total/readings.size();
		return completionPercentage;
	}
}