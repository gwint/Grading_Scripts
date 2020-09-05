package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String a, String b, int c, String d, int e, String f) {
		authorFirstName = a;
		authorLastName = b;
		numPages = c;
		publisher = d;
		publicationYear = e;
		title = f;
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
	
	public String toString() {
		return authorLastName + ", " + authorFirstName + ". " + title + ". " + publisher + ", " + publicationYear + ".";
	}
}
