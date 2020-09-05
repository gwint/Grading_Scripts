package assignment05;
import java.util.Set;
import java.util.HashSet;

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
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.size()==0) {
			return 0.0;
		}else {
			double sum = 0.0;
			for(BookClubMember bcm: members) {
				sum = sum + bcm.getPercentRead(book);
			}
			return (sum / members.size());
		}
	}
	
	public double getCompletionPercentage() {
		double sum = 0.0;
		for(Book book: readings) {
			sum = sum + getAveragePercentRead(book);
		}
		return (sum / readings.size());
	}
}
