package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;

	public Book(String fName, String lName, int num, String pub, int year, String bTitle) {
		authorFirstName = fName;
		authorLastName = lName;
		numPages = num;
		publisher = pub;
		publicationYear = year;
		title = bTitle;
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
		return getAuthorLastName() + ", " + getAuthorFirstName() + ". " + getTitle() + ". " + getPublisher() + ", " + getPublicationYear() + ".";
	}
	
}
