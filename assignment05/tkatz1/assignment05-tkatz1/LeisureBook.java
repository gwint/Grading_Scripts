package assignment05;
import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> reccomended = new ArrayList<Person>();
	
	public LeisureBook(String authorFirstName, String authorLastName, int num, String pub, int pubY, String t, Genre genre) {
		super(authorFirstName, authorLastName, num, pub, pubY, t);
		this.genre = genre;
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
