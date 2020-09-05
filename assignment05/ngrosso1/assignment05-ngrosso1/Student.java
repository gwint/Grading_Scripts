package assignment05;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Student extends Person{
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(String fstNames, String lstNames, String ssnString, Person me) {
		super(fstNames, lstNames, ssnString);
		this.me = me;
	}

	public String getFirstNames() {
		return me.getFirstNames();
	}

	public String getLastNames() {
		return me.getLastNames();
	}

	public String getSSN() {
		return me.getSSN();
	}
	
	public void addBook(TextBook t) {
		courseBooks.add(t);
	}
	
	public Set<String> getCourseNames(){
		Set<String> x = new TreeSet<>();
		
		for(TextBook i : courseBooks) {
			x.add(i.getCourseName());
		}
		
		return x;
	}
	
	@Override
	public String toString() {
		return super.toString() + " taking " + getCourseNames();
	}
}
