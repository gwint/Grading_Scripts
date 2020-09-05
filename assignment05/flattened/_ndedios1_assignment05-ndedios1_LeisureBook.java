package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String aFirstName, String aLastName, int nPages, String pub, int pubYear, String title_name, Genre genre) {
		super(aFirstName, aLastName, nPages, pub, pubYear, title_name);
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
