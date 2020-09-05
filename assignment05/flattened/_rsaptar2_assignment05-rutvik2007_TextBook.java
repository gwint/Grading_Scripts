package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book{
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    String courseName;
    List<Integer> assignedChapters=new ArrayList<>();

    public TextBook(String authorFirstName, String authorLastName, int numPages, String publisher, int publicationYear, String title, String courseName){
        super(authorFirstName, authorLastName, numPages,publisher,publicationYear,title);
        this.courseName=courseName;
    }

    public List<Integer> getAssignedChapters() {
        return assignedChapters;
    }

    public void setAssignedChapters(List<Integer> assignedChapters) {
        this.assignedChapters = assignedChapters;
    }

    public void addChapter(int chap){
        assignedChapters.add(chap);
    }
    public String toString(){
        return super.toString()+"\n"+courseName+" "+assignedChapters;
    }


}