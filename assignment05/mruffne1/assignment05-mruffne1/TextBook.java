package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String af, String al, int np, String pub, int pyr, String ttl, String cn) {
		super(af, al, np, pub, pyr, ttl);
		courseName = cn;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public List<Integer> getAssignedChapters(){
		return assignedChapters;
	}
	
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	
	public String toString() {
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
	
	

}
