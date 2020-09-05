package assignment05;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author CS 140
 *
 */
public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String first, String last, int num, String pub, int pubYear, String ttl, Genre gen) {
		super(first,last,num,pub,pubYear,ttl);
		genre = gen;	
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Person> getRecommended() {
		return recommended;
	}

	public void setRecommended(List<Person> recommended) {
		this.recommended = recommended;
	}

	public void addRecommendation(Person p) {
		recommended.add(p);
	}
	@Override
	public String toString() {
		return super.toString() + "\n" + genre + recommended;
	}
	
}
