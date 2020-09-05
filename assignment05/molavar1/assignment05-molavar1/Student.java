package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks= new HashSet<>();
	private Student(Person m) {
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
		Set<String> set = new TreeSet<>();
		for(TextBook t: courseBooks) {
			set.add((t.getCourseName()));
		}
		return set;
	}
	@Override
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
}
