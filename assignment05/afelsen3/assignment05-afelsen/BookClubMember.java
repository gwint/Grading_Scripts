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
	
	public void setPageCount(LeisureBook book, int count) {
		pagesRead.put(book, count);
	}
	
	public double getPercentRead(Book book) {
		if (!(pagesRead.containsKey(book))) {
			return 0;
		}
		
		return (pagesRead.get(book))/(book.getNumPages()*1.0) * 100.0;
			
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

	public Set<LeisureBook> getReadings() {
		return readings;
	}
	
}
