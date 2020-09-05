package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book {
	private Genre genre;
	List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String authorFirstName, String authorLastName, int numPages, String publisher,
			int publicationYear, String title, Genre genre) {
		super(authorFirstName, authorLastName, numPages, publisher, publicationYear, title);
		this.genre = genre;
	}
	
	public Genre getGenre() {
		return genre;
	}
	public List<Person> getRecommended() {
		return recommended;
	}
	
	public void addRecommendation(Person p) {
		recommended.add(p);
	}
	
	
}
