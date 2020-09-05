package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BookClub{
    Set<BookClubMember> members=new HashSet<>();
    Set<LeisureBook> readings=new HashSet<>();
    public void addMember(BookClubMember bcm){
        if(bcm!=null){
            members.add(bcm);
            for(LeisureBook book : readings){
                bcm.addReading(book);
            }
        }
    }
    public void addNewReading(LeisureBook book){
        if(book!=null){
            readings.add(book);
            for(BookClubMember bcm: members){
                bcm.addReading(book);
            }
        }
    }
    public double getAveragePercentRead(Book book){
        double average=0.0;
        if(book!=null && members.size()!=0){
            for(BookClubMember bcm : members){
                average+=bcm.getPercentRead(book);
            }
            average/=members.size();
        }
        return average;
    }
    public double getCompletionPercentage(){
        double average=0;
        if(readings.size()!=0){
            for(LeisureBook book : readings){
                average+=getAveragePercentRead(book);
            }
            average/=readings.size();
        }
        return average;
    }

}