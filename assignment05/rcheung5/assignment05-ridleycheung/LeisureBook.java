package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String firstName, String lastName, int pages, String bookPublisher,
			int bookPublicationYear, String bookTitle, Genre aGenre) {
		super(firstName, lastName, pages, bookPublisher, bookPublicationYear, bookTitle);
		genre = aGenre;
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
