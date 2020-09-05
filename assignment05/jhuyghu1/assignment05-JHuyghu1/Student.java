package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person human) {
		me = human;
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
		Set<String> books = new TreeSet<>();
		for(TextBook element: courseBooks) {
			books.add(element.getCourseName());
		}
		return books;
	}
	@Override
	public String toString() {
		return (me + " taking " + getCourseNames());
	}
}
