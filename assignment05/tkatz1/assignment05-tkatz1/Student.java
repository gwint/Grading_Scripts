package assignment05;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
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
	public Set<String> gerCourseNames(){
		Set<String> retSet = new TreeSet<String>();
		for(var i: courseBooks) {
			retSet.add(i.getCourseName());
		}
		return retSet;

	}
	
	@Override
	public String toString() {
		return me.toString() + " taking " + gerCourseNames();
	}
}
