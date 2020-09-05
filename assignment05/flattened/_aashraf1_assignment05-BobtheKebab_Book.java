package assignment05;

public class Book {

	private String authorFirstName, authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book (String aFN, String aLN, int nPgs, String pub, int pubYr, String ttl) {
		authorFirstName = aFN;
		authorLastName = aLN;
		numPages = nPgs;
		publisher = pub;
		publicationYear = pubYr;
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
	
	@Override
	public String toString() {
		return String.format("%s, %s. %s. %s. %d.", authorLastName, authorFirstName, title, publisher, publicationYear);
	}
	
}
