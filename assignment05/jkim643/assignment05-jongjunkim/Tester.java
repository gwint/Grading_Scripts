package assignment05;

public class Tester {
	
	public static void main(String[] args) {
		
		Person human = new Person("jongjun" , "jun" , "999999999");
		Person human2 = new Person("Hana", "Choi", "888888888");
		Student stu = new Student(human);
		TextBook book1 = new TextBook("Henry", "Kim" , 49, "Johnson" , 2018, "Education", "Phycology");
		TextBook book2 = new TextBook("Gary" , "Choi" , 100, "Andicott", 1999, "Cutting", "Art");
		
				
				
		book1.addChapter(1);
		book1.addChapter(2);
	
		book2.addChapter(4);
		book2.addChapter(5);
		
		stu.addBook(book1);
		stu.addBook(book2);
		
		System.out.println(stu);
		System.out.println(book1);
		System.out.println(book2);

		
	
	}

}
