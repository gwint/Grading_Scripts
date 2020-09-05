package assignment05;

import java.util.List;
import java.util.ArrayList;

public class LeisureBook extends Book {
  private Genre genre;
  private List<Person> recommended = new ArrayList<Person>();

  public LeisureBook(String authorFN, String authorLN, int pages,
    String publishCompany, int yearPublished, String bookTitle, Genre bookGenre) {
    super(authorFN, authorLN, pages, publishCompany, yearPublished, bookTitle);
    genre = bookGenre;
  }
  public Genre getGenre() {
    return genre;
  }
  public List<Person> getRecommened() {
    return recommended;
  }
  public void addRecommendation(Person p) {
    recommended.add(p);
  }
}
