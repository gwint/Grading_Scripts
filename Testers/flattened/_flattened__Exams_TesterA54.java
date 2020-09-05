package exam01;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesterA54 {
	private static PrintStream out = System.out;
	private static int numWrong;
	private static int testNum = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		out = new PrintStream(new FileOutputStream(new File("exam01makeupA54/report.txt"), true));
		numWrong = 0;
		String actual = "BAD RESULT";
		try {
			++testNum;	
			actual = Question.firstVowelToFront(null); 
			testEquality("null", "" + actual, "TEST " + testNum + " firstVowelToFront(null)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelToFront(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Question.firstVowelToFront(""); 
			testEquality("", "" + actual, "TEST " + testNum + " firstVowelToFront(\"\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelToFront(\"\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Question.firstVowelToFront("sdfasdf"); 
			testEquality("asdfsdf", "" + actual, "TEST " + testNum + " firstVowelToFront(\"sdfasdf\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelToFront(\"sdfasdf\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Question.firstVowelToFront("a"); 
			testEquality("a", "" + actual, "TEST " + testNum + " firstVowelToFront(\"a\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelToFront(\"a\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Question.firstVowelToFront("123"); 
			testEquality("123", "" + actual, "TEST " + testNum + " firstVowelToFront(\"123\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelToFront(\"123\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Question.firstVowelToFront("rhythm"); 
			testEquality("rhythm", "" + actual, "TEST " + testNum + " firstVowelToFront(\"rhythm\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelToFront(\"rhythm\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Question.firstVowelToFront("Schtschurowskia"); 
			testEquality("urowskiaSchtsch", "" + actual, "TEST " + testNum + " firstVowelToFront(\"Schtschurowskia\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelToFront(\"Schtschurowskia\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<Integer> actual1 = List.of(-1000);
		try {
			++testNum;	
			actual1 = Question.firstVowelIndex(null); 
			testEquality("null", "" + actual1, "TEST " + testNum + " firstVowelIndex(null)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelIndex(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual1 = Question.firstVowelIndex(new ArrayList<>()); 
			testEquality("[]", "" + actual1, "TEST " + testNum + " firstVowelIndex(empty)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelIndex(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<String> test = null;
		try {
			++testNum;
			test = new ArrayList<>(Arrays.asList("Helper", "Elephant", "Rhythm", "ant", "Psychology", "Schtschurowskia"));
			actual1 = Question.firstVowelIndex(test); 
			testEquality("[1, 0, -1, 0, 5, 7]", "" + actual1, "TEST " + testNum + ": firstVowelIndex(" + test + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelIndex(" + test + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		try {
			++testNum;
			test = new ArrayList<>(Arrays.asList("Helper", "Elephant", "Rhythm", "ant", null, "Psychology", "Schtschurowskia"));
			actual1 = Question.firstVowelIndex(test); 
			testEquality("[1, 0, -1, 0, -1, 5, 7]", "" + actual1, "TEST " + testNum + ": firstVowelIndex(" + test + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstVowelIndex(" + test + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		List<Rectangle> test1 = null;
		try{
			++testNum;
			test1 = null;
			Question.largestAndSmallest(test1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad list", e.getMessage(), "TEST " + testNum + " largestAndSmallest(null)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			test1 = new ArrayList<>();
			Question.largestAndSmallest(test1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3) + "...", "TEST " + testNum + " largestAndSmallest(empty)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			test1 = new ArrayList<>(Arrays.asList(
					new Rectangle(0,0,1,10), new Rectangle(0,0,1,19), null,  
					new Rectangle(0,0,1,18),new Rectangle(0,0,1,17),new Rectangle(0,0,1,11),new Rectangle(0,0,1,15),
					new Rectangle(0,0,1,20),new Rectangle(0,0,1,16),new Rectangle(0,0,1,14),new Rectangle(0,0,1,20)));
			Question.largestAndSmallest(test1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(" + test1 + ") gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3) + "...", "TEST " + testNum + " largestAndSmallest(" + test1 + ")\n");	
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(" + test1 + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		Rectangle[] actual2;
		try {
			++testNum;	
			test1 = new ArrayList<>(Arrays.asList(
					new Rectangle(0,0,1,10), new Rectangle(0,0,1,19), new Rectangle(0,0,1,20),  
					new Rectangle(0,0,1,18),new Rectangle(0,0,1,17),new Rectangle(0,0,1,11),new Rectangle(0,0,1,15),
					new Rectangle(0,0,1,20),new Rectangle(0,0,1,16),new Rectangle(0,0,1,14),new Rectangle(0,0,1,20)));
			actual2 = Question.largestAndSmallest(test1); 
			String expected = "" + new ArrayList<>(Arrays.asList(
					new Rectangle(0,0,1,10), new Rectangle(0,0,1,20), 
					new Rectangle(0,0,1,20), new Rectangle(0,0,1,20)));
			testEquality(expected, Arrays.toString(actual2), "TEST " + testNum + " largestAndSmallest(" + test1 + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(" + test1 + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			test1 = new ArrayList<>(Arrays.asList(
					new Rectangle(0,0,1,19), new Rectangle(0,0,1,10), new Rectangle(0,0,1,18),  
					new Rectangle(0,0,1,20),new Rectangle(0,0,1,17),new Rectangle(0,0,1,11),new Rectangle(0,0,1,15),
					new Rectangle(0,0,1,20),new Rectangle(0,0,1,16),new Rectangle(0,0,1,20),new Rectangle(0,0,1,14)));
			actual2 = Question.largestAndSmallest(test1); 
			String expected = "" + new ArrayList<>(Arrays.asList(
					new Rectangle(0,0,1,10), new Rectangle(0,0,1,20), 
					new Rectangle(0,0,1,20), new Rectangle(0,0,1,20)));
			testEquality(expected, Arrays.toString(actual2), "TEST " + testNum + " largestAndSmallest(" + test1 + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(" + test1 + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		try{
			++testNum;
			new Money(1,1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(1,1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad input", e.getMessage(), "TEST " + testNum + " new Money(1,1)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(1,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			new Money(1,1,1,1,1,1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(1,1,1,1,1,1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Money(1,1,1,1,1,1)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(1,1,1,1,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		Money actual4 = null;
		try {
			++testNum;	
			actual4 = new Money(15,7,11,20,7); 
			String expected = "$15 7q 11d 20n 7p";
			if(!testEquality(expected, "" + actual4, "TEST " + testNum + " new Money(15,7,11,20,7)\n")) {
				out.println("Constructor ");
				out.println("$18 3q 1d 1n 2p is also OK--it is the normalized value");
				out.println("If neither value, then please check the student's constructor");
				out.println("Here is my constructor, replace with with this one");
				out.println("	public Money(int... amounts) {\n" + 
						"		if(amounts.length != 5) throw new IllegalArgumentException(\"bad input\");\n" + 
						"		for(int i = 0; i < 5; i++) money[i] = amounts[i];\n" + 
						"	}\n"); 
				
			}
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(15,7,11,20,7)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(-1); 
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(-1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Money(-1)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(20,30,70,80)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(1667); 
			String expected = "$16 2q 1d 1n 2p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Money(1667)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(1667)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(20,10,12,13,14);
			int value = actual4.valueInCents();
			String expected = "2449";
			testEquality(expected, "" + value, "TEST " + testNum + " valueInCents()\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: valueInCents");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(13,23,11,19,18);
			actual4 = actual4.multiply(-7);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(13,23,11,19,18).multiply(-7) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Money(13,23,11,19,18).multiply(-7)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(13,23,11,19,18).multiply(-7)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(13,23,11,19,18);
			actual4 = actual4.multiply(0);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(13,23,11,19,18).multiply(0) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Money(13,23,11,19,18).multiply(0)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(13,23,11,19,18).multiply(0)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(13,23,11,19,18);
			actual4 = actual4.multiply(7);
			String expected = "$146 3q 1d 0n 1p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Money(13,23,11,55).multiply(7))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: multiply");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(13,23,11,19,18);
			actual4 = actual4.divide(-7);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(13,23,11,19,18).divide(-7) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Money(13,23,11,19,18).divide(-7)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(13,23,11,19,18).divide(-7)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(13,23,11,19,18);
			actual4 = actual4.divide(0);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(13,23,11,19,18).divide(0) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Money(13,23,11,19,18).divide(0)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Money(13,23,11,19,18).divide(0)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(13,23,11,19,18);
			actual4 = actual4.divide(7);
			String expected = "$2 3q 2d 0n 4p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Money(13,23,11,55).divide(7))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: divide");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(13,2,11,5,7);
			actual4.add(new Money(1,23,9,19,6));
			String expected = "$14 25q 20d 24n 13p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Money(13,2,11,5,7).add(new Money(1,23,9,19,6))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: add");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Money(15,7,11,20,7);
			actual4.normalize();
			String expected = "$18 3q 1d 1n 2p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Money(15,7,11,20,7).normalize()\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: normalize");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		out.println("--------------------");
		out.println(numWrong + " tests failed of " + testNum);
		out.println("lost " + (numWrong*10.0/testNum) + " points");
		double grade = 10.0 - numWrong*10.0/testNum;
		out.println("Grade = " + grade);		
	}

	private static boolean testEquality(Object expected, Object actual, String testNum) {
		if (!expected.toString().equalsIgnoreCase(actual.toString())) {
			++numWrong;
			out.printf(testNum + " FAILED: Expected '%s', received '%s'\n",
					expected.toString(),
					actual.toString());
			return false;
		} else {
			out.printf(testNum + " Passed: '%s' equalsIgnoreCase '%s'\n",
					expected.toString(),
					actual.toString());
			return true;
		}
	}
}