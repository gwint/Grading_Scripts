package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesterA51 {
	private static PrintStream out = System.out;
	private static int numWrong;
	private static int testNum = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		out = new PrintStream(new FileOutputStream(new File("exam01makeupA51/report.txt"), true));
		double grade = 10.0 - numWrong/6.0;
		numWrong = 0;
		String actual = "BAD RESULT";
		try {
			++testNum;	
			actual = Problem.findDigits(null); 
			testEquality("null", "" + actual, "TEST " + testNum + " findDigits(null)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: findDigits(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Problem.findDigits(""); 
			testEquality("", "" + actual, "TEST " + testNum + " findDigits(\"\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: findDigits(\"\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Problem.findDigits("sdfasdf"); 
			testEquality("0", "" + actual, "TEST " + testNum + " findDigits(\"sdfasdf\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: findDigits(\"sdfasdf\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Problem.findDigits("a"); 
			testEquality("0", "" + actual, "TEST " + testNum + " findDigits(\"a\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: findDigits(\"a\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Problem.findDigits("123"); 
			testEquality("123", "" + actual, "TEST " + testNum + " findDigits(\"123\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: findDigits(\"123\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = Problem.findDigits("erqer123"); 
			testEquality("123", "" + actual, "TEST " + testNum + " findDigits(\"erqer123\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: findDigits(\"erqer123\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<Integer> actual1 = List.of(-1000);
		try {
			++testNum;	
			actual1 = Problem.intParts(null); 
			testEquality("null", "" + actual1, "TEST " + testNum + " intParts(null)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: intParts(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual1 = Problem.intParts(new ArrayList<>()); 
			testEquality("[]", "" + actual1, "TEST " + testNum + " intParts(empty)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: intParts(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<String> test = null;
		try {
			++testNum;
			test = new ArrayList<>(Arrays.asList("xxx12", "a123", "bbb1", "ccc7", "fasdfa7", "adfa23"));
			actual1 = Problem.intParts(test); 
			testEquality("[12, 123, 1, 7, 7, 23]", "" + actual1, "TEST " + testNum + ": intParts(" + test + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: intParts(" + test + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		try {
			++testNum;	
			test = new ArrayList<>(Arrays.asList("xxx12", "a123", "bbb1", null, "ccc", "", "fasdfa7", "adfa23"));
			actual1 = Problem.intParts(test); 
			testEquality("[12, 123, 1, 0, 7, 23]", "" + actual1, "TEST " + testNum + ": intParts(" + test + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED:  intParts(" + test + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<BankAccount> test1 = null;
		try{
			++testNum;
			test1 = null;
			Problem.largestAndSmallest(test1);
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
			Problem.largestAndSmallest(test1);
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
					new BankAccount(1000), new BankAccount(1009), null,  
					new BankAccount(1008),new BankAccount(1007),new BankAccount(1010),new BankAccount(1005),
					new BankAccount(1000),new BankAccount(1006),new BankAccount(1004),new BankAccount(1000)));
			Problem.largestAndSmallest(test1);
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
		BankAccount[] actual2;
		try {
			++testNum;	
			test1 = new ArrayList<>(Arrays.asList(
					new BankAccount(1000), new BankAccount(1010), new BankAccount(1009), 
					new BankAccount(1008),new BankAccount(1007),new BankAccount(1010),new BankAccount(1005),
					new BankAccount(1000),new BankAccount(1006),new BankAccount(1004),new BankAccount(1000)));
			actual2 = Problem.largestAndSmallest(test1); 
			String expected = "[" + new BankAccount(1000) + ", " +
					new BankAccount(1010) + ", " + new BankAccount(1010) + ", " +
					new BankAccount(1000) + ", " + new BankAccount(1000) + "]";
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
					new BankAccount(1000), new BankAccount(1001), new BankAccount(1002), 
					new BankAccount(1003),new BankAccount(1004),new BankAccount(1005),new BankAccount(1006),
					new BankAccount(1007),new BankAccount(1008),new BankAccount(1009),new BankAccount(1010)));
			actual2 = Problem.largestAndSmallest(test1); 
			String expected = "[" + new BankAccount(1000) + ", " +
					new BankAccount(1010) + "]";
			testEquality(expected, Arrays.toString(actual2), "TEST " + testNum + " largestAndSmallest(" + test1 + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: largestAndSmallest(" + test1 + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		
		try{
			++testNum;
			new TimePeriod(1,1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new TimePeriod(1,1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad input", e.getMessage(), "TEST " + testNum + " new TimePeriod(1,1)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new TimePeriod(1,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			new TimePeriod(1,1,1,1,1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new TimePeriod(1,1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new TimePeriod(1,1,1,1,1)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new TimePeriod(1,1,1,1,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		TimePeriod actual4 = null;
		try {
			++testNum;	
			actual4 = new TimePeriod(20,30,70,80); 
			String expected = "21d 7h 11m 20s";
			if(!testEquality(expected, "" + actual4, "TEST " + testNum + " new TimePeriod(20,30,70,80)\n")) {
				System.out.println("TimePeriod constructor failed--maybe it's correctUnits");
				System.out.println("Please paste getter and setter into students code to be " + 
						"able to test \"correctUnits\"");
				System.out.println("	public int[] getPeriod() {\n" + 
						"		return period;\n" + 
						"	}\n" + 
						"	public void setPeriod(int[] period) {\n" + 
						"		this.period = period;\n" + 
						"	}\n");
			}
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new TimePeriod(20,30,70,80)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		//testing of correctUnits
		boolean foundMethods = false;
		try {
			TimePeriod.class.getMethod("getPeriod");
			foundMethods = true;
		} catch (NoSuchMethodException nsm) {
		}
		try {
			TimePeriod.class.getMethod("setPeriod", new int[] {}.getClass());
		} catch (NoSuchMethodException nsm) {
			foundMethods = false;
		}
		if(foundMethods) {
			try {
				actual4 = new TimePeriod(1,1,1,1); 
				actual4.getClass().getMethod("setPeriod", new int[] {}.getClass()).invoke(actual4, new int[] {20,30,70,80});
				actual4.correctUnits();
				System.out.println("SPECIAL TEST OF correctUnits");
				String result = Arrays.toString((int[])actual4.getClass().getMethod("getPeriod").invoke(actual4));
				String expected = "[21, 7, 11, 20]";
				if(!testEquality(expected, result, "TEST " + testNum)) {
					System.out.println("correctUnits failed"
							+ " -- SUBTRACT 0.3 (THIS FAILURE IS NOT COUNTED IN THE GRADING");
					System.out.println("Please comment out correctUnits and paste this into "
							+ "students code to be able to test other methods");
					System.out.println("	public void correctUnits() {\n" + 
							"		for(int i = 3; i > 0; i--) {\n" + 
							"		period[i-1] += period[i]/FACTORS[i];\n" + 
							"		period[i] = period[i]%FACTORS[i];\n" + 
							"		}\n" + 
							"	}");  
					
				} else {
					System.out.println("Student's code for correctUnits worked for this test");
					System.out.println("Maybe the constructor failed to call correctUnits");
					System.out.println("Please check the student's constructor");
					System.out.println("Here is my constructor, try with this one");
					System.out.println("	public TimePeriod(int... units) {\n" + 
							"		if(units.length != FACTORS.length) throw new IllegalArgumentException(\"Bad input\");\n" + 
							"		for(int i = 0; i < 4; i++) period[i] = units[i];\n" + 
							"		correctUnits();\n" + 
							"	}\n"); 
				}
			} catch (Exception e) {
				++numWrong;
				out.println("TEST " + testNum + " FAILED: correctUnits for (20,30,70,80)");
				out.println("ERROR MESSAGE SHOWN BELOW");
				e.printStackTrace(out);			
			}
		}
		try {
			++testNum;	
			actual4 = new TimePeriod(-1); 
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new TimePeriod(-1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new TimePeriod(-1)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new TimePeriod(20,30,70,80)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new TimePeriod(1131065); 
			String expected = "13d 2h 11m 5s";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new TimePeriod(1131065)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new TimePeriod(20,30,70,80)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new TimePeriod(13,2,11,5);
			int value = actual4.periodInSeconds();
			String expected = "1131065";
			testEquality(expected, "" + value, "TEST " + testNum + " periodInSeconds()\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: periodInSeconds");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new TimePeriod(13,2,11,5);
			actual4.add(new TimePeriod(1,23,59,59));
			String expected = "15d 2h 11m 4s";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new TimePeriod(13,2,11,5).add(new TimePeriod(1,23,59,59))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: add");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new TimePeriod(13,23,11,55);
			actual4 = actual4.timeDifference(new TimePeriod(15,20,5,50));
			String expected = "1d 20h 53m 55s";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new TimePeriod(13,23,11,55).timeDifference(new TimePeriod(15,20,5,50))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: timeDifference");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new TimePeriod(15,20,5,50);
			actual4 = actual4.timeDifference(new TimePeriod(13,23,11,55));
			String expected = "1d 20h 53m 55s";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new TimePeriod(15,20,5,50).timeDifference(new TimePeriod(13,23,11,55))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: timeDifference");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new TimePeriod(13,23,11,55);
			boolean b = actual4.longerThan(new TimePeriod(15,20,5,50));
			String expected = "false";
			testEquality(expected, "" + b, "TEST " + testNum  + " new TimePeriod(13,23,11,55).longerThan(new TimePeriod(15,20,5,50))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: timeDifference");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new TimePeriod(15,20,5,50);
			boolean b = actual4.longerThan(new TimePeriod(13,23,11,55));
			String expected = "true";
			testEquality(expected, "" + b, "TEST " + testNum + " new TimePeriod(15,20,5,50).longerThan(new TimePeriod(13,23,11,55))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: timeDifference");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		out.println("--------------------");
		out.println(numWrong + " tests failed of " + testNum);
		out.println("lost " + (numWrong*10.0/testNum) + " points");
		grade = grade - numWrong*10.0/testNum;
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