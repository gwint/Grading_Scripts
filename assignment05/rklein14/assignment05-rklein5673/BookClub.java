package assignment05;

import java.util.Set;
import java.util.HashSet;

public class BookClub {
  private Set<BookClubMember> members = new HashSet<BookClubMember>();
  private Set<LeisureBook> readings = new HashSet<LeisureBook>();

  public void addMember(BookClubMember bcm) {
    members.add(bcm);
    for (LeisureBook book : readings) {
      bcm.addReading(book);
    }
  }
  public void addNewReading(LeisureBook book) {
    readings.add(book);
    for (BookClubMember bcm : members) {
       bcm.addReading(book);
    }
  }
  public double getAveragePercentRead(Book book) {
    double total = 0.0;
    for (BookClubMember bcm : members) {
      total += bcm.getPercentRead(book);
    }
    if (members.size() == 0) {
      return 0;
    }
    return total / members.size();
  }
  public double getCompletionPercentage() {
    double total = 0.0;
    for (LeisureBook lb : readings) {
      total += getAveragePercentRead(lb);
    }
    if (readings.size() == 0) {
      return 0;
    }
    return total / (double) readings.size();
  }
}
