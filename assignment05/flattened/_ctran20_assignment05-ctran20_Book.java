package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String fName, String lName, int nPage, String pub, int pubYear, String til ) {
		authorFirstName = fName;
		authorLastName = lName;
		numPages = nPage;
		publisher = pub;
		publicationYear = pubYear;
		title = til;
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
		return String.format("%s, %s. %s. %s, %d./n", authorFirstName,
				authorLastName, title, publisher, publicationYear);
	}
}
