package assignment05;

import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> reccomended = new ArrayList<>();
	public LeisureBook(String AFN, String ALN, int pages, String pub, int year, String title, Genre gen) {
		super(AFN, ALN, pages, pub, year, title);
		this.genre = gen;
	}
	public void addRecommendation(Person p) {
		reccomended.add(p);
	}

}
