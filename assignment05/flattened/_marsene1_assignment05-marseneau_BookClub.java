package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	//Add a new member to the book club
	public void addMember(BookClubMember bcm)
	{
		members.add(bcm);
		
		for (LeisureBook book : readings)
		{
			bcm.addReading(book);
		}
	}
	
	//Adds a book to the readings set as well as all members
	public void addNewReading(LeisureBook book)
	{
		readings.add(book);
		
		for (BookClubMember member: members)
		{
			member.addReading(book);
		}
	}
	
	//Calculate the average percentage of a book read by book club members
	public double getAveragePercentRead(Book book)
	{
		double avg = 0.0;
		double value;
		if (members.isEmpty())
		{
			return 0;
		}
		else
		{
			for (BookClubMember member : members)
			{
				value = member.getPercentRead(book);
				avg += value;
			}
			
			
			avg = avg / members.size();
		}
		
		return avg;
	}
	
	//Calculate the total completion percentage for reading
	public double getCompletionPercentage()
	{
		double percent = 0.0;
		double average = 0.0;
		
		for (LeisureBook book : readings)
		{
			//System.out.println("entered the loop");
			//System.out.println(getAveragePercentRead(book));
			average = getAveragePercentRead(book);
			percent += average;
		}
		
		percent = percent / readings.size();
		//System.out.println(percent);
		
		return percent;
	}
}
