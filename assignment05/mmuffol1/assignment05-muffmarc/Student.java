package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person m) {
		me = m;
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
		Set<String> courseNames = new TreeSet<>();
		for(TextBook i : courseBooks) {
			courseNames.add(i.getCourseName());
		}
		return courseNames;
	}
	
	@Override
	public String toString() {
		return me + " taking " + getCourseNames();
	}
	
}
