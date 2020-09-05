package assignment05;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Student {
	private Person me;
	Set<TextBook> courseBooks = new HashSet<TextBook>();
	public Student(Person person) {
		me = person;
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
		Set<String> courseNames = new TreeSet<String>();
		for(TextBook x:courseBooks) {
			courseNames.add(x.getCourseName());
		}
		return courseNames;
	}
	@Override
	public String toString() {
		return me + " taking " + getCourseNames();
	}
}
