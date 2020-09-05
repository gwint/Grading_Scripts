package assignment05; 

public class Book{
    private String authorFirstName;
    private String authorLastName; 
    private int numPages; 
    private String publisher; 
    private int publicationYear; 
    private String title; 

    public  Book(String a, String b, int c, String d, int e, String f){
        authorFirstName = a;
        authorLastName = b; 
        numPages = c; 
        publisher = d;
        publicationYear = e; 
        title = f; 
    }

    public String toString(){
        return "" + authorLastName + ", " + authorFirstName + ". " + title + ". " + publisher + ", " + Integer.toString(publicationYear) + "."; 
    }

    public double getNumPages(){
        return (double)numPages; 
    }

}    