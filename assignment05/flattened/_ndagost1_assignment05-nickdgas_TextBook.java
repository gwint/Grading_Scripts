package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String fstName, String lstName, int pgs, String pub, int pubYear, String ttl, String crsName) {
		super(fstName, lstName, pgs, pub, pubYear, ttl);
		this.courseName = crsName;
	}
	public String getCourseName() {
		return this.courseName;
	}
	public List<Integer> getAssignedChapters() {
		return this.assignedChapters;
	}	
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	@Override
	public String toString() {
		return super.toString() + "\n" + assignedChapters;
	}
}
