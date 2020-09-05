package assignment05;
import java.util.ArrayList;
import java.util.List;

public class StudentTester {
	public static void main(String [] args){
	Person korhan = new Person("Korhan", "Citlak", "101000009");
	Student kor = new Student(korhan);
	TextBook history = new TextBook("Wash", "Thing", 250,"Sony", 2018, "What Is History","History103");
	
	TextBook anthro = new TextBook("Eran", "Coupe", 130, "Google", 2017, "How to anthro", "anthro101");
	
	history.addChapter(1);
	history.addChapter(2);
	
	anthro.addChapter(3);
	anthro.addChapter(4);
	System.out.println("anthro");
	
	System.out.println(anthro.toString());
	System.out.println("history");
	System.out.println(history.toString());
	System.out.println("Student");
	System.out.print(kor.toString());

}
}