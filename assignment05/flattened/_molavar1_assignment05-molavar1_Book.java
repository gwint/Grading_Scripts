package assignment05;


public class Book{
  private String authorFirstName;
  private String authorLastName;
  private int numPages;
  private String publisher;
  private int publicationYear;
  private String title;

  public Book(String AFN, String ALN, int pages, String pub, int year, String title){
    this.authorFirstName = AFN;
    this.authorLastName = ALN;
    this.numPages = pages;
    this.publisher = pub;
    this.publicationYear = year;
    this.title = title;

  }
  public String getAuthorFirstName(){
    return authorFirstName;
  }
  public String getAuthorLastName(){
    return authorLastName;
  }
  public int getNumPages(){
    return numPages;
  }
  public String getPublisher(){
    return publisher;
  }
  public int getPublicationYear(){
    return publicationYear;
  }
  public String getTitle(){
    return title;
  }
  public String toString(){
    StringBuilder sb = new StringBuilder(getAuthorLastName());
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
