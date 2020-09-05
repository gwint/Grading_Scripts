package assignment05;

import java.util.*;

public class BookClub {
	private Set<BookClubMember> members = new HashSet<>();
	private Set<LeisureBook> readings = new HashSet<>();
	
	public void addMember(BookClubMember bcm) {
		members.add(bcm);
		for(LeisureBook b: readings) {
			bcm.addReading(b);
		}
	}
	
	public void addNewReading(LeisureBook book) {
		readings.add(book);
		for(BookClubMember bcm: members) {
			bcm.addReading(book);
		}
	}
	
	public double getAveragePercentRead(Book book) {
		double sum = 0;
		double count = 0;
		double average = 0;
		if(members.size() == 0) {
			return 0;
		}
		else {
			for(BookClubMember bcm: members) {
				sum += bcm.getPercentRead(book);
				count += 1;
			}
			average = sum/count;
			return average;
			
		}
	}
	
	public double getCompletionPercentage() {
		double sum = 0;
		double count = 0;
		double average = 0;
		for(LeisureBook b: readings) {
			sum += getAveragePercentRead(b);
			count += 1;
		}
		average = sum/count;
		return average;
	}
	
	public String toString() {
		List<String> firstNames = new ArrayList<>();
		List<String> titles = new ArrayList<>();
		for(BookClubMember bcm: members) {
			firstNames.add(bcm.getFirstNames());
		}
		for(LeisureBook b: readings) {
			titles.add(b.getTitle());
		}
		return "Book Club currently consists of " + firstNames + ", currently reading " + titles;
	}
}
