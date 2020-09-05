package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks;
	
	public Student(Person nMe) {
		me = nMe;
		courseBooks = new HashSet<>();
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

	public Set<String> getCourseNames() {
		Set<String> result = new TreeSet<>();
		for(TextBook e : courseBooks) {
			 result.add(e.getCourseName());
		}
		return result;
	}
	
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
}
