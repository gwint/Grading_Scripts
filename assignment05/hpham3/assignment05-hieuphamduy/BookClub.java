package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook i: readings) {
			bcm.addReading(i);
		}
	}

	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	 public double getAveragePercentRead(Book book) {
		 if(members.size() == 0) {
			 return 0.0;
		 }
		 else {
			 double percentSum = 0.0;
			 for(BookClubMember bcm: members) {
				 percentSum = percentSum + bcm.getPercentRead(book);
			 }
			 double percentAvg = percentSum / members.size();
			 return percentAvg;
		 }
		 
	 }
	 
	 public double getCompletionPercentage() {
		 double percentSum = 0.0;
		 for(LeisureBook book: readings) {
			 percentSum = percentSum + getAveragePercentRead(book);
		 }
		 double percentAvg = percentSum / readings.size();
		 return percentAvg;
	 }
}
