package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class BookClub{
	
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		
		for(var c : readings) {
			bcm.addReading(c);
		}
		members.add(bcm);
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
	}
	
	public double getAveragePercentRead(Book book) {
	
		double aver = 0;
		
	
		if(!members.isEmpty()) {
			for(var c: members) { 
				aver += c.getPercentRead(book);
			}
			return aver/members.size();
		}else {
			return 0.0;
		}
		
	}
	public double getCompletionPercentage() {
		
		double sum = 0;
		
		for(var c : readings) {
			sum = sum + getAveragePercentRead(c);
		}
		
		return sum/readings.size();
		
	}
	
	
}
