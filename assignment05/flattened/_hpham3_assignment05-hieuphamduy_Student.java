package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
	public Student(Person student) {
		me = student;
	}
	
	public Person getMe() {
		return me;
	}
	public void setMe(Person me) {
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
	
	public void addBook(TextBook t) {
		courseBooks.add(t);
	}
	
	public Set<String> getCourseNames(){
		Set<String> temp = new TreeSet<>();
		for(TextBook i: courseBooks) {
			temp.add(i.getCourseName());
		}
		return temp;
	}
	
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
	
	
}
