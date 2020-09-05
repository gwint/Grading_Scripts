package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student {
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	
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
		Set<String> retSet = new TreeSet<>();
		for(TextBook b: courseBooks) {
			retSet.add(b.getCourseName());
		}
		return retSet;
	}
	
	@Override
	public String toString() {
		return me.toString() + " taking " + getCourseNames();
	}
	
	public static void main(String args[]) {
		Person person = new Person("Jack", "Stanley", "111223333");
		Student student = new Student(person);
		TextBook ghosts = new TextBook("Shirley", "Jackson", 200, "Penguin Publishers", 1959, "The Haunting of Hill House", "Ghosts in American Culture");
		TextBook math = new TextBook("Bob", "Smith", 999, "Pearson", 2018, "Probability & Statistics for Engineers & Scientists", "Prob & Stat");
		student.addBook(ghosts);
		student.addBook(math);
		ghosts.addChapter(2);
		ghosts.addChapter(7);
		math.addChapter(1);
		math.addChapter(5);
		System.out.println(ghosts.getAssignedChapters());
		System.out.println(math.getAssignedChapters());
		System.out.println(student);
	}
}
