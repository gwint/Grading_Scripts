package assignment05;
import java.util.Set;
import java.util.HashSet;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		
		for(LeisureBook i : readings) {
			bcm.addReading(i);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm : members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(LeisureBook book) {
		double sum = 0.0;
		double result;
		for(BookClubMember bcm : members) {
			if(members.isEmpty()) {
				//System.out.println("here");
				return 0.0;
			}
			sum += bcm.getPercentRead(book);
			//System.out.println("BCM READ: " + bcm.getPercentRead(book) + "% of the book" + book.getTitle());
		}
		//System.out.println("Sum is " + sum);
		result = sum / members.size();
		return result;
	}
	
	public double getCompletionPercentage() {
		double sum = 0.0;
		double result;
		for(LeisureBook i : readings) {
			sum += getAveragePercentRead(i);
		}
		result = sum / readings.size();
		return result;
	}
}
