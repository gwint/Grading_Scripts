package assignment05;
import java.util.*;

public class Book {
	private String authorFirstname;
	private String authorLastname;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;

	public Book(String firstname, String lastname, int pagenum, String publishr, int publicateyear, String titl) {
		authorFirstname = firstname;
		authorLastname = lastname;
		numPages = pagenum;
		publisher = publishr;
		publicationYear = publicateyear;
		title = titl;
	}

	public String getAuthorFirstname() {
		return authorFirstname;
	}

	public String getAuthorLastname() {
		return authorLastname;
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
		return getAuthorLastname() + ", " + getAuthorFirstname() + ". " + getTitle() + "." + getPublisher() + ", " + getPublicationYear() + ".";
	}





}
