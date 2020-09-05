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
public class Book {
	private String authorFirstName;
	private String authorLastName;
	private int numPages;
	private String publisher;
	private int publicationYear;
	private String title;
	public Book(String afn, String aln, int nP, String pb, int pY, String t) {
		authorFirstName = afn;
		authorLastName = aln;
		numPages = nP;
		publisher = pb;
		publicationYear = pY;
		title = t;
	}
	@Override
	public String toString(){
		return authorLastName + ", " + authorFirstName + ", " + title + ", " + publisher + ", " + publicationYear;
	}
}
class TextBook extends Book {
	private String courseName;
	private ArrayList<Integer> assignedChapters = new ArrayList<Integer>();
	public TextBook(String authorFirstName,String authorLastName,int numPages,String publisher,int publicationYear,String title, String cn) {
		super(authorFirstName, authorLastName, numPages, publisher, publicationYear, title);
		courseName = cn;
	}
	public String getCourseName(){
		return courseName;
	}
	public ArrayList<Integer> getAssignedChapters(){
		return assignedChapters;
	}
	public void addChapter(int chap){
		assignedChapters.add(chap);
	}
	@Override
	public String toString(){
		return super.toString() + "\n" + assignedChapters;
	}
}
class LeisureBook extends Book{
	private Genre genre;
	private List<Person> recommended = new ArrayList<>();
	public Genre getGenre(){
		return genre;
	}
	public List<Person> getRecommended(){
		return recommended;
	}
	public LeisureBook(String authorFirstName,String authorLastName,int numPages,String publisher,int publicationYear,String title, Genre g) {
		super(authorFirstName, authorLastName, numPages, publisher, publicationYear, title);
		genre = g;
	}
	public void addRecommendation(Person p){
		recommended.add(p);
	}
}