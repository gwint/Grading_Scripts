package assignment05;

import java.util.*;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person me) {
		this.me = me;
	}
	
	public void addBook(TextBook t) {
		courseBooks.add(t);
	}
	
	public Set<String> getCourseNames(){
		Set<String> retSet = new TreeSet<>();
		for(TextBook b: courseBooks) {
			retSet.add(b.getCourseName());
		}
		return retSet;
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
	
	@Override
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
}
