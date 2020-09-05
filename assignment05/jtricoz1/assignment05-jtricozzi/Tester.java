package assignment05;

public class Tester{
	public static void main(String[] args) {
		Person John = new Person("John", "Tricozzi", "12345678");
		Student firstStudent = new Student(John);
		Person Jeremy = new Person("Jeremy", "Stark", "12345679");
		Student secondStudent = new Student(Jeremy);
		TextBook txt1 = new TextBook("Bill", "Bogue", 100, "Penguin", 2000, "U.S History", "History");
		TextBook txt2 = new TextBook("Will", "Rogue", 200, "Scholastic", 2010, "Chemistry", "Chemistry");
		txt1.addChapter(1);
		txt1.addChapter(2);
		txt2.addChapter(3);
		txt2.addChapter(4);
		firstStudent.addBook(txt1);
		firstStudent.addBook(txt2);
		System.out.println(txt1.getAssignedChapters());
		System.out.println(txt2.getAssignedChapters());
		System.out.println(firstStudent);
		LeisureBook lb1 = new LeisureBook("Will", "Smith", 300, "Company", 2011, "Rangers", Genre.FANTASY);
		LeisureBook lb2 = new LeisureBook("James", "Jones", 400, "Company2", 2016, "Ghosts", Genre.HORROR);
		BookClubMember firstMember = new BookClubMember(John);
		BookClubMember secondMember = new BookClubMember(Jeremy);
		BookClub testBookClub = new BookClub();
		testBookClub.addMember(firstMember);
		testBookClub.addMember(secondMember);
		firstMember.addReading(lb1);
		secondMember.addReading(lb2);
		testBookClub.addNewReading(lb1);
		testBookClub.addNewReading(lb2);
		firstMember.setPageCount(lb1, 20);
		firstMember.setPageCount(lb2, 120);
		secondMember.setPageCount(lb1, 90);
		secondMember.setPageCount(lb2, 15);
		System.out.println(firstMember.getPercentRead(lb1));
		System.out.println(secondMember.getPercentRead(lb1));
		System.out.println(testBookClub.getAveragePercentRead(lb1));
		System.out.println(firstMember.getPercentRead(lb2));
		System.out.println(secondMember.getPercentRead(lb2));
		System.out.println(testBookClub.getAveragePercentRead(lb2));
		System.out.println(testBookClub.getCompletionPercentage());
	} 
	
	
	
}