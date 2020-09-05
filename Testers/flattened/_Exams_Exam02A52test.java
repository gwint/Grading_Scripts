package exam02;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam02A52test {
	private static PrintStream out = System.out;
	private static Different diff = new Different("SWING");
	private static List<Different> testList = 
			new ArrayList<> (Arrays.asList(
					new Triples("NANNY"),
					new Doubles("ABACI"),
					new Triples("RARER"),
					new Triples("EERIE"),
					new Different("STAGE"),
					new Doubles("ARRAY"),
					new Different("READS"),
					new Triples("BOBBY"),
					new Doubles("XEROX"),
					new Triples("POPUP"),
					new Different("PRIZE"),
					new Triples("ADDED"),
					new Doubles("MADAM")
					));
	private static List<Different> testListOrdered = 
			new ArrayList<> (Arrays.asList(
					new Triples("ADDED"),
					new Triples("BOBBY"),
					new Triples("EERIE"),
					new Triples("NANNY"),
					new Triples("POPUP"),
					new Triples("RARER"),
					new Doubles("ABACI"),
					new Doubles("ARRAY"),
					new Doubles("MADAM"),
					new Doubles("XEROX"),
					new Different("PRIZE"),
					new Different("READS"),
					new Different("STAGE")
					));
	private static int[] numWrong = new int[3];
	private static int testNum = 0;
	private static int q1Count = 1;
	private static int q2Count = 1;
	private static int q3Count = 1;
	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		String file = "/home/mllab/Desktop/CS140/Grading_Scripts/exam02-a52/report.txt";
		out = new PrintStream(new FileOutputStream(new File(file), true));
		testQ1();
		out.println("--------------------");
		out.println(numWrong[0] + " tests 1-" + testNum + " failed");
		out.println("lost " + (4.0*numWrong[0]/q1Count) + " points");
		double grade = 10.0 - 4.0*numWrong[0]/q1Count;
		testQ2();
		out.println("--------------------");
		out.println(numWrong[1] + " tests " + (q1Count+1)+ "-" + testNum + " failed");
		out.println("lost " + (3.0*(numWrong[1])/q2Count) + " points");
		grade = grade - 3.0*numWrong[1]/q2Count;
		testQ3();
		out.println("--------------------");
		out.println(numWrong[2] + " tests " + (q2Count+q1Count+1)+ "-" + testNum + " failed");
		out.println("lost " + (3.0*(numWrong[2])/q3Count) + " points");
		grade = grade - 3.0*numWrong[2]/q3Count;
		out.println("--------------------");
		out.println("Grade = " + grade);
	}
	public static void testQ1() {
		out.println("*********TESTING Different********\n");
		try{
			++testNum;
			diff.compareFields(null);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: compareFields(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("illegal input", e.getMessage(), "TEST " + testNum, 0);
		} catch(Exception e){
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: compareFields(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		int actual = 0;
		try {
			++testNum;		
			actual = diff.compareFields(new Different("SWING"));
			testEquality("0", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: diff.compareFields(new Different(\"SWING\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = diff.compareFields(new Different("QUICK"));
			testEquality("2", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: diff.compareFields(\"QUICK\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = diff.compareFields(new Different("SWUNG"));
			testEquality("" + ('I'-'U'), ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: diff.compareFields(new Different(\"SWUNG\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = diff.compareFields(new Different("SWILL"));
			testEquality("2", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: diff.compareFields(new Different(\"SWILL\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = diff.compareFields(new Different("SWINE"));
			testEquality("2", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: diff.compareFields(new Different(\"SWINE\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		Level actual1 = null;
		try {
			++testNum;		
			actual1 = diff.level();
			testEquality("" + Level.DIFFERENT, actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: diff.level()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = diff.compareTo(new Different("SWINE"));
			testEquality("2", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: diff.compareTo(new Different(\"SWINE\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		String actual2 = null;
		try {
			++testNum;		
			actual2 = diff.toString();
			testEquality("SWING", actual2, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: diff.toString()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual2 = new Doubles("XEROX").toString();
			testEquality("XEROX", actual2, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Doubles constructor");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual2 = new Triples("NANNY").toString();
			testEquality("NANNY", actual2, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Triples constructor");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = new Doubles(null).level();
			testEquality(""+Level.DOUBLES, actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Doubles.type()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = new Triples(null).level();
			testEquality(""+Level.TRIPLES, actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Triples.type()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			String arg = null;
			Factory.makeObject(arg);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: makeObject(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("invalid input", e.getMessage().toLowerCase(), "TEST " + testNum, 0);
		} catch(Exception e){
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			String arg = "";
			Factory.makeObject(arg);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: makeObject(\"\") gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("invalid input", e.getMessage().toLowerCase(), "TEST " + testNum, 0);
		} catch(Exception e){
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(\"\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			Different d = Factory.makeObject("THING");
			testEquality("" +Level.DIFFERENT+"THING", d.level()+d.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(\"THING\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Different d = Factory.makeObject("SOMETHING");
			testEquality("" +Level.DIFFERENT+"SOMET", d.level()+d.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(\"SOMETHING\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Different d = Factory.makeObject("SOMETIMES");
			testEquality("" +Level.DIFFERENT+"SOMET", d.level()+d.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(\"SOMETIMES\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Different d = Factory.makeObject("ABC");
			testEquality("" +Level.DOUBLES+"ABCAB", d.level()+d.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(\"ABC\"3)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Different d = Factory.makeObject("AB");
			testEquality("" +Level.TRIPLES+"ABABA", d.level()+d.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(\"AB\"3)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(diff, diff);
			testEquality("0", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(diff, diff)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(null, diff);
			testEquality("-1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(null, diff)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(diff, null);
			testEquality("1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(diff, null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Triples("NANNY"), new Different("ABCDE"));
			testEquality("-2", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Triples(\"NANNY\"), new Different(\"ABCDE\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Different("ABCDE"),new Triples("NANNY"));
			testEquality("2", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Different(\"ABCDE\"),new Triples(\"NANNY\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Doubles("RACER"), new Different("ABCDE"));
			testEquality("-1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Doubles(\"RACER\"), new Different(\"ABCDE\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Different("ABCDE"),new Doubles("RACER"));
			testEquality("1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Different(\"ABCDE\"),new Doubles(\"RACER\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(diff, new Different("STING"));
			testEquality("3", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(Different, new Different(\"STING\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Triples("NANNY"), new Doubles("RACER"));
			testEquality("-1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Triples(\"NANNY\"), new Doubles(\"RACER\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Doubles("RACER"),new Triples("NANNY"));
			testEquality("1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Doubles(\"RACER\"),new Triples(\"NANNY\"))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Different("STING"), diff);
			testEquality("-3", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Different(\"STING\"), Different)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Triples("NANNY"), new Triples("EERIE"));
			testEquality("" + ('N'-'E'), "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Triples(new int[] {5,7,5,5,3}), new Triples(new int[] {5,7,6,5,3}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}

		q1Count = testNum;
	}
	public static void testQ2() {
		out.println("*********TESTING QUESTION 2********\n");
		String actual = "";
		try {
			++testNum;		
			actual = ""+Factory.sort(testList.stream());
			testEquality("{TRIPLES=[NANNY, RARER, EERIE, BOBBY, POPUP, ADDED], "
					+ "DIFFERENT=[STAGE, READS, PRIZE], "
					+ "DOUBLES=[ABACI, ARRAY, XEROX, MADAM]}"
					, actual, "TEST " + testNum, 1);
		} catch (Exception e) {
			++numWrong[1];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = ""+Factory.sort(testListOrdered.stream());
			testEquality("{TRIPLES=[ADDED, BOBBY, EERIE, NANNY, POPUP, RARER], "
					+ "DIFFERENT=[PRIZE, READS, STAGE], "
					+ "DOUBLES=[ABACI, ARRAY, MADAM, XEROX]}",
					actual, "TEST " + testNum, 1);
		} catch (Exception e) {
			++numWrong[1];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = ""+Factory.selectDiffs(testList);
			testEquality("[STAGE, READS, PRIZE]", 
					actual, "TEST " + testNum, 1);
		} catch (Exception e) {
			++numWrong[1];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = ""+Factory.selectDiffs(testListOrdered);
			testEquality("[PRIZE, READS, STAGE]",
					actual, "TEST " + testNum, 1);
		} catch (Exception e) {
			++numWrong[1];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}

		q2Count = testNum - q1Count;

	}

	public static void testQ3() {
		out.println("*********TESTING QUESTION 3********\n");
		String actual = "";
		BinarySearchTree<Different> t = new BinarySearchTree<>();
		for(Different p : testList) t.add(p);
		try {
			++testNum;
			t = t.balance();
			// Create a stream to hold the output
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			// IMPORTANT: Save the old System.out!
			PrintStream old = System.out;
			// Tell Java to use your special stream
			System.setOut(ps);
			// Print some output: goes to your special stream
			t.print();
			// Put things back
			System.out.flush();
			System.setOut(old);
			// Show what happened
			actual = baos.toString();
			testEquality("ADDEDBOBBYEERIENANNY" 
					+ "POPUPRARERABACIARRAYMADAMXEROX" 
					+ "PRIZEREADSSTAGE",
					actual.replaceAll("\\s",""), "TEST " + testNum, 2);
		} catch (Exception e) {
			++numWrong[2];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}

		BinarySearchTree<Different> t1 = new BinarySearchTree<>();
		for(Different p : testListOrdered) t1.add(p);
		try {
			++testNum;
			t = t.balance();
			// Create a stream to hold the output
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);
			// IMPORTANT: Save the old System.out!
			PrintStream old = System.out;
			// Tell Java to use your special stream
			System.setOut(ps);
			// Print some output: goes to your special stream
			t.print();
			// Put things back
			System.out.flush();
			System.setOut(old);
			// Show what happened
			actual = baos.toString();
			testEquality("ADDEDBOBBYEERIENANNY" 
					+ "POPUPRARERABACIARRAYMADAMXEROX" 
					+ "PRIZEREADSSTAGE",
					actual.replaceAll("\\s",""), "TEST " + testNum, 2);
		} catch (Exception e) {
			++numWrong[2];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		q3Count = testNum - q1Count - q2Count;
	}

	private static void testEquality(Object expected, Object actual, String testNum, int count) {
		if (!expected.toString().equals(actual.toString())) {
			numWrong[count]++;
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
