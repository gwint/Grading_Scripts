package assignment05;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	public LeisureBook(String firstName, String lastName, int numPages, String publisher, int publicationYear,
			String title, Genre genre) {
		super(firstName, lastName, numPages, publisher, publicationYear, title);
		this.genre = genre;
	} 
	public void addRecommendation(Person p) {
		if(p == null) {
			throw new IllegalArgumentException("You must recommend to a real person, not a null one");
		}else {
			recommended.add(p);
		}
		
	}
	
	public Genre getGenre() {
		return genre;
	}
	public List<Person> getRecommended() {
		return recommended;
	}

}
