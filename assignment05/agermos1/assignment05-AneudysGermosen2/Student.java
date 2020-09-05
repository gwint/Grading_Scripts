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
public class Student{
	private Person me;
	private Set<TextBook> courseBooks = new HashSet<>();
	public Student(Person p){
		me = p;
	}
	public String getFirstNames(){
		return me.getFirstNames();
	}
	public String getLastNames(){
		return me.getLastNames();
	}
	public String getSSN(){
		return me.getSSN();
	}
	public void addBook(TextBook t){
		courseBooks.add(t);
	}
	public Set<String> getCourseNames(){
		Set<String> newSet = new HashSet<>();
		for(TextBook text: courseBooks) {
			newSet.add(text.getCourseName());
		}
		return newSet;
	}
	@Override
	public String toString(){
		return me.toString() + " taking " + getCourseNames();
	}
}
