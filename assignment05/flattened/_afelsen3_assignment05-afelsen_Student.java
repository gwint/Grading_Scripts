package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
	Person me;
	Set<TextBook> courseBooks = new HashSet<>();

	public Student(Person p) {
		me = p;
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
		Set<String> retSet = new TreeSet<>();
		for (TextBook t : courseBooks) {
			retSet.add(t.getCourseName());
		}
		
		return retSet;
	}
	
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
	
}
