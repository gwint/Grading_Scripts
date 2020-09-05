package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class BookClubMember {
	private Person me;
	private Set<LeisureBook> readings;
	private Map<LeisureBook, Integer> pagesRead;
	
	public BookClubMember(Person nMe) {
		me = nMe;
		readings = new HashSet<>();
		pagesRead = new HashMap<>();
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
		if(pagesRead.containsKey(book)) {
			return 100.0 * pagesRead.get(book) / book.getNumPages();
		}
		else
			return 0;
	}
}
