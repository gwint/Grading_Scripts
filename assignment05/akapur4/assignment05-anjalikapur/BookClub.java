package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub{
    private Set<BookClubMember> members = new HashSet<>();
    private Set<LeisureBook> readings = new HashSet<>();

    public void addMember(BookClubMember bcm){
        members.add(bcm);
        for(LeisureBook i : readings){
           bcm.addReading(i);
        }
    }

    public void addNewReading(LeisureBook book){ 
    	readings.add(book);
        for(BookClubMember bcm : members) {
        	bcm.addReading(book);
        }
    }

    public double getAveragePercentRead(Book book){
        double total_percentage = 0;
        if(members.size() != 0){
            for(BookClubMember bcm : members){
            	total_percentage += bcm.getPercentRead(book);
            } 
            return (double)total_percentage / members.size();
        }
        return 0.0;
    }

    public double getCompletionPercentage(){
        double total = 0.0; 
        for(LeisureBook book : readings) {
        	total += getAveragePercentRead(book);
        }
        return total / readings.size();
    }
    
    @Override
    public String toString() {
    	String mem = "";
    	for(BookClubMember i : members) {
    		mem += i;
    	}
    	return mem + "poop";
    }
}
