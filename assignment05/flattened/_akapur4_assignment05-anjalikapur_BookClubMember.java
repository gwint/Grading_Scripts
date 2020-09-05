package assignment05;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class BookClubMember{
    private Person me;
    private Set<LeisureBook> readings = new HashSet<>();
    private Map<LeisureBook, Integer> pagesRead = new HashMap<>();

    public BookClubMember(Person person){
        me = person;
    }

    public void addReading(LeisureBook book){
        readings.add(book);
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

    public void setPageCount(LeisureBook book, int count){
        pagesRead.put(book, count);
    }

    public Set<LeisureBook> getReadings(){
        return readings;
    }

    public double getPercentRead(Book book){
        if(pagesRead.containsKey(book)){
            return ((double)pagesRead.get(book)/(double)book.getNumPages()) * 100.0;
        }
        else {
        	return 0.0;
        }
    }
    
//    @Override
//    public String toString() {
//    	String mem = "";
//    	for(BookClubMember i : members) {
//    		mem += i;
//    	}
//    	return mem + "poop";
    

}
