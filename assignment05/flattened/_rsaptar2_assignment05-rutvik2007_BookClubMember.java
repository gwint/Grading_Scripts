package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BookClubMember{
    Person me;
    Set<LeisureBook> readings = new HashSet<>();
    Map<LeisureBook, Integer> pagesRead=new HashMap<>();
    public BookClubMember(Person p){
        me=p;
    }
    public void addReading(LeisureBook book){
        readings.add(book);
    }
    public void setPageCount(LeisureBook book, int count){
        if(count<=book.getNumPages()){
            pagesRead.put(book, count);
        }
    }
    public Set<LeisureBook> getReadings(){
        return readings;
    }
    public Map<LeisureBook,Integer> getPagesRead(){
        return pagesRead;
    }
    public double getPercentRead(Book book){
        //System.out.println(pagesRead.containsKey(book));
        double percentage=(pagesRead.containsKey(book))?((pagesRead.get(book)*100.0)/book.getNumPages()):0;
        return percentage;
    }
}