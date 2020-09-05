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
	
	public LeisureBook(String authorFirstName1, String authorLastName1, int numPages1, String publisher1, int publisherYear1, String title1, Genre genre1) {
		
		this.authorFirstName = authorFirstName1;
		this.authorLastName = authorLastName1;
		this.numPages = numPages1;
		this.publisher = publisher1;
		this.publicationYear = publisherYear1;
		this.title = title1;
		this.genre = genre1;
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