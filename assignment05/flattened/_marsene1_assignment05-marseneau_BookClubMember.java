package assignment05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookClubMember {
	private Person me;
	private Set<LeisureBook> readings = new HashSet<>();
	private Map<LeisureBook, Integer> pagesRead = new HashMap<>();
	
	//Constructor for person data
	public BookClubMember(Person me) {
		this.me = me;
	}
	
	//Add a book to the readings set
	public void addReading(LeisureBook book)
	{
		readings.add(book);
	}

	//Getters for person data
	public String getFirstNames() {
		return me.getFirstNames();
	}

	public String getLastNames() {
		return me.getLastNames();
	}

	public String getSSN() {
		return me.getSSN();
	}
	
	//Getter for readings
	public Set<LeisureBook> getReadings() {
		return readings;
	}

	//Adjust the pagesRead map
	public void setPageCount(LeisureBook book, int count)
	{
		pagesRead.put(book, count);
	}
	
	//Return the percent of the book that has been read
	public double getPercentRead(Book book)
	{
		double percent = 0.0;
		
		if (pagesRead.containsKey(book))
		{
			//percent = (book.getNumPages() / pagesRead.get(book)) * 100.0;
			//System.out.println(book.getNumPages());
			//System.out.println(pagesRead.get(book));
			
			double one = pagesRead.get(book);
			double two = book.getNumPages();
			
			percent = one/two;
			//percent = pagesRead.get(book) / book.getNumPages();
			//System.out.println(percent);
			percent = percent * 100;
		}
		else
		{
			return 0;
		}
		
		return percent;
	}
	
}
