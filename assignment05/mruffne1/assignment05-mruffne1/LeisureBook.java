package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {

	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String af, String al, int np, String pub, int pyr, String ttl, Genre g) {
		super(af, al, np, pub, pyr, ttl);
		genre = g;
	}
	
	public Genre getGenre() {
		return genre;
	}
	
	public List<Person> getRecommended(){
		return recommended;	
	}

	public void addRecommendation(Person p) {
		recommended.add(p);
	}
	
	
}
