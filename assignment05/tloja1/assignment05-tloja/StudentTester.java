package assignment05;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class StudentTester{
  Person A = new Person("Jack", "Phinboy", "123456789");
  Student B = new Student(A);
  TextBook C = new TextBook("Devin", "Frederick", 38, "Omegatron", 1934, "The Other Side", "Nonfiction");
  TextBook D = new TextBook("Marc", "Marrone", 40, "Full House", 1923, "All about Ponies", "fiction");
  @BeforeEach
  @Test
  void initialize() {
  C.addChapter(1);
  C.addChapter(2);
  D.addChapter(7);
  D.addChapter(9);
  System.out.println(C.getAssignedChapters());
  System.out.println(D.getAssignedChapters());
  System.out.println(B);
  }
  }