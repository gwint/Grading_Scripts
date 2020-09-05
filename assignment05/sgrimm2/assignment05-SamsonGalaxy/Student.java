package assignment05;

import java.util.Set;
import java.util.HashSet;
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
	
	public Set<String> getCourseNames() {
		Set<String> retVal = new TreeSet<String>();
		for(TextBook t : courseBooks) {
			//System.out.println(t.getCourseName());
			retVal.add(t.getCourseName());
		}
		//System.out.println(retVal);
		return retVal;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(me.getFirstNames());
		sb.append(" ");
		sb.append(me.getLastNames());
		sb.append(" (");
		sb.append(getSSN());
		sb.append(")");
		sb.append(" taking ");
		sb.append(this.getCourseNames());
		return sb.toString();
	}
}
