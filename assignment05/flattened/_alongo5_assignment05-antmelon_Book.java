package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	public Book(String authorFirst, String authorLast, int pages, String pub, int pubYear, String bookTitle) {
		// TODO Auto-generated constructor stub
		authorFirstName = authorFirst;
		authorLastName = authorLast;
		numPages = pages;
		publisher = pub;
		publicationYear = pubYear;
		title = bookTitle;
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
