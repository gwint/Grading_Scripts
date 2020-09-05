package assignment05;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TextBook extends Book{
  private String courseName;
  private List<Integer> assignedChapters = new ArrayList<Integer>();
  public TextBook(String AFN, String ALN, int pages, String pub, int year, String title, String course){
    super(AFN, ALN, pages, pub, year, title);
    this.courseName = course;
  }
  public String getCourseName(){
    return courseName;
  }
  public List<Integer> getAssignedChapters(){
    return assignedChapters;
  }
  public void addChapters(int chap){
    assignedChapters.add(chap);
  }
  public String toString(){
    StringBuilder sb = new StringBuilder(super.toString());
    sb.append(getCourseName());
    sb.append(" ");
    sb.append(getAssignedChapters());
    return sb.toString();
  }

}
