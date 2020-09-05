package assignment05;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Student{
    private Person me;
    private Set<TextBook> courseBooks = new HashSet<>();

    public Student(Person person){
        me = person;
    }

    public String getFirstNames(){
	       return me.getFirstNames();
    }

    public String getLastNames(){
	       return me.getLastNames();
    }

    public String getSSN(){
	       return me.getSSN();
    }

    public void addBook(TextBook t){
        courseBooks.add(t);
    }
 

    public Set<String> getCourseNames(){
        Set<String> tree_set = new TreeSet<>();
        for(TextBook element : courseBooks){
            tree_set.add(element.getCourseName());
        }
        return tree_set;
    }

    public String toString(){
        return me.toString() +  " taking "  + getCourseNames();
    }

}
