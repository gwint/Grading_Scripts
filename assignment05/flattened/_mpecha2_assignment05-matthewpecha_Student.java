package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<Textbook> courseBooks = new HashSet<>();
	
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
	
	public void addBook(Textbook t) {
		courseBooks.add(t);
	}
	
	public Set<String> getCourseNames(){
		Set<String> newSet = new TreeSet<>();
		
		for(Textbook t : courseBooks) {
			newSet.add(t.getCourseName());
		}
		
		return newSet;
	}
	
	@Override
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
}
