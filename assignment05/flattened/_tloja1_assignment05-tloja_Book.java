package assignment05;

public class Book {

private String authorFirstName;
private String authorLastName;
private int numPages;
private String publisher;
private int publicationYear;
private String title;
public Book(String authorFirstName, String authorLastName, int numPages, String publisher, int publicationYear, String title) {
this.authorFirstName = authorFirstName;
this.authorLastName = authorLastName;
this.numPages = numPages;
this.publisher = publisher;
this.publicationYear = publicationYear;
this.title = title;
}
public String toString() {
return this.authorLastName + "," + this.authorFirstName + ". " + this.title + ". " + this.publisher + ", " +  this.publicationYear;
}

public String getAuthorFirstName() {
return authorFirstName;
}
public String getAuthorLastName() {
return authorLastName;
}
public int getNumPages() {
return numPages;
}
public String getPublisher() {
return publisher;
}
public int getPublicationYear() {
return publicationYear;
}
public String getTitle() {
return title;
}
}