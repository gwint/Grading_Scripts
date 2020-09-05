package assignment05;

import java.util.Set;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks;
	
	public Student(Person me) {
		this.me = me;
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
		TreeSet<String> ts = new TreeSet<String>();
		for(TextBook e: courseBooks) {
			ts.add(e.getCourseName());
		}
		return ts;
	}
	@Override
	public String toString() {
		return me + " taking "+ getCourseNames();
	}	
}
