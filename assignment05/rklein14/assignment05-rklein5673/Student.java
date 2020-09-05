package assignment05;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
  private Person me;
  private Set<TextBook> courseBooks = new HashSet<TextBook>();

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
    Set<String> tempSet = new TreeSet<String>();
    for (TextBook t : courseBooks) {
      tempSet.add(t.getCourseName());
    }
    return tempSet;
  }
  public String toString() {
    return me.toString() + " taking " + getCourseNames();
  }
}
