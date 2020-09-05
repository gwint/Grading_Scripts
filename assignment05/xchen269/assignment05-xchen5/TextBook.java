package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters;
	public TextBook(String aFN, String aLN, int pages, String pSher, int pYear, String tTle, String cN) {
		super(aFN, aLN, pages, pSher, pYear, tTle);
		courseName = cN;
		assignedChapters = new ArrayList<Integer>();
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
