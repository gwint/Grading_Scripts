package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {

	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm)
	{
		members.add(bcm);
		for(LeisureBook i: readings)
		{
			bcm.addReading(i);
		}
	}
	
	public void addNewReading(LeisureBook book)
	{
		readings.add(book);
		for(BookClubMember bcm: members)
		{
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book)
	{
		if(members.size() > 0)
		{
			double count = 0.0;
			for(BookClubMember bcm: members)
			{
				count += bcm.getPercentRead(book);
			}
			return count/members.size();
		}
		
		return 0.0;
	}
	
	public double getCompletionPercentage()
	{
		double count = 0.0;
		for(Book book: readings)
		{
			count += getAveragePercentRead(book);
		}
		return count/readings.size();
	}
	
}
