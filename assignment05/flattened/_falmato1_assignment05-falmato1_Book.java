package assignment05;

public class Book {
	private String firstName;
	private String lastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	public Book(String frstNm, String ltNm, int nmPgs, String pblshr,
				int pblcYr, String ttl) {
		firstName = frstNm;
		lastName = ltNm;
		numPages = nmPgs;
		publisher = pblshr;
		publicationYear = pblcYr;
		title = ttl;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
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
		String toString = lastName + ", " + firstName + ". " + 
						title + ". " + 
						publisher + ", " + publicationYear + ".";
		return toString;
	}
}
