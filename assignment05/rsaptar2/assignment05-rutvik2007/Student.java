package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Student{
    Person me;
    Set<TextBook> courseBooks=new HashSet<>();
    public String getFirstNames()
    {
        return me.getFirstNames();
    }
    public String getLastNames()
    {
        return me.getLastNames();
    }
    public String getSSN()
    {
        return me.getSSN();
    }
    public void addBook(TextBook t)
    {
        courseBooks.add(t);

    }
    public Student(Person p){
        me=p;
    }
    public Set<String> getCourseNames(){
        Set<String>courseNames=new TreeSet<>();
        for(TextBook tb : courseBooks){
            //System.out.println(tb);
            courseNames.add(tb.getCourseName());
        }
        return courseNames;
    }
    @Override
    public String toString(){
        return me.toString()+" taking "+getCourseNames();
    }
}