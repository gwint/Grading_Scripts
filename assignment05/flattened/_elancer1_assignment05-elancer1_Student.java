package assignment05;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();

	public Student(Person p) {
		me = p;
	}

	public void addBook(TextBook t) {
		courseBooks.add(t);
	}

	public Set<String> getCourseNames() {
		Set<String> cNameSet = new TreeSet<String>();
		for (TextBook t: courseBooks) {
			cNameSet.add(t.getCourseName());
		}
		return cNameSet;
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
	
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}

}
