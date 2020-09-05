package assignment05;
import java.util.*;


class LeisureBook extends Book {
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	

	public LeisureBook(String firstname, String lastname, int pagenum, String publishr, int publicateyear,
			String titl, Genre gerne) {
		super(firstname, lastname, pagenum, publishr, publicateyear, titl);
		genre = gerne;
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
