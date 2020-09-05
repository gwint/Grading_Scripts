package assignment05;

public class Book {
	private String authorFirstName;
	private String  authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String fstName, String lstName, int pgs, String pub, int pubYear, String ttl) {
		authorFirstName = fstName;
		authorLastName = lstName;
		numPages = pgs;
		publisher = pub;
		publicationYear = pubYear;
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
		return "Book [authorLastName=" + authorLastName + "authorFirstName=" + authorFirstName + ", title=" + title + ", publisher="
				+ publisher + ", publicationYear=" + publicationYear + "]";
	}
}
