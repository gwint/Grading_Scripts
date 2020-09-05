package assignment05;

public class Tester {
	public static void main(String[] args) {
		LeisureBook LB1 = new LeisureBook("LBFirst1", "LBLast1", 100, "LB-Publisher1", 2019, "Leisure1", Genre.FANTASY);
		LeisureBook LB2 = new LeisureBook("LBFirst2", "LBLast2", 100, "LB-Publisher2", 2000, "Leisure2", Genre.MUSICAL);

		Person p1 = new Person("Doug", "Lowe", "1000-22-333");
		Person p2 = new Person("First", "Last", "2000-11-000");
		
		BookClubMember BCM1 = new BookClubMember(p1);
		BookClubMember BCM2 = new BookClubMember(p2);
				
		BookClub BC = new BookClub();
		BC.addMember(BCM1);
		BC.addMember(BCM2);
		BC.addNewReading(LB1);
		BC.addNewReading(LB2);
		
		BCM1.setPageCount(LB1, 50);
		BCM1.setPageCount(LB2, 100);
		BCM2.setPageCount(LB1, 0);
		BCM2.setPageCount(LB2, 80);

		System.out.println("Person1 Book1 " + BCM1.getPercentRead(LB1) + "%");
		System.out.println("Person1 Book2 " + BCM1.getPercentRead(LB2) + "%");
		System.out.println("Person2 Book1 " + BCM2.getPercentRead(LB1) + "%");
		System.out.println("Person2 Book2 " + BCM2.getPercentRead(LB2) + "%");
		System.out.println("Book1 Average " + BC.getAveragePercentRead(LB1) + "%");
		System.out.println("Book2 Average " + BC.getAveragePercentRead(LB2) + "%");
		System.out.println("Completion Percentage Average " + BC.getCompletionPercentage() + "%");
		
		Student stu1 = new Student(p1);
		TextBook TB1 = new TextBook("LBFirst2", "LBLast2", 100, "TB-Publisher1", 2000, "Java", "CS140");
		TextBook TB2 = new TextBook("Aaa", "Bbb", 100, "TB-Publisher2", 2019, "C++", "CS240");
		TB1.addChapter(1);
		TB1.addChapter(2);
		TB1.addChapter(3);
		TB2.addChapter(8);
		TB2.addChapter(9);
		stu1.addBook(TB1);
		stu1.addBook(TB2);
		
		System.out.println(TB1);
		System.out.println(TB2);
		System.out.println(stu1);
		
	}
}
