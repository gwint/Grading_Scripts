package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person aMe) {
		me = aMe;
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
		TreeSet<String> courseNames = new TreeSet<>();
		for(TextBook book : courseBooks) {
			courseNames.add(book.getCourseName());
		}
		return courseNames;
	}

	@Override
	public String toString() {
		return me + " taking " + getCourseNames();
	}
	
	
}
