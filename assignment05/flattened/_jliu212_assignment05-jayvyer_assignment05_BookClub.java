package assignment05;
import java.util.*;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();

	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		Iterator<LeisureBook> itr = readings.iterator();
		while(itr.hasNext()){
			LeisureBook element = itr.next();
			bcm.addReading(element);
		}
	}

	public void addNewReading(LeisureBook book) {
		readings.add(book);
		Iterator<BookClubMember> itr = members.iterator();
		while (itr.hasNext()) {
			BookClubMember element = itr.next();
			element.addReading(book);
		}
	}

	public double getAveragePercentRead(Book book) {
		double average = 0.0;
		if(members.size() == 0) {
			return average;
		}
		Iterator<BookClubMember> itr = members.iterator();
		while (itr.hasNext()) {
			BookClubMember element = itr.next();
			System.out.println(element.getPercentRead(book));
			average += element.getPercentRead(book);
		}
		return average/members.size();
	}

	public double getCompletionPercentage() {
		double retVal = 0.0;
		Iterator<LeisureBook> itr = readings.iterator();
		while (itr.hasNext()) {
			LeisureBook element = itr.next();
			retVal += getAveragePercentRead(element);
		}
		return retVal/readings.size();
	}
}
