package assignment05; 
import java.util.HashSet; 
import java.util.TreeSet; 
import java.util.Set; 

public class BookClubTester{
    public static void main(String[] args){
    LeisureBook book = new LeisureBook("Doug", "Lowe", 912, "Wiley", 2011, "Java All-in-One For Dummies", Genre.NON_FICTION);
    LeisureBook book2 = new LeisureBook("Jason", "Pine", 123, "Parch", 1999, "Java for Smarter", Genre.SCIENCE_FICTION);

    Person jason = new Person("Jason", "Vail", "207173345"); 
    Person miles = new Person("miles", "ventura", "12341234"); 

    BookClubMember bcm1 = new BookClubMember(jason);
    bcm1.addReading(book);
    bcm1.setPageCount(book, 140);
    bcm1.addReading(book2);
    bcm1.setPageCount(book2, 2);
    BookClubMember bcm2 = new BookClubMember(miles);
    bcm2.addReading(book);
    bcm2.setPageCount(book, 199);
    bcm2.addReading(book2);
    bcm2.setPageCount(book2, 80);
    BookClub bc = new BookClub();

    bc.addMember(bcm1);
    bc.addMember(bcm2);
    bc.addNewReading(book);
    bc.addNewReading(book2);


    System.out.println(bc.getAveragePercentRead(book2));
    System.out.println(bc.getCompletionPercentage());
    }

}