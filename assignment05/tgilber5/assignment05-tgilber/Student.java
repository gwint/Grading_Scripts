package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student extends Person{

	private Person me;
	private Set<TextBook> courseBooks;
	
	public Student(String fstNames, String lstNames, String ssnString, Person Person) {
		super(fstNames, lstNames, ssnString);
		me = Person;
		courseBooks = new HashSet<>();
		
		
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
		Set<String> result = new TreeSet<>();
		for(TextBook i : courseBooks) {
			result.add(i.getCourseName());
		}
		return result;
	}

	@Override
	public String toString() {
		return me + " taking " + getCourseNames();
	}
	
	
	
	
	
}
