package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> recommended = new ArrayList<Person>();
	public LeisureBook(String firstName,String lastName,int pages,String publishr,int year,String titl,Genre genr) {
		super(firstName,lastName,pages,publishr,year,titl);
		genre = genr;
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
