package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesterA53 {
	private static PrintStream out = System.out;
	private static int numWrong;
	private static int testNum = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		out = new PrintStream(new FileOutputStream(new File("exam01makeupA53/report.txt"), true));
		numWrong = 0;
		
		try{
			++testNum;
			new Part1(1,1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(1,1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad input", e.getMessage(), "TEST " + testNum + " new Part1(1,1)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(1,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			new Part1(1,1,1,1,1,1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(1,1,1,1,1,1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Part1(1,1,1,1,1,1)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(1,1,1,1,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		Part1 actual4 = null;
		try {
			++testNum;	
			actual4 = new Part1(15,7,11,20,7); 
			String expected = "$15 7q 11d 20n 7p";
			if(!testEquality(expected, "" + actual4, "TEST " + testNum + " new Part1(15,7,11,20,7)\n")) {
				out.println("Constructor problem");
				out.println("$18 3q 1d 1n 2p is also OK--it is the normalized value");
				out.println("If neither value, then please check the student's constructor");
				out.println("Here is my constructor, replace with with this one");
				out.println("	public Part1(int... amounts) {\n" + 
						"		if(amounts.length != 5) throw new IllegalArgumentException(\"bad input\");\n" + 
						"		for(int i = 0; i < 5; i++) money[i] = amounts[i];\n" + 
						"	}\n"); 
				
			}
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(15,7,11,20,7)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(-1); 
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(-1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Part1(-1)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(20,30,70,80)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(1667); 
			String expected = "$16 2q 1d 1n 2p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Part1(1667)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(1667)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(20,10,12,13,14);
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
			actual4 = new Part1(13,23,11,19,18);
			actual4 = actual4.multiply(-7);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(13,23,11,19,18).multiply(-7) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Part1(13,23,11,19,18).multiply(-7)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(13,23,11,19,18).multiply(-7)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(13,23,11,19,18);
			actual4 = actual4.multiply(0);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(13,23,11,19,18).multiply(0) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Part1(13,23,11,19,18).multiply(0)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(13,23,11,19,18).multiply(0)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(13,23,11,19,18);
			actual4 = actual4.multiply(7);
			String expected = "$146 3q 1d 0n 1p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Part1(13,23,11,55).multiply(7))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: multiply");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(13,23,11,19,18);
			actual4 = actual4.divide(-7);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(13,23,11,19,18).divide(-7) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Part1(13,23,11,19,18).divide(-7)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(13,23,11,19,18).divide(-7)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(13,23,11,19,18);
			actual4 = actual4.divide(0);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(13,23,11,19,18).divide(0) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Part1(13,23,11,19,18).divide(0)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Part1(13,23,11,19,18).divide(0)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(13,23,11,19,18);
			actual4 = actual4.divide(7);
			String expected = "$2 3q 2d 0n 4p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Part1(13,23,11,55).divide(7))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: divide");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(13,2,11,5,7);
			actual4.add(new Part1(1,23,9,19,6));
			String expected = "$14 25q 20d 24n 13p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Part1(13,2,11,5,7).add(new Part1(1,23,9,19,6))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: add");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Part1(15,7,11,20,7);
			actual4.normalize();
			String expected = "$18 3q 1d 1n 2p";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Part1(15,7,11,20,7).normalize()\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: normalize");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		String actual = "BAD RESULT";
		try {
			++testNum;	
			actual = Part2.cropToFirstVowel(null); 
			testEquality("null", "" + actual, "TEST " + testNum + " cropToFirstVowel(null)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: cropToFirstVowel(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Part2.cropToFirstVowel(""); 
			testEquality("", "" + actual, "TEST " + testNum + " cropToFirstVowel(\"\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: cropToFirstVowel(\"\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Part2.cropToFirstVowel("sdfasdf"); 
			testEquality("asdf", "" + actual, "TEST " + testNum + " cropToFirstVowel(\"sdfasdf\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: cropToFirstVowel(\"sdfasdf\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Part2.cropToFirstVowel("a"); 
			testEquality("a", "" + actual, "TEST " + testNum + " cropToFirstVowel(\"a\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: cropToFirstVowel(\"a\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Part2.cropToFirstVowel("123"); 
			testEquality("123", "" + actual, "TEST " + testNum + " cropToFirstVowel(\"123\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: cropToFirstVowel(\"123\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Part2.cropToFirstVowel("rhythm"); 
			testEquality("ythm", "" + actual, "TEST " + testNum + " cropToFirstVowel(\"rhythm\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: cropToFirstVowel(\"rhythm\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Part2.cropToFirstVowel("Yellow"); 
			testEquality("Yellow", "" + actual, "TEST " + testNum + " cropToFirstVowel(\"Yellow\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: cropToFirstVowel(\"Yellow\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<Integer> actual1 = List.of(-1000);
		try {
			++testNum;	
			actual1 = Part2.lastVowelOrY(null); 
			testEquality("null", "" + actual1, "TEST " + testNum + " lastVowelOrY(null)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: lastVowelOrY(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual1 = Part2.lastVowelOrY(new ArrayList<>()); 
			testEquality("[]", "" + actual1, "TEST " + testNum + " lastVowelOrY(empty)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: lastVowelOrY(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<String> test = null;
		try {
			++testNum;
			test = new ArrayList<>(Arrays.asList("Helper", "Elephant", "Rhythm", "ant", "Psychology", "Schtschurowskia"));
			actual1 = Part2.lastVowelOrY(test); 
			testEquality("[4, 5, 2, 0, 9, 14]", "" + actual1, "TEST " + testNum + ": lastVowelOrY(" + test + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: lastVowelOrY(" + test + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		try {
			++testNum;
			test = new ArrayList<>(Arrays.asList("Helper", "Elephant", "Rhythm", "ant", null, "Psychology", "Schtschurowskia"));
			actual1 = Part2.lastVowelOrY(test); 
			testEquality("[4, 5, 2, 0, -1, 9, 14]", "" + actual1, "TEST " + testNum + ": lastVowelOrY(" + test + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: lastVowelOrY(" + test + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		List<Part1> test1 = null;
		try{
			++testNum;
			test1 = null;
			Part2.notLargestOrSmallest(test1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad list", e.getMessage(), "TEST " + testNum + " notLargestOrSmallest(null)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			test1 = new ArrayList<>();
			Part2.notLargestOrSmallest(test1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3) + "...", "TEST " + testNum + " notLargestOrSmallest(empty)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			test1 = new ArrayList<>(Arrays.asList(
					new Part1(20,10,12,13,14), new Part1(21,10,12,13,14), null,  
					new Part1(19,10,12,13,14),new Part1(22,10,12,13,14),new Part1(20,12,12,13,14),new Part1(21,9,12,13,14),
					new Part1(21,10,12,13,14),new Part1(19,10,12,13,14),new Part1(20,8,12,13,14),new Part1(21,6,12,13,14)));
			Part2.notLargestOrSmallest(test1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(" + test1 + ") gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3) + "...", "TEST " + testNum + " notLargestOrSmallest(" + test1 + ")\n");	
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(" + test1 + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		Part1[] actual2;
		try {
			++testNum;	
			test1 = new ArrayList<>(Arrays.asList(
					new Part1(20,10,12,13,14), new Part1(22,10,12,13,14),   
					new Part1(19,10,12,13,14),new Part1(22,10,12,13,14),new Part1(20,12,12,13,14),new Part1(21,9,12,13,14),
					new Part1(21,10,12,13,14),new Part1(22,10,12,13,14),new Part1(19,10,12,13,14),new Part1(21,6,12,13,14)));
			actual2 = Part2.notLargestOrSmallest(test1); 
			String expected = "[$20 10q 12d 13n 14p, $20 12q 12d 13n 14p, $21 9q 12d 13n 14p, "
					+ "$21 10q 12d 13n 14p, $21 6q 12d 13n 14p]";
			testEquality(expected, Arrays.toString(actual2), "TEST " + testNum + " notLargestOrSmallest(" + test1 + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(" + test1 + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			test1 = new ArrayList<>(Arrays.asList(
					new Part1(18,10,12,13,14), new Part1(21,10,12,13,14),   
					new Part1(19,10,12,13,14),new Part1(22,10,12,13,14),new Part1(20,12,12,13,14),new Part1(21,9,12,13,14),
					new Part1(21,10,12,13,14),new Part1(19,10,12,13,14),new Part1(20,8,12,13,14),new Part1(23,6,12,13,14)));
			actual2 = Part2.notLargestOrSmallest(test1); 
			String expected = "[$21 10q 12d 13n 14p, $19 10q 12d 13n 14p, $20 12q 12d 13n 14p, $21 9q 12d 13n 14p, "
					+ "$21 10q 12d 13n 14p, $19 10q 12d 13n 14p, $20 8q 12d 13n 14p]";
			testEquality(expected, Arrays.toString(actual2), "TEST " + testNum + " notLargestOrSmallest(" + test1 + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(" + test1 + ")");
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