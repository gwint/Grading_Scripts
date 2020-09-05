package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	//Constructor to initialize class data
	public Book(String first, String last, int pages, String pub, int yr, String bookTitle)
	{
		authorFirstName = first;
		authorLastName = last;
		numPages = pages;
		publisher = pub;
		publicationYear = yr;
		title = bookTitle;
	}

	//Getters for all class data
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
	
	//@Override
	public String toString() {
		return authorLastName + ", " + authorFirstName + ". " + title + ". " + publisher + ", " + publicationYear;
	}
	
}
