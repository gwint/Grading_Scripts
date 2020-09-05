package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book{
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String fn, String ln, int np, String pb, int pby, String tle, String crsn) {
		super(fn, ln, np, pb, pby, tle);
		// TODO Auto-generated constructor stub
		courseName = crsn;
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

