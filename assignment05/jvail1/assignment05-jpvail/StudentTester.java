package assignment05; 

public class StudentTester{

    public static void main(String[] args){
        Person jason = new Person("Jason", "Vail", "207173345"); 
        Student miles = new Student(jason); 
        TextBook txt = new TextBook("Smith", "john", 25, "Penguin", 1990, "polishness", "Math");
        TextBook txt2 = new TextBook("Vail", "Jason", 500, "Moose", 2001, "polishness", "Geometry");
        txt.addChapter(2); 
        txt2.addChapter(2); 
        miles.addBook(txt2);

        System.out.println(txt.getAssignedChapters());
        System.out.println(miles);


    } 
}
