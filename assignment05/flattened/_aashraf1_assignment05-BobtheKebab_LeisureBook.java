package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {
	
	private Genre genre;
	private List<Person> recommended = new ArrayList<Person>();
	
	public LeisureBook (String aFN, String aLN, int nPgs, String pub, int pubYr, String ttl, Genre gen) {
		super(aFN, aLN, nPgs, pub, pubYr, ttl);
		genre = gen;
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
