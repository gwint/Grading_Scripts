package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person e) {
		me = e;
	}
	public void addBook(TextBook t) {
		if(t == null) {
			throw new IllegalArgumentException("You must add a real textbook, not a null one");
		}else {
			courseBooks.add(t);
		}
		
	}
	public Set<String> getCourseNames(){
		Set<String> ret = new TreeSet<>();
		for(TextBook t : courseBooks) {
			ret.add(t.getCourseName());
		}
		return ret;
	}
	
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
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
}
