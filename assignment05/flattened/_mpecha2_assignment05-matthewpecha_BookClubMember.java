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

	public String getName() {
		return me.getFirstNames() + " " + me.getLastNames();
	}

	public void setPageCount(LeisureBook book, int count) {
		pagesRead.put(book, count);
	}

	public Set<LeisureBook> getReadings() {
		return readings;
	}

	public double getPercentRead(Book book) {
		if(pagesRead.containsKey(book)){
			double numRead = pagesRead.get(book);
			double numPages = book.getNumPages();
			double divide = numRead / numPages;
			return (divide * 100.00);
		}
		else {
			return 0.0;
		}
	}
}
