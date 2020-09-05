package assignment05;

public class StudentTester {
	
	public static void main(String[] args) {
	
	Person Tyler = new Person("Tyler","Gilbert","567-34-2879");
	Student T = new Student("Tyler","Gilbert","567-34-2879", Tyler);
	TextBook Fooled = new TextBook("Nassim","Taleb", 200, "Random House", 2005, "Fooled by Randomness", "Psychology");
	TextBook Business = new TextBook("John","Brooks", 400, "Open Road Media", 2014, "Business Adventures", "Business");
	
	
	Fooled.addChapter(2);
	Business.addChapter(2);
	
	T.addBook(Fooled);
	T.addBook(Business);
	
	System.out.println("Testing getAssignedChapters method. Expected: [2]");
	System.out.println(Fooled.getAssignedChapters());
	System.out.println(Business.getAssignedChapters());
	System.out.println("Testing student tostring method");
	System.out.println(T);
		
	}
	
}
