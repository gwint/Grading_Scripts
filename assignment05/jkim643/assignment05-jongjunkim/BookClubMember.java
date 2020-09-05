package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class BookClubMember {
	
	private Person me;
	private Set<LeisureBook> readings = new HashSet<>();
	private Map<LeisureBook, Integer> pagesRead = new HashMap<>();

	public BookClubMember(Person m) {
		me = m;
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
	
	
	public void setPageCount(LeisureBook book, int count){
		pagesRead.put(book, count);
	}
	
	public String toString() {
		return me.toString();
	}

	public Set<LeisureBook> getReadings(){
		return readings;
	}
	
	public double getPercentRead(Book book) {
		
		if(pagesRead.containsKey(book)) {
			double page = pagesRead.get(book);
			double per = (page/book.getNumPages()) * 100;
			return per;
		}else {
			return 0.0;
		}
		
	}
	
	
}
