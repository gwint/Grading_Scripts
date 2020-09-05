package assignment05;

public class BookClubTester {
  public static void main(String[] args) {
    LeisureBook harryPotter = new LeisureBook("J.K.", "Rowling", 555, "Penguin Books",
      2000, "Harry Potter and the 7 Dwarves", Genre.SCIENCE_FICTION);
    LeisureBook nancyDrew = new LeisureBook("Dr.", "Suess", 34, "Independent",
      1933, "Not a Real Book", Genre.MYSTERY);
    BookClubMember ryan = new BookClubMember(new Person("Ryan", "Klein", "11-123-2222"));
    BookClubMember garriot = new BookClubMember(new Person("Garriot", "Hickory", "11-123-2223"));
    BookClub secretSocietyOfMonkeyEngineers = new BookClub();
    secretSocietyOfMonkeyEngineers.addMember(ryan);
    secretSocietyOfMonkeyEngineers.addMember(garriot);
    secretSocietyOfMonkeyEngineers.addNewReading(harryPotter);
    secretSocietyOfMonkeyEngineers.addNewReading(nancyDrew);
    ryan.setPageCount(harryPotter, 300);
    ryan.setPageCount(nancyDrew, 0);
    garriot.setPageCount(harryPotter, 555);
    garriot.setPageCount(nancyDrew, 14);

    double ryanPotterPercent = 300.0 / 555.0 * 100.0;
    double garriotPotterPercent = 555.0 / 555.0 * 100.0;
    double ryanDrewPercent = 0.0 / 34.0 * 100;
    double garriotDrewPercent = 14.0 / 34.0 * 100;
    double clubPotterPercent = (ryanPotterPercent + garriotPotterPercent) / 2.0;
    double clubDrewPercent = (ryanDrewPercent + garriotDrewPercent) / 2.0;
    double clubOverallPercent = (clubPotterPercent + clubDrewPercent) / 2.0;

    System.out.println("Ryan's percent read of the Harry Potter book. Expected: " + ryanPotterPercent);
    System.out.println("Actual " + ryan.getPercentRead(harryPotter));
    System.out.println("Ryan's percent read of the Nancy Drew book. Expected: " + ryanDrewPercent);
    System.out.println("Actual " + ryan.getPercentRead(nancyDrew));
    System.out.println("Garriot's percent read of the Harry Potter book. Expected: " + garriotPotterPercent);
    System.out.println("Actual " + garriot.getPercentRead(harryPotter));
    System.out.println("Garriot's percent read of the Nancy Drew book. Expected: "+ garriotDrewPercent);
    System.out.println("Actual " + garriot.getPercentRead(nancyDrew));

    System.out.println("Book Club's percent read of the Harry Potter book. Expected: " + clubPotterPercent);
    System.out.println("Actual " + secretSocietyOfMonkeyEngineers.getAveragePercentRead(harryPotter));
    System.out.println("Book Club's percent read of the Nancy Drew book. Expected: " + clubDrewPercent);
    System.out.println("Actual " + secretSocietyOfMonkeyEngineers.getAveragePercentRead(nancyDrew));

    System.out.println("Book Club's overall percent read. Expected: " + clubOverallPercent);
    System.out.println("Actual " + secretSocietyOfMonkeyEngineers.getCompletionPercentage());
  }
}
