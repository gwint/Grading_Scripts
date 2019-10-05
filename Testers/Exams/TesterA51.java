package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TesterA51 {
	private static PrintStream out = System.out;
	private static int numWrong;
	private static int testNum = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		out = new PrintStream(new FileOutputStream(new File("exam01-a51/report.txt"), true));
		testQ1();
		out.println("--------------------");
		testQ2();
		out.println("--------------------");
		out.println(numWrong + " tests 1-36 failed");
		out.println("lost " + (numWrong/6.0) + " points");
		double grade = 10.0 - numWrong/6.0;
		numWrong = 0;
		testQ3();
		out.println("--------------------");
		out.println(numWrong + " tests 37-42 failed");
		out.println("lost " + (numWrong*2.0/3) + " points");
		grade = grade - numWrong*2.0/3;
		out.println("Grade = " + grade);
	}
	public static void testQ1() {
		out.println("*********TESTING QUESTION 1********\n");
		try{
			++testNum;
			String[] test = null;
			Problem.maxLen(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			String[] test = {};
			Problem.maxLen(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		String actual = null;
		try {
			++testNum;		
			actual = Problem.maxLen(new String[] {"AB","C","C","AB","A","AD","DF","FG"});
			if(Set.of("AB", "AD", "DF", "FG").contains(actual)) {
				out.printf("TEST " + testNum + " Passed: '%s' is one of AB, AD, DF, FG\n", actual.toString());
			} else {
				++numWrong;
				out.printf("TEST " + testNum + " FAILED: Expected one of AB, AD, DF, FG, received '%s'\n",
						actual.toString());
			}
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(new String[] {\"AB\",\"C\",\"C\",\"AB\",\"A\",\"AD\",\"DF\",\"FG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Problem.maxLen(new String[] {"AB","C","C","ABC","A","AD","DF","FG"}); 
			testEquality("ABC", actual, "TEST " + testNum);
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(new String[] {\"AB\",\"C\",\"C\",\"ABC\",\"A\",\"AD\",\"DF\",\"FG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;		
			String[] test = null;
			Problem.minLen(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			String[] test = {};
			Problem.minLen(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			actual = Problem.minLen(new String[] {"AB","C","C","AB","A","AD","DF","FG"});
			if(Set.of("A", "C").contains(actual)) {
				out.printf("TEST " + testNum + " Passed: '%s' is A or C\n", actual.toString());
			} else {
				++numWrong;
				out.printf("TEST " + testNum + " FAILED: Expected A or C, received '%s'\n",
						actual.toString());
			}
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(new String[] {\"AB\",\"C\",\"C\",\"AB\",\"A\",\"AD\",\"DF\",\"FG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Problem.minLen(new String[] {"AB","CD","C","ABC","A","AD","DF","FG"}); 
			testEquality("C", actual, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(new String[] {\"AB\",\"CD\",\"C\",\"ABC\",\"A\",\"AD\",\"DF\",\"FG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Problem.minLen(new String[] {"AB","CD","","C","ABC","A","AD","","DF","FG"}); 
			testEquality("", actual, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(new String[] {\"AB\",\"CD\",\"\",\"C\",\"ABC\",\"A\",\"AD\",\"\",\"DF\",\"FG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			String[] test = null;
			Problem.countMinMax(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			String[] test = {};
			Problem.countMinMax(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		int actual1 = 0;
		try {
			++testNum;		
			actual1 = Problem.countMinMax(new String[] {"AB","C","C","AB","A","AD","DF","FG"});
			testEquality("8", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new String[] {\"AB\",\"C\",\"C\",\"AB\",\"A\",\"AD\",\"DF\",\"FG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Problem.countMinMax(new String[] {"AB","C","C","AB","A","ABCD","DBF","FGDG"});
			testEquality("5", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new String[] {\"AB\",\"C\",\"C\",\"AB\",\"A\",\"ABCD\",\"DBF\",\"FGDG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Problem.countMinMax(new String[] {"AB","","C","AB","","ABCD","DBF","FGDG"});
			testEquality("4", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new String[] {\"AB\",\"\",\"C\",\"AB\",\"\",\"ABCD\",\"DBF\",\"FGDG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		String[] actual2 = null;
		try {
			++testNum;
			actual2 = Problem.core((String[])null);
			testEquality("[]", Arrays.toString(actual2), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core((String[])null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;			
			actual2 = Problem.core(new String[] {});
			testEquality("[]", Arrays.toString(actual2), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(new String[] {})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual2 = Problem.core(new String[] {"AB","C","C","AB","ABC","ABCD","DEF","FG"});
			testEquality("[AB, AB, ABC, DEF, FG]",	Arrays.toString(actual2), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(new String[] {\"AB\",\"C\",\"C\",\"AB\",\"ABC\",\"ABCD\",\"DEF\",\"FG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		out.println("NOTE TEST " + testNum + " may fail because the arrays are in different orders");
		try {
			++testNum;
			actual2 = Problem.core(new String[] {"AB","C","C","AB","A","AD","DF","FG"});
			testEquality("[]", Arrays.toString(actual2), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(new String[] {\"AB\",\"C\",\"C\",\"AB\",\"A\",\"AD\",\"DF\",\"FG\"})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
	}
	public static void testQ2() {
		out.println("*********TESTING QUESTION 2********\n");
		try {
			++testNum;		
			List<String> test = null;
			Problem.maxLen(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			List<String> test = List.of();
			Problem.maxLen(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		String actual = null;
		try {
			++testNum;		
			actual = Problem.maxLen(List.of("AB","C","C","AB","A","AD","DF","FG"));
			if(Set.of("AB", "AD", "DF", "FG").contains(actual)) {
				out.printf("TEST " + testNum + " Passed: '%s' is one of AB, AD, DF, FG\n",
						actual.toString());
			} else {
				++numWrong;
				out.printf("TEST " + testNum + " FAILED: Expected one of AB, AD, DF, FG, received '%s'\n",
						actual.toString());
			}
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(List.of(\"AB\",\"C\",\"C\",\"AB\",\"A\",\"AD\",\"DF\",\"FG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Problem.maxLen(List.of("AB","C","C","ABC","A","AD","DF","FG")); 
			testEquality("ABC", actual, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: maxLen(List.of(\"AB\",\"C\",\"C\",\"ABC\",\"A\",\"AD\",\"DF\",\"FG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			List<String> test = null;
			Problem.minLen(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			List<String> test = List.of();
			Problem.minLen(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			actual = Problem.minLen(List.of("AB","C","C","AB","A","AD","DF","FG"));
			if(Set.of("A", "C").contains(actual)) {
				out.printf("TEST " + testNum + " Passed: '%s' is A or C\n",
						actual.toString());
			} else {
				++numWrong;
				out.printf("TEST " + testNum + " FAILED: Expected A or C, received '%s'\n",
						actual.toString());
			}
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(List.of(\"AB\",\"C\",\"C\",\"AB\",\"A\",\"AD\",\"DF\",\"FG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Problem.minLen(List.of("AB","CD","C","ABC","A","AD","DF","FG")); 
			testEquality("C", actual, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(List.of(\"AB\",\"CD\",\"C\",\"ABC\",\"A\",\"AD\",\"DF\",\"FG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Problem.minLen(List.of("AB","CD","","C","ABC","A","AD","","DF","FG"));
			testEquality("", actual, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: minLen(List.of(\"AB\",\"CD\",\"\",\"C\",\"ABC\",\"A\",\"AD\",\"\",\"DF\",\"FG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {			
			++testNum;		
			List<String> test = null;
			Problem.countMinMax(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			List<String> test = List.of();
			Problem.countMinMax(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		int actual1 = 0;
		try {
			++testNum;
			actual1 = Problem.countMinMax(List.of("AB","C","C","AB","A","AD","DF","FG"));
			testEquality("8", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(\"AB\",\"C\",\"C\",\"AB\",\"A\",\"AD\",\"DF\",\"FG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Problem.countMinMax(List.of("AB","C","C","AB","A","ABCD","DBF","FGDG"));
			testEquality("5", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(\"AB\",\"C\",\"C\",\"AB\",\"A\",\"ABCD\",\"DBF\",\"FGDG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Problem.countMinMax(List.of("AB","","C","AB","","ABCD","DBF","FGDG"));
			testEquality("4", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(\"AB\",\"\",\"C\",\"AB\",\"\",\"ABCD\",\"DBF\",\"FGDG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		List<String> actual2 = null;
		try {
			++testNum;
			actual2 = Problem.core((List<String>)null);
			testEquality("[]", actual2, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core((List<String>)null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual2 = Problem.core(List.of());
			testEquality("[]", actual2, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			testEquality("[AB, AB, ABC, DEF, FG]", 
					Problem.core(List.of("AB","C","C","AB","ABC","ABCD","DEF","FG")), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(List.of(\"AB\",\"C\",\"C\",\"AB\",\"ABC\",\"ABCD\",\"DEF\",\"FG\")))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}			
		out.println("NOTE TEST " + testNum + " may fail because the lists are in different orders");
		try {
			++testNum;
			actual2 = Problem.core(List.of("AB","C","C","AB","A","AD","DF","FG"));
			testEquality("[]", actual2, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(List.of(\"AB\",\"C\",\"C\",\"AB\",\"A\",\"AD\",\"DF\",\"FG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}			
	}
	public static void testQ3() {
		out.println("*********TESTING QUESTION 3********\n");
		int constructorTest = 0;
		try {
			++testNum;
			constructorTest = testNum;
			testEquality("8g 7p 8floz",
					new USVolumes(8,7,8).toString(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new USVolumes(8,7,8)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			testEquality("1146", "" + new USVolumes(8,7,10).convert(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new USVolumes(8,7,10).convert()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}

		try {
			++testNum;
			testEquality("8g 7p 10floz", USVolumes.convert(1146).toString(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: USVolumes.convert(1146)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		USVolumes test = null;
		try {
			++testNum;
			test = new USVolumes(10,6,3).add(new USVolumes(8,7,8));

			if("0g 0p 0floz".equals(test.toString())) {
				numWrong++;
				out.println("TEST " + testNum + " FAILED--Got 0g 0p 0floz");
			} else testEquality(new USVolumes(19,5,11), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: USVolumes(10,6,3).add()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			test = new USVolumes(10,6,3).subtract(new USVolumes(8,7,8));
			if("0g 0p 0floz".equals(test.toString())) {
				out.println("TEST " + testNum + " FAILED--Got 0g 0p 0floz");
				numWrong++;
			} else testEquality(new USVolumes(1,6,11), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: USVolumes(10,6,3).subtract()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			test = new USVolumes(8,7,8).subtract(new USVolumes(10,6,1));

			if("0g 0p 0floz".equals(new USVolumes(8,7,8).toString())) {
				out.println("TEST " + testNum + " FAILED--see test " + constructorTest);
				numWrong++;
			} else testEquality(new USVolumes(0,0,0), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: USVolumes(8,7,8).subtract()--neg return");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
	}
	private static void testEquality(Object expected, Object actual, String testNum) {
		if (!expected.toString().equals(actual.toString())) {
			++numWrong;
			out.printf(testNum + " FAILED: Expected '%s', received '%s'\n",
					expected.toString(),
					actual.toString());
		} else {
			out.printf(testNum + " Passed: '%s' == '%s'\n",
					expected.toString(),
					actual.toString());
		}
	}
}

