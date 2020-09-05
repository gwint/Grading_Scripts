package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<Person>();
	
	public LeisureBook(String aF, String aL, int nP, String p, int pY, String t, Genre g) {
		super(aF, aL, nP, p, pY, t);
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
