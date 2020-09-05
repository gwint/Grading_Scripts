package assignment05;
import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book{
    private String courseName;
    private List<Integer> assignedChapters = new ArrayList<>();

    public TextBook(String authorfirst, String authorlast, int num_pages, int pub_year, String pub, String book_title, String course_name){
        super(authorfirst, authorlast, num_pages, pub_year, pub, book_title);
        courseName = course_name;
    }

    public String getCourseName(){
        return courseName;
    }

    public List<Integer> getAssignedChapters(){
        return assignedChapters;
    }

    public void addChapter(int chap){
        assignedChapters.add(chap);
    }

    public String toString(){
        return super.toString() + "\n" + courseName + " " + assignedChapters;
    }
}
