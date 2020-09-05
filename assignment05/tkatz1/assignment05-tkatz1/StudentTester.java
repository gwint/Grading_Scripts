package assignment05;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.List;

public class StudentTester {
	public static void main(String [] args) {
	Person p1 = new Person("Aaron", "Judge", "028-99-2017");
	Student s1 = new Student(p1);
	TextBook t1 = new TextBook("Aaron", "Boone", 306, "Bronx Inc.", 2009, "How to Win a World Series",  "Baseball 101");
	TextBook t2 = new TextBook("AJ", "Hinch", 299, "Minute Maid Inc.", 2017, "How to lose in the Championship Series", "Losing 101");
	t1.addChapters(40);
	t1.addChapters(54);
	t2.addChapters(21);
	t2.addChapters(27);
	s1.addBook(t1);
	s1.addBook(t2);
	
	System.out.println(t1.getAssignedChapters());
	System.out.println(t2.getAssignedChapters());
	System.out.println(s1.toString());
}
}