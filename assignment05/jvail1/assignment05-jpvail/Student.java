package assignment05; 
import java.util.HashSet; 
import java.util.TreeSet; 
import java.util.Set; 

public class Student{
    private Person me;
    private Set<TextBook> courseBooks = new HashSet<>(); 
    
    public Student(Person a){
        this.me = a;
    }
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

public void addBook(TextBook t){
    courseBooks.add(t);
}

public Set<String> getCourseNames(){
    Set<String> courseNames = new TreeSet<>(); 
    for(TextBook t : courseBooks){
        courseNames.add(t.getCourseName()); 
    }
    return courseNames; 
}

public String toString(){
    return me.toString() + " taking " + getCourseNames(); 
}




}