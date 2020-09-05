package assignment05;
import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();

	
	public TextBook(String authorFirstName,String authorLastName,int numPages,String publish,int pubYear,String ttle, String course, List<Integer> chapter) {
		super(authorFirstName,authorLastName, numPages,publish,pubYear,ttle);
		courseName = course;
		assignedChapters = chapter;
		
		
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
		return(super.toString() + "\n" + courseName + assignedChapters);
	}
}
