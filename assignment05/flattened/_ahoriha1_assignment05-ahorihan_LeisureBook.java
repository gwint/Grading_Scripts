package assignment05;
import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{

	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String aFN, String aLN, int nP, String pub, int pubYear, String ttl, Genre g)
	{
		super(aFN, aLN, nP, pub, pubYear, ttl);
		genre = g;
	}

	public Genre getGenre() {
		return genre;
	}

	public List<Person> getRecommended() {
		return recommended;
	}
	
	public void addRecommendation(Person p)
	{
		recommended.add(p);
	}
}
