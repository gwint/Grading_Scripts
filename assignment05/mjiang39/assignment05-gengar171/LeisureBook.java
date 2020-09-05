package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended;
	
	public LeisureBook(String FN, String LN, int numP, String pub, int pubYr, String nTitle, Genre nGenre) {
		super(FN, LN, numP, pub, pubYr, nTitle);
		genre = nGenre;
		recommended = new ArrayList<>();
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
