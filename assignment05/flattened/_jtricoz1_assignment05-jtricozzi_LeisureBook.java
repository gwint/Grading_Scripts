package assignment05;

import java.util.ArrayList;
import java.util.List;

import assignment05.Genre;

class LeisureBook extends Book{
	private Genre genre;
	private List<Person>recommended = new ArrayList<Person>();
	
	public LeisureBook(String authorF, String authorL, int numP, String pub, int publicationY, String t, Genre g) {
		super(authorF, authorL, numP, pub, publicationY, t);
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




