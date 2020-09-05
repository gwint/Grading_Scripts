package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {

	private Person me;
	Set<TextBook> courseBooks = new HashSet<>();
	
	public Student (Person self) {
		me = self;
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
		TreeSet<String> ret = new TreeSet<>();
		for (TextBook b : courseBooks) {
			ret.add(b.getCourseName());
		}
		return ret;
	}
	
	@Override
	public String toString() {
		return me + " taking " + getCourseNames();
	}
	
}
