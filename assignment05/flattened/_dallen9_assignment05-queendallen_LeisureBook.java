package assignment05;
import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book{
	private Genre genre;
	List<Person> recommended = new ArrayList<>();
	
	public LeisureBook(String fn,String ln,int pagesNum,String pub,int pubYear,String title, Genre genre) {
		super(fn,ln,pagesNum,pub,pubYear,title);
		this.genre = genre;
	}

	public Genre getGenre() {
		return genre;
	}

	public List<Person> getRecommended() {
		return recommended;
	}
	
	public void addRecomendation(Person p) {
		recommended.add(p);
	}
}
