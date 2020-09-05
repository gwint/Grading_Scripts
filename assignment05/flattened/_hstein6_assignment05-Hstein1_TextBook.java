package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String firstName, String lastName, int pages, String publish, int year, String ttl, String course) {
		super(firstName, lastName, pages, publish, year, ttl);
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
		return (super.toString() + "\n" + this.getCourseName() + " "
				+ assignedChapters);
		
	}
}
