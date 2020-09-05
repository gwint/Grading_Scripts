package assignment05;

import java.util.*;

class Textbook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();

	public Textbook(String corseName, String firstname, String lastname, int pagenum, String publishr, int publicateyear, String titl) {
		super(firstname, lastname, pagenum, publishr, publicateyear, titl);
		courseName = corseName;
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
		return super.toString() + "\n" + super.getTitle() + " " + assignedChapters;
	}


}
