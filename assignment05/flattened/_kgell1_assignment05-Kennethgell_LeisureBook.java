package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book {
	private Genre genre; 
	private List<Person> reccomended = new ArrayList<>();
	
	public LeisureBook(String firstName,String lastName,int pages,String Publisher, int pubYear,String ttle, Genre genres ) {
		super(firstName, lastName, pages, Publisher, pubYear,ttle);
		genre = genres;
	}

	public Genre getGenre() {
		return genre;
	}

	public List<Person> getReccomended() {
		return reccomended;
	}
	public void addReccomendation(Person p) {
		reccomended.add(p);
	}

}
