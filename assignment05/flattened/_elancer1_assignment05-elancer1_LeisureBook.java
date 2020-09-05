package assignment05;

import java.util.ArrayList;

public class LeisureBook extends Book {
	private ArrayList<Person> recommended = new ArrayList<Person>();
	private Genre genre;
	
	public LeisureBook(String fName, String lName, int num, String pub, int year, String bTitle, Genre type) {
		super(fName, lName, num, pub, year, bTitle);
		genre = type;
	}

	public ArrayList<Person> getRecommended() {
		return recommended;
	}

	public Genre getGenre() {
		return genre;
	}
	
	public void addRecommendation(Person p) {
		recommended.add(p);
	}
}


