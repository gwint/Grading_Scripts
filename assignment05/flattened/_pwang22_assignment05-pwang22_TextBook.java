package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String a, String b, int c, String d, int e, String f, String g) {
		super(a, b, c, d, e, f);
		courseName = g;
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
