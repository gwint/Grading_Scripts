package assignment05;
import java.util.List;
import java.util.ArrayList;
public class TextBook extends Book {
	private String courseName;
	private List<Integer> assignedChapters=new ArrayList<Integer>();
	public TextBook(String aFN, String aLN, int nP, String p, int pY, String t, String cN) {
		super(aFN,aLN,nP,p,pY,t);
		courseName=cN;
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
		return super.toString()+"\n "+courseName+assignedChapters;
	}
}
