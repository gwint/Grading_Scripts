package assignment05;

import java.util.List;
import java.util.ArrayList;

public class TextBook extends Book{
  private String courseName;
  private List<Integer> assignedChapters = new ArrayList<Integer>();

  public TextBook(String authorFN, String authorLN, int pages,
    String publishCompany, int yearPublished, String bookTitle, String courseName) {
    super(authorFN, authorLN, pages, publishCompany, yearPublished, bookTitle);
    this.courseName = courseName;
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
    return super.toString() + "\n" + getCourseName() + " " + getAssignedChapters();
  }
}
