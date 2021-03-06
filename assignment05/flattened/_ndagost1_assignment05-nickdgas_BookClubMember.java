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
		pagesRead.put(book,  count);
	}
	public Set<LeisureBook> getReadings() {
		return readings;
	}
	public double getPercentRead(Book book) {
		if(pagesRead.containsKey(book) == true) {
			double num = book.getNumPages();
			double read = pagesRead.get(book);
			double percent = (read / num) * 100.0;
			return percent;
		}
		else {
			return 0;
		}
	}
}
