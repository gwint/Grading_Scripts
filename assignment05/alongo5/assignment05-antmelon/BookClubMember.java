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
		// TODO Auto-generated constructor stub
		this.me = me;
	}
	
	public void addReading(LeisureBook book) {
		readings.add(book);
	}
	
	public void setPageCount(LeisureBook book, int count) {
		pagesRead.put(book, count);
	}

	public Set<LeisureBook> getReadings() {
		return readings;
	}
	
	public double getPercentRead(Book book) {
		double total;
		total = 0.0;
		if(pagesRead.containsKey(book)) {
			double thisTotal = 0;
			double part = pagesRead.get(book);
			double whole = book.getNumPages();
			thisTotal = part/whole;
			thisTotal = thisTotal * 100.0;
			total = thisTotal;
			
		}
			return total;
		
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

}
