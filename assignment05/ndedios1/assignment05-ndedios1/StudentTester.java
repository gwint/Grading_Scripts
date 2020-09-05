package assignment05;


public class StudentTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("*********************TESTER FOR STUDENT*********************\n");
		Person jsmith = new Person("John", "Smith", "012-34-5678");
		Student student = new Student(jsmith);
		TextBook textbook1 = new TextBook("Jimmy", "Kramer", 500, "Binghamton University", 2016, "How to Pass CS class", "CS140" );
		TextBook textbook2 = new TextBook("Gen", "Loeffler", 800, "McGraw Hill", 2019, "How to Pass Calculus", "MATH227");
		textbook1.addChapter(10);
		textbook1.addChapter(11);
		textbook2.addChapter(1);
		textbook2.addChapter(3);
		student.addBook(textbook1);
		student.addBook(textbook2);
		System.out.printf("*********************ASSIGNED CHAPTERS FOR EACH TEXTBOOK*********************\n");
		System.out.println("Textbook 1 has " + textbook1.getAssignedChapters() + " assigned chapters\n");
		System.out.println("Textbook 2 has " + textbook2.getAssignedChapters() + " assigned chapters\n");
		System.out.printf("*********************PRINTING STUDENT*********************\n");
		System.out.println(student);
		System.out.printf("\n*********************TESTER COMPLETED*********************\n");
	}

}
