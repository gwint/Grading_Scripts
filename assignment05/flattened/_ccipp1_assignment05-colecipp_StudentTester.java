package assignment05;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class StudentTester{
  Person A = new Person("Jack", "Spades", "123321545");
  Student B = new Student(A);
  TextBook C = new TextBook("Cindy", "Salads", 56, "Random House", 2006, "The History of Memes", "Anthropology");
  TextBook D = new TextBook("Ferra", "Khan", 420, "Penguin Publishing", 1997, "Yakub's Manual on Genetic Engineering", "Genetics");
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
