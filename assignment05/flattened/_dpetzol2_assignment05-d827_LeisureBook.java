package assignment05;

import java.util.*;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String authorFirstName, String authorLastName, int numPages, String publisher,
			int publicationYear, String title, Genre genre) {
		super(authorFirstName, authorLastName, numPages, publisher,
				publicationYear, title);
		this.genre = genre;
	}
	
	public void addRecommendation(Person p) {
		recommended.add(p);
	}

	public Genre getGenre() {
		return genre;
	}

	public List<Person> getRecommended() {
		return recommended;
	}
	
	
}
