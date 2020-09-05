package assignment05;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author CS 140
 *
 */
public class TextBook extends Book{
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String first, String last, int num, String pub, int pubYear, String ttl, String course) {
		super(first,last,num,pub,pubYear,ttl);
		courseName = course;
		
		
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}

	public void setAssignedChapters(List<Integer> assignedChapters) {
		this.assignedChapters = assignedChapters;
	}
	
	public void addChapter(int chap) {
		assignedChapters.add(chap);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + courseName + assignedChapters;
	}
	
}
