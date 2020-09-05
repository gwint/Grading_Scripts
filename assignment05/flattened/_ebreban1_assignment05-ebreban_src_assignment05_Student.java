package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
	Person me;
	Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person p) {
		this.me = p;
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
		Set<String> tem = new TreeSet<>();
		for(TextBook a : courseBooks) {
			tem.add(a.getCourseName());
		}
		return tem;
	}
	@Override 
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
}