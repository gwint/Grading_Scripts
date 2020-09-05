package assignment05;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;


public class BookClubMember {
	private Person me;
	private Set<LeisureBook> readings = new HashSet<>();
	private Map<LeisureBook, Integer> pagesRead  = new HashMap<>();
	
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
		pagesRead.put(book, count);
	}

	public Set<LeisureBook> getReadings() {
		return readings;
	}
	
	public double getPercentRead(Book book) {
		if(pagesRead.containsKey(book)!= true) {
			return 0;
		}
		double numPages = book.getNumPages();
		double pageRead = pagesRead.get(book);
		return ((pageRead / numPages) * 100.0);
	}
}
