package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person p) {
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
		SortedSet<String> courses = new TreeSet<>();
		for(TextBook i: courseBooks) {	
			courses.add(i.getCourseName());
		}
		return courses; 
	}
	
	@Override
	public String toString() {
		return(me.getFirstNames()+ " " + me.getLastNames()+ " " + me.getSSN() + " " + "taking" + " " + getCourseNames());
	}

	

}
