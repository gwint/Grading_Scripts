package assignment05;
import java.util.ArrayList;
import java.util.List;

public class StudentTester {

	
	public static void main(String [] args) {
		Person p = new Person("Bloodgood","Adam","1234567890");
		TextBook t1 = new TextBook("Smith","Mike",500, "Barnes & Noble", 2019, "Mike Smith's Notes On Life 101","PSYCH 101");
		TextBook t2 = new TextBook("James","Kevin",250,"Kevin James Publishing Inc.", 2015, "Yes, Kevin James Made A Textbook", "MATH 999");
		Student s = new Student(p);
		s.addBook(t1);
		s.addBook(t2);
		List<Integer> ch1 = new ArrayList<>();
		ch1.add(3);
		ch1.add(6);
		List<Integer> ch2 = new ArrayList<>();
		ch2.add(1);
		ch2.add(7);
		ch2.add(13);
		t1.setAssignedChapters(ch1);
		t2.setAssignedChapters(ch2);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(s);
		
	}
}
