package assignment05;

import java.util.ArrayList;
import java.util.List;

import assignment05.Genre;


class TextBook extends Book{
	private String courseName;
	private List<Integer>assignedChapters = new ArrayList<Integer>();
	
	public TextBook(String authorF, String authorL, int numP, String pub, int publicationY, String t, String courseN){
		super(authorF,authorL,numP, pub, publicationY, t);
		courseName = courseN;
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
		return (super.toString() + "\n" + getCourseName() + " " + assignedChapters);
	}
}



