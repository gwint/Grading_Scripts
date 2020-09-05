package assignment05;

public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	
	public Book() {}
	
	public Book(String authorFirstName1, String authorLastName1, int numPages1, String publisher1, int publisherYear1, String title1 ) {
		
		this.authorFirstName = authorFirstName1;
		this.authorLastName = authorLastName1;
		this.numPages = numPages1;
		this.publisher = publisher1;
		this.publicationYear = publisherYear1;
		this.title = title1;
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
