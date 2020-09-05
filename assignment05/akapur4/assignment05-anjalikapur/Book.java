package assignment05;

public class Book{
    private String authorFirstName; //1
    private String authorLastName; //2
    private int numPages; //3
    private int publicationYear;  //4
    private String publisher; // 5
    private String title; //6

    public Book(String authorfirst, String authorlast, int num_pages, int pub_year, String pub, String book_title){
        authorFirstName = authorfirst;
        authorLastName = authorlast;
        numPages = num_pages;
        publicationYear = pub_year;
        publisher = pub;
        title = book_title;
    }

    public String getAuthorFirstName(){
        return authorFirstName;
    }

    public String getAuthorLastName(){
        return authorLastName;
    }

    public int getNumPages(){
        return numPages;
    }

    public int getPublicationYear(){
        return publicationYear;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getTitle(){
        return title;
    }

    public String toString(){
        return authorLastName + authorFirstName + title + publisher;
    }

}
