package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	public TextBook(String authorFirst, String authorLast, int pages, String pub, int pubYear, String bookTitle, String course) {
		super(authorFirst, authorLast, pages, pub, pubYear, bookTitle);
		// TODO Auto-generated constructor stub
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
	
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
}
