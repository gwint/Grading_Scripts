package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String FN, String LN, int numP, String pub, int pubYr, String nTitle) {
		authorFirstName = FN;
		authorLastName = LN;
		numPages = numP;
		publisher = pub;
		publicationYear = pubYr;
		title = nTitle;
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
	
	//Author Last Name, First Name. Title of book. Publisher name, Year of publication
	public String toString() {
		return authorLastName + ", " + authorFirstName + ". " + title + ". " + publisher + ", " + publicationYear;
	}
}