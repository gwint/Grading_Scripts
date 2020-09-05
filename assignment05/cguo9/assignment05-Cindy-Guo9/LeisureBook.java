package assignment05;
import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{
	private Genre genre; 
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String fn, String ln, int pages, String pub, int pubYear, String title, Genre gen) {
		super(fn, ln, pages, pub, pubYear, title);
		genre = gen;
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
