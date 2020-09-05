package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book{

	private String courseName;
	List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String afn, String aln, int np, String p, int py, String t, String cn) {
		 super(afn, t, py, t, py, t);
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
	
	@Override
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}

}
