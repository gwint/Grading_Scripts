package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String afn, String aln, int np, String p, int py, String t, String cn) {
		super(afn, aln, np, p, py, t);
		courseName = cn;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}
	
	public void addChapter(int chap) {
		for (int c = 1; c <= chap; c++) {
			assignedChapters.add(c);
		}
	}
	
	@Override
	public String toString() {
		return(super.toString() + "\n" + courseName + " " + assignedChapters);
	}
}