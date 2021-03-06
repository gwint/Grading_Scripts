package assignment05;
import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String authorFN, String authorLN, int nPages, String pub, int pubYr, String ttl, Genre gnr) {
		super(authorFN, authorLN, nPages, pub, pubYr, ttl);
		genre = gnr;
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
