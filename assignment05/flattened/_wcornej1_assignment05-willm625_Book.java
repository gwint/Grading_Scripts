package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String fn, String ln, int np, String pb, int pby, String tle) {
		authorFirstName = fn;
		authorLastName = ln;
		numPages = np;
		publisher = pb;
		publicationYear = pby;
		title = tle;
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
		return  "" + authorLastName + ", " + authorFirstName + ". " + title + ". " + publisher + ", " + publicationYear;
	}
	

	

}

