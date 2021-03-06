package assignment05;

import java.util.Set;
import java.util.HashSet;

import java.util.Map;
import java.util.HashMap;



public class BookClubMember {
	private Person me;
	private Set<LeisureBook> readings = new HashSet<>();
	private Map<LeisureBook, Integer> pagesRead = new HashMap<>();
	
	public BookClubMember(Person me) {
		this.me = me;
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
		if ( count > book.getNumPages() ) {
			throw new IllegalArgumentException("Bad input. Cannot read more pages than book has pages.");
		}
		if ( count < 0 ) {
			throw new IllegalArgumentException("Bad input. Cannot read negative pages.");
		}
		pagesRead.put(book, count);
	}

	public Set<LeisureBook> getReadings() {
		return readings;
	}
	
	public double getPercentRead(Book book) {
		if(pagesRead.containsKey(book)) {
			double numPages = book.getNumPages();
			double numRead = pagesRead.get(book);
			return (numRead/numPages) * 100.0;
		}
		return 0.0;
	}
	
}
