package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{
	
	
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String afn, String aln, int np, String p, int py, String t, Genre g) {
		super(afn, aln, np, p, py, t);
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
