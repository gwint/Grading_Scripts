package assignment05;
import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<Integer>();
	
	public TextBook(String authorFirstName, String authorLastName, int num, String pub, int pubY, String t, String cn) {
		super(authorFirstName, authorLastName, num, pub, pubY, t);
		courseName = cn;
		
	}

	public String getCourseName() {
		return courseName;
	}

	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}
	public void addChapters(int chap) {
		assignedChapters.add(chap);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
}
