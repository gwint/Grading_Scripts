package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book{
	
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String authorFrstName, String authorLstName, int nmPages, String pub, int pubYear, String tle, String courseNme) {
		authorFirstName = authorFrstName;
		authorLastName = authorLstName;
		numPages = nmPages;
		publisher = pub;
		publicationYear = pubYear;
		title = tle;
		courseName = courseNme;
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
		return(super.toString() + "\n" + this.courseName + " " + assignedChapters);
		
	}
}
