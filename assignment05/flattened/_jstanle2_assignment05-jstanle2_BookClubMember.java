package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class BookClubMember {
	private Person me;
	private Set<LeisureBook> readings = new HashSet<>();
	private Map<LeisureBook, Integer> pagesRead = new HashMap<>();
	
	public BookClubMember(Person p) {
		me = p;
	}
	
	public void addReading(LeisureBook book) {
		readings.add(book);
	}

	public String getFirstNames() {
		return me.getFirstNames();
	}

	public String getLastNames() {
		return me.getLastNames();
	}

	public String getSSN() {
		return me.getSSN();
	}
	
	public void setPagesCount(LeisureBook book, int count) {
		pagesRead.put(book, count);
	}
	
	public Set<LeisureBook> getReadings(){
		return readings;
	}
	
	public double getPercentRead(Book book) {
		double percent = 0;
		if(pagesRead.containsKey(book)) {
			double temp1 = pagesRead.get(book);
			double temp2 = book.getNumPages();
			percent = temp1 / temp2 * 100.0;
		}
		return percent;
	}
}
