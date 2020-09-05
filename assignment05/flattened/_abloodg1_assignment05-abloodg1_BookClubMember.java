package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class BookClubMember {
	private Person me;
	Set<LeisureBook> readings = new HashSet<>();
	Map<LeisureBook, Integer> pagesRead = new HashMap<>();

	public BookClubMember(Person p) {
		me = p;
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
		pagesRead.put(book,count);
	}

	public Set<LeisureBook> getReadings() {
		return readings;
	}

	public double getPercentRead(Book book) {
		if(pagesRead.containsKey(book)) {
			return ((pagesRead.get(book) * 1.0)/(book.getNumPages() * 1.0)) * 100.0;
		}else {
			return 0;
		}
	}
	
	
}
