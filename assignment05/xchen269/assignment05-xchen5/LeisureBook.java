package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<Person>();
	
	public LeisureBook(String aFN, String aLN, int pages, String pSher, int pYear, String tTle, Genre genr) {
		super(aFN, aLN, pages, pSher, pYear, tTle);
		genre = genr;
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
