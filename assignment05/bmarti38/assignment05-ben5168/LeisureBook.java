package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String authorFrstName, String authorLstName, int nmPages, String pub, int pubYear, String ttle, Genre gnre) {
		this.authorFirstName = authorFrstName;
		this.authorLastName = authorLstName;
		this.numPages = nmPages;
		this.publisher = pub;
		this.publicationYear = pubYear;
		this.title = ttle;
		this.genre = gnre;
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
