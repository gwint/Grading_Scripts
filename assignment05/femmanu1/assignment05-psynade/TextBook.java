package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {

private String courseName;
private List<Integer> assignedChapters = new ArrayList<>();

	public TextBook(String firstName, String lastName, int pages, String publisher, int publicationYear, String title, String courseName) {
		super(firstName,lastName,pages,publisher,publicationYear,title);
		this.courseName = courseName;
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
		return super.toString() + ("\n " + courseName + " " + assignedChapters);
	}
	 
//	public static void main(String[] args) {
//		TextBook test = new TextBook("fredrick", "emmanuel", 3055, "someName", 2019, "book name", "history");
//		test.addChapter(3);
//		test.toString();
//	}
}
