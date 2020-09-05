package assignment05;

public class StudentTester {
	public static void main(String[] args) {
		Person pete= new Person("Pete", "Davidson","123-45-6789");
		Student peteS = new Student(pete);
		TextBook t1 = new TextBook("Gegory","vanderbeck",668,"PublishHouse",2015,"How To Read","English");
		TextBook t2 = new TextBook("Jon","gasgobe",432,"PublishHouse",2012,"Intro To Calculus","Math");
		t1.addChapter(9);
		t1.addChapter(12);
		t2.addChapter(1);
		t2.addChapter(7);
		peteS.addBook(t1);
		peteS.addBook(t2);
		System.out.println(t1.getAssignedChapters());
		System.out.println(t2.getAssignedChapters());
		System.out.println(peteS);
	}
}
