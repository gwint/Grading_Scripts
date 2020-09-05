package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String authorFrstName, String authorLstName, int nmPages, String pub, int pubYear, String tle, Genre gnre) {
		this.authorFirstName = authorFrstName;
		this.authorLastName = authorLstName;
		this.numPages = nmPages;
		this.publisher = pub;
		this.publicationYear = pubYear;
		this.title = tle;
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
