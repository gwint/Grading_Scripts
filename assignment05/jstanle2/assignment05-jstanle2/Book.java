package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String authorFN, String authorLN, int numPgs, String pub, int pubYr, String tit) {
		authorFirstName = authorFN;
		authorLastName = authorLN;
		numPages = numPgs;
		publisher = pub;
		publicationYear = pubYr;
		title = tit;
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
		return "" + authorLastName + ", " + authorFirstName + ". " + title + ". " + publisher + ", " + publicationYear + ".";
	}
}
