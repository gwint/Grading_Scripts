package assignment05; 
import java.util.HashSet; 
import java.util.TreeSet; 
import java.util.Set; 

public class BookClub{
    private Set<BookClubMember> members = new HashSet<>(); 
    private Set<LeisureBook> readings = new HashSet<>(); 

    public void addMember(BookClubMember bcm){
        members.add(bcm); 

        for(LeisureBook t : readings){
            bcm.addReading(t); 
        }
    }

    public void addNewReading(LeisureBook book){
        readings.add(book); 
        for(BookClubMember bcm : members){
            bcm.addReading(book); 
        }
    }

    public double getAveragePercentRead(Book book){
        if(this.members.size() == 0){
            return 0.0; 
        }

        double total = 0.0;  
        for(BookClubMember bcm :members){
            total = total + bcm.getPercentRead(book); 
        }

    return total / members.size(); 
    }


    public double getCompletionPercentage(){
        double total = 0.0; 
        for(LeisureBook b : readings ){
            total = total + getAveragePercentRead(b); 
        }

        double average = total / readings.size(); 

        return average; 
    }
}
