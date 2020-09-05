package assignment05;
import java.util.List;
import java.util.ArrayList;
public class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	
	public LeisureBook(String fn, String ln, int np, String pb, int pby, String tle, Genre g) {
		super(fn, ln, np, pb, pby, tle);
		// TODO Auto-generated constructor stub
		genre = g;
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
