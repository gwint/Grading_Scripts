package assignment05;

import java.util.ArrayList;
import java.util.List;

import assignment05.Genre;

public class Book{
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book(String authorF, String authorL, int numP, String pub, int publicationY, String t) {
		authorFirstName = authorF;
		authorLastName = authorL;
		numPages = numP;
		publisher = pub;
		publicationYear = publicationY;
		title = t;
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
		return(getAuthorLastName() + getAuthorFirstName() + getTitle() + getPublisher() + getPublicationYear());
	}
}







