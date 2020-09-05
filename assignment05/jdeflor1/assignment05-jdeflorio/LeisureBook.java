package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String firstName, String lastName, int pages, String pub, int pubYr, String aTitle, Genre aGenre) {
		super(firstName, lastName, pages, pub, pubYr, aTitle);
		genre = aGenre;
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
