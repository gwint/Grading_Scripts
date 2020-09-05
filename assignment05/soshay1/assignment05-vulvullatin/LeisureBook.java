package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {

	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	public LeisureBook(String firstName, String lastName, int pages, String publisher, int year, String title, Genre genre) {
		super(firstName, lastName, pages, publisher, year, title);
		this.genre=genre;
		// TODO Auto-generated constructor stub
	}
	public Genre getGenre() {
		return genre;
	}
	public List<Person> getRecommended() {
		return recommended;
	}
	public void addRecommentation(Person p) {
		recommended.add(p);
	}

}
