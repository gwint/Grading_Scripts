package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book{
	private String courseName;
	List<Integer> assignedChapters = new ArrayList<Integer>();
	public TextBook(String firstName,String lastName,int pages,String publishr,int year,String titl,String coursName) {
		super(firstName,lastName,pages,publishr,year,titl);
		courseName = coursName;
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
		return super.toString() + "\n" + assignedChapters;
	}
}
