package assignment05;

public class Book {
  private String authorFirstName;
  private String authorLastName;
  private int numPages;
  private String publisher;
  private int publicationYear;
  private String title;

  public Book(String authorFN, String authorLN, int pages, String publishCompany, int yearPublished, String bookTitle) {
    authorFirstName = authorFN;
    authorLastName = authorLN;
    numPages = pages;
    publisher = publishCompany;
    publicationYear = yearPublished;
    title = bookTitle;
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
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getAuthorLastName());
    sb.append(", ");
    sb.append(getAuthorFirstName());
    sb.append(". ");
    sb.append(getTitle());
    sb.append(". ");
    sb.append(getPublisher());
    sb.append(", ");
    sb.append(getPublicationYear());
    sb.append(".");
    return sb.toString();
  }
}
