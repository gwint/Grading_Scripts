package assignment05;
import java.util.Set;
import java.util.HashSet;


public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();

	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook a: readings) {
			bcm.addReading(a);
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
		}
		double tot = 0;
		double count = 0;
		for(BookClubMember bcm : members) {
			tot+= bcm.getPercentRead(book);
			count++;
		}
		return tot/count;
	}
	public double getCompletionPercentage() {
		double tot = 0;
		for(LeisureBook a: readings) {
			tot += this.getAveragePercentRead(a);
		}
		return tot/readings.size();
	}
}
