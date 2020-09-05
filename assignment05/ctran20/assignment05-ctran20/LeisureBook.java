package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String fName, String lName, int nPage, String pub, int pubYear, String til, Genre g) {
		super(fName, lName, nPage, pub, pubYear, til);
		genre = g;
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
