package assignment05;
import java.util.ArrayList;
import java.util.List;

public class StudentTester{
    public static void main(String[] args){
        Person p=new Person("Rutvik","Saptarshi","123-45-6789");
        Student s=new Student(p);
        TextBook tb1=new TextBook("Sara", "Baase", 500, "Pearson", 2019, "Gift of Fire", "CS-301");
        TextBook tb2=new TextBook("Remzi","Arpecci-Dusseau",300,"IDK",2014,"OSTEP","CS-320");
        List<Integer> chaplist1=new ArrayList<>();
        List<Integer> chaplist2=new ArrayList<>();
        chaplist1.add(1);
        chaplist1.add(3);
        chaplist2.add(2);
        chaplist2.add(7);
        tb1.setAssignedChapters(chaplist1);
        tb2.setAssignedChapters(chaplist2);
        System.out.println("The assigned chapters for the first textbook are: "+tb1.getAssignedChapters());
        System.out.println("The assigned chapters for the second textbook are: "+tb2.getAssignedChapters());
        s.addBook(tb1);
        s.addBook(tb2);
        System.out.println(s);
    }
}