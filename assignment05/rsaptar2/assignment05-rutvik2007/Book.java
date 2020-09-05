package assignment05;

public class Book{
    String authorFirstName;
    String authorLastName;
    int numPages;
    String publisher;
    int publicationYear;
    String title;

    public Book(String authorFirstName,String authorLastName, int numPages, String publisher, int publicationYear, String title) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.numPages = numPages;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return this.authorLastName+", "+authorFirstName+". "+title+". "+publisher+", "+publicationYear+".";
    }


}