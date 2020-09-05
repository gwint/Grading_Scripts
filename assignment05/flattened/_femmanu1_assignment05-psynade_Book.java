package assignment05;

public class Book {

	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;

	public Book(String firstName, String lastName, int pages, String publisher, int publicationYear, String title) {
		authorFirstName = firstName;
		authorLastName = lastName;
		numPages = pages;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.title = title;
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
		return authorLastName + " " + authorFirstName + ", " + title + " ," + publisher + " " + publicationYear + " ";
	}

	
}
