package assignment05;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
public class StudentTester{
  @test
  void tester(){
    Person A = new Person("Jack", "Spades", "123321545");
    Student B = new Student(A);
    TextBook C = new TextBook("Cindy", "Salads", 56, "Random House", 2006, "The History of Memes", "Anthropology");
    TextBook D = new TextBook("Ferra", "Khan", 420, "Penguin Publishing", 1997, "Yakub's Manual on Genetic Engineering", "Genetics");
    C.addChapter(1);
    C.addChapter(2);
    D.addChapter(7);
    D.addChapter(9);
    System.out.println(C.getAssignedChapters());
    System.out.println(D.getAssignedChapters());
    System.out.println(B);
  }





  if (pagesRead.containsKey(book)) {
			return (pagesRead.get(book) / book.getNumPages()) * 100.0;
		} else {
			return 0;
		}
}
