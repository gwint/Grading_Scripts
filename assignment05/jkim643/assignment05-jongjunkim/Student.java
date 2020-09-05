package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {

	private Person me;
	Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person m) {
		me = m;
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
		
		TreeSet<String> tree = new TreeSet<>();
		
		for(var c: courseBooks) {
			tree.add(c.getCourseName());
		}
		
		return tree;
	}
	
	@Override
	public String toString(){
		return me.toString() + " taking " + getCourseNames();
		
	}
	
}
