package assignment05;

public class Book {

	 private String authorFirstName;
	 private String authorLastName;
	 private int numPages;
	 private String publisher;
	 private int publicationYear;
	 private String title;
	 
	 public Book(String afn, String aln, int np, String p, int py, String t) {
		 authorFirstName = afn;
		 authorLastName = aln;
		 numPages = np;
		 publisher = p;
		 publicationYear = py;
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
		StringBuilder sb = new StringBuilder(authorLastName);
		sb.append(", ");
		sb.append(authorFirstName);
		sb.append(". ");
		sb.append(title);
		sb.append(". ");
		sb.append(publisher);
		sb.append(", ");
		sb.append(publicationYear);
		return sb.toString();
	}
}
