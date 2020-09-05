package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Person> getRecommended() {
		return recommended;
	}

	public void setRecommended(List<Person> recommended) {
		this.recommended = recommended;
	}

	public LeisureBook(String aF, String aL, int noP, String pub, int pubYr, String t, Genre g) {
		super(aF, aL, noP, pub, pubYr, t);
		setGenre(g);
	}
	
}
