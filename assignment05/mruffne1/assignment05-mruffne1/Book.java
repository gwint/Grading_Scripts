package assignment05;

public class Book {

	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String af, String al, int np, String pub, int pyr, String ttl) {
		authorFirstName = af;
		authorLastName = al;
		numPages = np;
		publisher = pub;
		publicationYear = pyr;
		title = ttl;
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
		return String.format("%s, %s. %s. %s, %d", authorLastName, authorFirstName, title, publisher, publicationYear);
	}
	
}
