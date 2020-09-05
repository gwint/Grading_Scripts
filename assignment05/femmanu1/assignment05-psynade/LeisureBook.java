package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{

	private Genre genre;
	private List<Person> recommended = new ArrayList<>();		
	
	public LeisureBook(String firstName, String lastName, int pages, String publisher, int publicationYear, String title, Genre genre) {
		super("firstName","lastName",pages,"publisher",2031,"title");
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
