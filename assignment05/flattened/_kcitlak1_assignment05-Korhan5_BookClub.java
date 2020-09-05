package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
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
			
			for(var mem : members) {
				mem.addReading(book);
			}
		}
		
		public double getAveragePercentRead(Book book) {
			int size = members.size();
			if(members.isEmpty()) {
				return 0.0;
			}
			double average = 0;
			for(var c : members) {
				average += c.getPercentRead(book);
			}
			return (average/size);
		}
		
		public double getCompletionPercentage() {
			int size = readings.size();
			double sum = 0;
			
			for(var c : readings) {
				sum+= getAveragePercentRead(c);
			}
			sum = sum/size;
			return sum;
		}
}
