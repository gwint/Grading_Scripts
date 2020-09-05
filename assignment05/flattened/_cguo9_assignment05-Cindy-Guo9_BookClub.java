package assignment05;
import java.util.Set;
import java.util.HashSet;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook l : readings) {
			bcm.addReading(l);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		if(members.size() == 0) {
			return 0.0;
		}else {
			double total = 0;
			for(BookClubMember bcm : members) {
				total += bcm.getPercentRead(book);
			}
			return total / members.size();
		}	
	}
	
	public double getCompletionPercentage() {
		double temp = 0;
		for(LeisureBook book : readings) {
			temp += getAveragePercentRead(book);
		}
		return temp / readings.size();
	}
	
	
}
