package assignment05;
import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book{

	private String courseName;
	private List<Integer> assignedChapters = new ArrayList<>();
	
	public TextBook(String aFN, String aLN, int nP, String pub, int pubYear, String ttl, String cN)
	{
		super(aFN, aLN, nP, pub, pubYear, ttl);
		courseName = cN;
	}

	public String getCourseName() {
		return courseName;
	}

	public List<Integer> getAssignedChapters() {
		return assignedChapters;
	}
	
	public void addChapter(int chap)
	{
		assignedChapters.add(chap);
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "\n" + courseName + " " + assignedChapters;
	}
}
