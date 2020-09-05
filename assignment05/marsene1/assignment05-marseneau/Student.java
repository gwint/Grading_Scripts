package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	private Person me;
	Set<TextBook> courseBooks = new HashSet<>();
	
	//Class constructor
	public Student(Person me) {
		this.me = me;
	}

	//Getters for person data
	public String getFirstNames() {
		return me.getFirstNames();
	}

	public String getLastNames() {
		return me.getLastNames();
	}

	public String getSSN() {
		return me.getSSN();
	}
	
	//Add a book to the course book set
	public void addBook(TextBook t)
	{
		courseBooks.add(t);
	}
	
	public Set<String> getCourseNames()
	{
		TreeSet<String> newSet = new TreeSet<>();
		
		for (TextBook t : courseBooks)
		{
			newSet.add(t.getCourseName());
		}
		
		
		return newSet;
	}
	
	//@Override
	public String toString()
	{
		return me.toString() + " taking " + getCourseNames();
	}
	
}
