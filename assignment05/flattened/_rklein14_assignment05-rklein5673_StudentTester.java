package assignment05;

import java.util.List;
import java.util.ArrayList;

public class StudentTester {
  public static void main(String[] args) {
    Person me = new Person("Ryan", "Klein", "453-34-2333");
    Student myself = new Student(me);
    TextBook USHistory = new TextBook("Howard", "Zinn", 453, "Yellow Books", 1974,
      "A People's History of the United States", "US History");
    TextBook cellBio = new TextBook("Stephen", "Hawking", 900, "Human Daily", 2018,
      "Cell Processes", "Microbiology");
    USHistory.addChapter(4);
    USHistory.addChapter(5);
    cellBio.addChapter(19);
    cellBio.addChapter(24);
    System.out.println("Expecting [4, 5]");
    System.out.println(USHistory.getAssignedChapters());
    System.out.println("Expecting [19, 24]");
    System.out.println(cellBio.getAssignedChapters());
    myself.addBook(USHistory);
    myself.addBook(cellBio);
    System.out.println("Expecting: Ryan Klein (453-34-2333) taking [Microbiology, US History]");
    System.out.println(myself);
  }
}
