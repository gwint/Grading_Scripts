package assignment05;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.List;
public class BookClub {
	Set<BookClubMember> members = new HashSet<>();
	Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(var i: readings) {
			bcm.addReading(i);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(var i: members) {
		i.addReading(book);
	}
}
	public double getAveragePercentRead(Book book) {
		double total = 0;
		if(members.size() == 0) {
			return 0;
		}
		for(var i: members) {
			total += i.getPercentRead(book);
		}
		return(total / members.size());
	}
	
	public double getCompletionPercentage() {
		double total = 0;
		int count = 0;
		for(var i: readings) {
			total += getAveragePercentRead(i);
			count++;
		}
		return(total / count);
	}
}
