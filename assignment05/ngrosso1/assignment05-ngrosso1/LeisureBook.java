package assignment05;
import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> recomended = new ArrayList<Person>();
	
	public LeisureBook(String afn, String aln, int np, String pub, int py, String t, Genre g) {
		super(afn, aln, np, pub, py, t);
		genre = g;
	}

	public Genre getGenre() {
		return genre;
	}

	public List<Person> getRecomended() {
		return recomended;
	}
	
	public void addRecommendation(Person p) {
		recomended.add(p);
	}
}
