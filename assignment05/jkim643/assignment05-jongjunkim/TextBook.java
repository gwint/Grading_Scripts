package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book {
	
	private String courseName;
	List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String first, String last, int page, String pub, int pyear, String tit, String cou) {
		super(first, last ,page ,pub, pyear, tit);
		courseName = cou;
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
		return super.toString() + "\n" + courseName + " , " + assignedChapters;
	}

}
