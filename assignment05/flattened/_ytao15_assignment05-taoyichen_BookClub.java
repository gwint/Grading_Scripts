package assignment05;
import java.util.Set;
import java.util.HashSet;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook lbk: readings) {
			bcm.addReading(lbk);
		}
	}
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	public double getAveragePercentRead(Book book) {
		if(members.size()==0) {return 0.0;}
		double retVal = 0.0;
		for(BookClubMember bcm: members) {
			//System.out.println("Average:"+bcm.getPercentRead(book));
			retVal+=bcm.getPercentRead(book);
		}
		retVal = retVal/members.size();
		return retVal;
	}
	public double getCompletionPercentage() {
		double retVal = 0.0;
		for(LeisureBook lbk: readings) {
			//System.out.println("Average:"+getAveragePercentRead(lbk));
			retVal += getAveragePercentRead(lbk);
		}
		retVal = retVal/readings.size();
		return retVal;
	}
}
