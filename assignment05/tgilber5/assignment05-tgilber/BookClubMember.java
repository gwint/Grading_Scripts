package assignment05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookClubMember {
	
	private Person me;
	private Set<LeisureBook> readings = new HashSet<>(); 
	private Map<LeisureBook, Integer> pagesRead = new HashMap<>();
	
	BookClubMember(Person Person){
		me = Person;
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
		double result = 0.0;
		double var1 = 0.0;
		double var2 = 0.0;
		if(pagesRead.containsKey(book)) {
			var1 = pagesRead.get(book);
			var2 = book.getNumPages();
			result = ((var1 / var2) * 100.0);
			return result; 
		} else { 
			return 0.0;
		}
		
	}
	
	
	
	
}
