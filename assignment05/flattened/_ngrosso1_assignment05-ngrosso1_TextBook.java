package assignment05;
import java.util.ArrayList;
import java.util.List;
//import java.lang.reflect.Array;

public class TextBook extends Book{
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<Integer>();
	
	public TextBook(String afn, String aln, int np, String pub, int py, String t, String cn) {
		super(afn, aln, np, pub, py, t);
		courseName = cn;
	}

	public String getCourseName() {
		return courseName;
	}

	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}
	
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
}
