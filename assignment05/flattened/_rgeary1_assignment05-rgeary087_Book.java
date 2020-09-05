package assignment05;

public class Book {
	private String authorFirstName, authorLastName, publisher, title;
	private int numPages, publicationYear;
	
	public Book(String firstName, String lastName, int numPages, String publisher, int publicationYear, String title) {
		authorFirstName = firstName;
		authorLastName = lastName;
		this.numPages = numPages;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.title = title;
	}
	public String toString() {
		return authorLastName + ", " + authorFirstName + "'s book " + title + " published by " + publisher + " in " + publicationYear;
	}
	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getTitle() {
		return title;
	}

	public int getNumPages() {
		return numPages;
	}

	public int getPublicationYear() {
		return publicationYear;
	}
	
}
