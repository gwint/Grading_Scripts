package assignment05;

public class Book {
	protected String authorFirstName;
	protected String authorLastName;
	protected int numPages;
	protected String publisher;
	protected int publicationYear;
	protected String title;
	
	public Book() {}
	
	public Book(String authorFrstName, String authorLstName, int nmPages, String pub, int pubYear, String tle ) {
		this.authorFirstName = authorFrstName;
		this.authorLastName = authorLstName;
		this.numPages = nmPages;
		this.publisher = pub;
		this.publicationYear = pubYear;
		this.title = tle;
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
		StringBuilder sBuilder = new StringBuilder(this.authorFirstName);
		sBuilder.append(", ");
		sBuilder.append(this.authorLastName);
		sBuilder.append(". ");
		sBuilder.append(this.title);
		sBuilder.append(". ");
		sBuilder.append(this.publisher);
		sBuilder.append(". ");
		sBuilder.append(this.publicationYear);
		sBuilder.append(". ");
		return sBuilder.toString();
	}
}
