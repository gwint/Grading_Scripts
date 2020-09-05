package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person m) {
		this.me = m;
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
		Set<String> ret = new TreeSet<>();
		for(TextBook t : courseBooks) {
			ret.add(t.getCourseName());
		}
		return ret;
	}
	
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
	
}
