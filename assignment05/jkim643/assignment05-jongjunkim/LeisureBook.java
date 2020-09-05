package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book {
	
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String first, String last, int page, String pub, int pyear, String tit, Genre gen) {
		super(first, last ,page ,pub, pyear, tit);
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
