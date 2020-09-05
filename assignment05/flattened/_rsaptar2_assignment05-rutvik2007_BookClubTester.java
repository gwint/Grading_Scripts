package assignment05;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class BookClubTester{
    public static void main(String[] args){
        LeisureBook lb1=new LeisureBook("Rudyard","Kipling",300,"Penguin",1941,"Jungle Book",Genre.FANTASY);
        LeisureBook lb2=new LeisureBook("JK","Rowling",400,"Bloomsbury",2007,"Harry Potter",Genre.FANTASY);
        BookClubMember bcm1 = new BookClubMember(new Person("Rutvik","Saptarshi","123-45-6789"));
        BookClubMember bcm2 = new BookClubMember(new Person("Stephanie","Chan","987-65-4321"));
        BookClub bc= new BookClub();
        bc.addMember(bcm1);
        bc.addMember(bcm2);
        bc.addNewReading(lb1);
        bc.addNewReading(lb2);
        bcm1.setPageCount(lb1, 240);
        bcm2.setPageCount(lb1, 200);
        bcm1.setPageCount(lb2, 100);
        bcm2.setPageCount(lb2, 219);
        System.out.println(bc.getAveragePercentRead(lb1));
        System.out.println(bc.getAveragePercentRead(lb2));
        System.out.println(bc.getCompletionPercentage());
    }
}