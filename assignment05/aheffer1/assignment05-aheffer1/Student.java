package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
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
	public void addBook(TextBook t) {
		courseBooks.add(t);
	}
	// TODO figure this out //
	public Set<String> getCourseNames(){
		TreeSet<String> treeset = new TreeSet<>();
		for(TextBook i : courseBooks) {
			treeset.add(i.getCourseName());
		}
		return treeset;
	}
	@Override
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
}
