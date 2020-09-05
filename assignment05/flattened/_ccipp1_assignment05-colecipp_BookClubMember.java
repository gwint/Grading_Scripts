package assignment05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookClubMember {
	private Person me;
	private Set<LeisureBook> readings = new HashSet<>();
	private Map<LeisureBook, Integer> pagesRead = new HashMap<>();
	public BookClubMember(Person me) {
		this.me = me;
	}

	public void addReading(LeisureBook book) {
		this.readings.add(book);
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
		this.pagesRead.put(book, count);
	}

	public Set<LeisureBook> getReadings() {
		return readings;
	}

	public double getPercentRead(Book book) {
		if(pagesRead.containsKey(book)) {
			double percent = (100.0) *((double)this.pagesRead.get(book)/book.getNumPages()) ;
			return percent;
		}
		return 0.0;
	}
}
