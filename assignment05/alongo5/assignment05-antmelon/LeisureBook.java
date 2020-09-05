package assignment05;

import java.util.List;
import java.util.ArrayList;
public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	public LeisureBook(String authorFirst, String authorLast, int pages, String pub, int pubYear, String bookTitle, Genre genre) {
		super(authorFirst, authorLast, pages, pub, pubYear, bookTitle);
		// TODO Auto-generated constructor stub
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
