package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String aFirstName, String aLastName, int nPages, String pub, int pubYear, String title_name) {
		authorFirstName = aFirstName;
		authorLastName = aLastName;
		numPages = nPages;
		publisher = pub;
		publicationYear = pubYear;
		title = title_name;
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
		return(getAuthorLastName() + ", " + getAuthorFirstName() + ". " + getTitle() + ". " + getPublisher() + ", " + getPublicationYear());
	}
	
	
}
