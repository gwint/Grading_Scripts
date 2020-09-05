package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{

	private Genre genre;
	private List<Person> recommended;
	
	public LeisureBook(String authorFirstName, String authorLastName, int numPages, String publisher,
			int publicationYear, String title, Genre genre) {
		super(authorFirstName, authorLastName, numPages, publisher, publicationYear, title);
		recommended = new ArrayList<>();
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
