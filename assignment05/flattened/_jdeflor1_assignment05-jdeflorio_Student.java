package assignment05;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private Person me;
	Set<TextBook> courseBooks = new HashSet<>();
	
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
		Set<String> returnSet = new HashSet<>();
		for(TextBook t: courseBooks) {
			returnSet.add(t.getCourseName());
		}
		return returnSet;
	}
	
	@Override
	public String toString() {
		return me.toString()+" taking "+getCourseNames();
	}
	
}
