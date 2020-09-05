package assignment05;


import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class BookClubMember {
	private Person me;
	private Set<LeisureBook> readings = new HashSet<>();
	Map<LeisureBook, Integer> pagesRead = new HashMap<>();
	
	public BookClubMember(Person aPerson) {
		me = aPerson;
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
	
	public void setPageCount(LeisureBook book, int count) {
		pagesRead.put(book, count);
	}

	public Set<LeisureBook> getReadings() {
		return readings;
	}
	
	public double getPercentRead(Book book) {
		if (pagesRead.containsKey(book)) {
			float readPages = pagesRead.get(book);
			float numPages = book.getNumPages();
			return readPages/numPages*100;
		} else {
			return 0.0;
		}
	}
	
}
