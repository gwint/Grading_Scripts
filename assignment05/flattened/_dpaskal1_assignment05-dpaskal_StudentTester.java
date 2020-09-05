package assignment05;

public class StudentTester {

	public static void main(String[] args) {
		Person me = new Person("Daniel", "Paskalev", "123-45-6789");
		Student meS = new Student(me);
		TextBook math = new TextBook("John", "Doe", 500, "Pearson", 2015, "Discrete Mathematics", "Math 314");
		TextBook compsci = new TextBook("Oliver", "Smith", 1000, "Pearson", 2018, "Programming Languages", "CS 471");
		meS.addBook(math);
		meS.addBook(compsci);
		math.addChapter(1);
		math.addChapter(2);
		compsci.addChapter(10);
		compsci.addChapter(11);
		System.out.println(math.getAssignedChapters());
		System.out.println(compsci.getAssignedChapters());
		System.out.println(meS);
	}

}
