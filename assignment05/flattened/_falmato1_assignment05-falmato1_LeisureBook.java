package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	public LeisureBook(String frstNm, String ltNm, int nmPgs, String pblshr,
			int pblcYr, String ttl, Genre genre) {
		super(frstNm, ltNm, nmPgs, pblshr, pblcYr, ttl);
		this.genre = genre;
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
