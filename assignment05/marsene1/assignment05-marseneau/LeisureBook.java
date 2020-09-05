package assignment05;
import java.util.*;

public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	//Constructor for LeisureBook subclass
	public LeisureBook(String first, String last, int pages, String pub, int yr, String bookTitle, Genre genre) 
	{
		super(first, last, pages, pub, yr, bookTitle);
		this.genre = genre;
	}

	//Getters for subclass data
	public Genre getGenre() {
		return genre;
	}

	public List<Person> getRecommended() {
		return recommended;
	}
	
	//Add a new person to the recommended list
	public void addRecommendation(Person p) {
		recommended.add(p);
	}
	
}
