package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String firstName,String lastName,int pages,String publishr,int year,String titl) {
		authorFirstName = firstName;
		authorLastName = lastName;
		numPages = pages;
		publisher = publishr;
		publicationYear = year;
		title = titl;
	}
	
	@Override
	public String toString() {
		return authorLastName + ", " + authorFirstName + ". "+ title + ". " + publisher + ", " + publicationYear;
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
	
}
