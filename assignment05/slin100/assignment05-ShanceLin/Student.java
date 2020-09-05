package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
	private Person me;
	Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person prsn) {
		me = prsn;	
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
		Set<String> result = new TreeSet<String>();
		for (TextBook tb : courseBooks) {
			result.add(tb.getCourseName());
		}
		return result;
	}
	
	@Override
	public String toString() {
		return (me.toString() + " taking " + this.getCourseNames());
	}
}
