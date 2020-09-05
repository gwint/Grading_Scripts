package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student (Person p) {
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
		Set<String> courseNames  = new TreeSet<>();
		for (TextBook i : courseBooks) {
			courseNames.add(i.getCourseName());
		}
		return courseNames;
	}
	
	public String toString() {
		String toString = me.toString() + " taking " + getCourseNames();
		return toString;
	}
}
