package assignment05;
import java.util.*;

public class Student {
	private Person me;
	private Set<Textbook> courseBooks = new HashSet<>();

	public Student(Person em) {
		me = em;
	}

	public String getFirstNames()
	{
		return me.getFirstNames();
	}

	public String getLastNames()
	{
		return me.getLastNames();
	}

	public String getSSN()
	{
		return me.getSSN();
	}

	public void addBook(Textbook t) {
		courseBooks.add(t);
	}

	public Set<String> getCourseNames(){
		Set<String> retVal = new TreeSet<>();
		for(Textbook dummy : courseBooks){
			retVal.add(dummy.getCourseName());
		}
		return retVal;
	}

	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
}
