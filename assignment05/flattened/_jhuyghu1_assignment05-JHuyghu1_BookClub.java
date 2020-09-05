package assignment05;
import java.util.Set;
import java.util.HashSet;
//import java.util.TreeSet;
//import java.util.Map;
//import java.util.HashMap;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook element: readings) {
			bcm.addReading(element);
		}	
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember human: members) {
			human.addReading(book); }
	}
	
	public double getAveragePercentRead(Book book) {
		if(members == null || members.size() == 0) {
			return 0.0;
		}
		int value = 0;
		int index = 0;
		for(BookClubMember human: members) {
			value += human.getPercentRead(book);
			index ++;
		}
		double average = value / index;
		return average;
	}
	
	public double getCompletionPercentage() {
		double total = 0;
		//int index = 0;
		for(LeisureBook element: readings) {
			total += getAveragePercentRead(element);
			//index++;
		}
		return total;
	}
}
