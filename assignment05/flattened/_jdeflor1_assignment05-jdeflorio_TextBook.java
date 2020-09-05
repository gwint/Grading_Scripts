package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String firstName, String lastName, int pages, String pub, int pubYr, String aTitle, String course) {
		super(firstName, lastName, pages, pub, pubYr, aTitle);
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
		return super.toString()+"\n"+courseName+" "+assignedChapters;
	}
}
