package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book{
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<Integer>();
	
	public TextBook(String aF, String aL, int nP, String p, int pY, String t, String cN) {
		super(aF, aL, nP, p, pY, t);
		courseName = cN;
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
		return (super.toString() + "\n" + courseName + " " + assignedChapters);
	}
}
