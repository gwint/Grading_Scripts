package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String fstName, String lstName, int pgs, String pub, int pubYear, String ttl, Genre gre) {
		super(fstName, lstName, pgs, pub, pubYear, ttl);
		this.genre = gre;
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
