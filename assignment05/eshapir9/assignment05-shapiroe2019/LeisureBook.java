package assignment05;
import java.util.List;
import java.util.ArrayList;
public class LeisureBook extends Book{
	private Genre genre;
	private List<Person> list = new ArrayList<Person>();
	//Book book = new LeisureBook("Doug", "Lowe", 912, "Wiley", 2011, "Java All-in-One For Dummies", Genre.NON_FICTION);
	public LeisureBook(String aFN, String aLN, int nP, String p, int pY, String t, Genre g) {
		super(aFN,aLN,nP,p,pY,t);	
	}
}
