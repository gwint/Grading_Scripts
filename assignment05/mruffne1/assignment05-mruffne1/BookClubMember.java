package assignment05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookClubMember {

	private Person me;
	private Set<LeisureBook> readings = new HashSet<>();
	private Map<LeisureBook, Integer> pagesRead = new HashMap<>();
	
	public BookClubMember(Person p) {
		me = p;
	}
	
	public void addReading(LeisureBook b) {
		readings.add(b);
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
	
	public void setPageCount(LeisureBook b, int count) {
		pagesRead.put(b, count);
	}
	
	public Set<LeisureBook> getReadings() {
		return readings;
	}
	
	public double getPercentRead(Book b) {
		double pct = 0;
		if(pagesRead.containsKey(b)) {
			
			double n = pagesRead.get(b);
			double d = b.getNumPages();
			pct = n/d * 100.0;
		}
		return pct;
	}
	
	public String toSting() {
		return me.toString();
	}
	
}
