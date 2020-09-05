package assignment05;

import java.util.*;

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

	public void setPageCount(LeisureBook book, int count) {
		pagesRead.put(book, count);
	}
	
	public double getPercentRead(Book book) {
		double retVal = 0;
		if(pagesRead.containsKey(book)) {
			double amountRead = pagesRead.get(book);
			double total = book.getNumPages();
			retVal = amountRead/total * 100.0;
			
			return retVal;
		}
		else {
			return 0;
		}
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
	
	public Set<LeisureBook> getReadings(){
		return readings;
	}
	
	
}
