package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private String publisher;
	private String title;
	private int numPages;
	private int publicationYear;
	
	public Book(String aFN, String aLN, int nPages, String pub, int pubYear, String t){
		authorFirstName = aFN;
		authorLastName = aLN;
		numPages = nPages;
		publisher = pub;
		publicationYear = pubYear;
		title = t;
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
	
	@Override
	public String toString() {
		return authorLastName + ", " + authorFirstName + ". " + title + ". " + publisher + ", " + publicationYear;
	}
}
