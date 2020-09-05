package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<Integer>();
	
	public TextBook (String aFN, String aLN, int nPgs, String pub, int pubYr, String ttl, String course) {
		super(aFN, aLN, nPgs, pub, pubYr, ttl);
		courseName = course;
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
		return super.toString() + String.format("\n%s ", courseName) + assignedChapters;
	}

}
