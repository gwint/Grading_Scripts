package exam01;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesterA52 {
	private static PrintStream out = System.out;
	private static int numWrong;
	private static int testNum = 0;

	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		out = new PrintStream(new FileOutputStream(new File("exam01makeupA52/report.txt"), true));
		numWrong = 0;
		String actual = "BAD RESULT";
		try {
			++testNum;	
			actual = FirstPart.rotateTo('a', null); 
			testEquality("null", "" + actual, "TEST " + testNum + " rotateTo('a', null)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: rotateTo('a', null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = FirstPart.rotateTo('a', ""); 
			testEquality("", "" + actual, "TEST " + testNum + " rotateTo('a', \"\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: rotateTo('a', \"\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = FirstPart.rotateTo('x', "sdfasdf"); 
			testEquality("sdfasdf", "" + actual, "TEST " + testNum + " rotateTo('x',\"sdfasdf\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: rotateTo('x',\"sdfasdf\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = FirstPart.rotateTo('a', "a"); 
			testEquality("a", "" + actual, "TEST " + testNum + " rotateTo('a',\"a\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: rotateTo('a',\"a\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = FirstPart.rotateTo('1',"123xyz"); 
			testEquality("123xyz", "" + actual, "TEST " + testNum + " rotateTo('1',\"123xyz\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: rotateTo('1',\"123xyz\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual = FirstPart.rotateTo('1', "erqer123"); 
			testEquality("123erqer", "" + actual, "TEST " + testNum + " rotateTo('1',\"erqer123\")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: rotateTo('1',\"erqer123\")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<Integer> actual1 = List.of(-1000);
		try {
			++testNum;	
			actual1 = FirstPart.firstIndexOf('1',null); 
			testEquality("null", "" + actual1, "TEST " + testNum + " firstIndexOf('1',null)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstIndexOf('1',null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual1 = FirstPart.firstIndexOf('1',new ArrayList<>()); 
			testEquality("[]", "" + actual1, "TEST " + testNum + " firstIndexOf('1',empty)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstIndexOf('1',empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<String> test = null;
		try {
			++testNum;
			test = new ArrayList<>(Arrays.asList("xxx12", "a123", "bbb1", "ccc7", "1fasdfa7", "adfa231"));
			actual1 = FirstPart.firstIndexOf('1',test); 
			testEquality("[3, 1, 3, -1, 0, 6]", "" + actual1, "TEST " + testNum + ": firstIndexOf('1'," + test + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: firstIndexOf(" + test + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}		
		try {
			++testNum;	
			test = new ArrayList<>(Arrays.asList("xxx12", "a123", "bbb1", null, "ccc", "", "1fasdfa7", "adfa231"));
			actual1 = FirstPart.firstIndexOf('1',test); 
			testEquality("[3, 1, 3, -1, -1, -1, 0, 6]", "" + actual1, "TEST " + testNum + ": intParts('1'," + test + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED:  intParts(" + test + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		List<Rectangle> test1 = null;
		try{
			++testNum;
			test1 = null;
			FirstPart.notLargestOrSmallest(test1);
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
			FirstPart.notLargestOrSmallest(test1);
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
					new Rectangle(0,0,1,10), new Rectangle(0,0,1,19), null,  
					new Rectangle(0,0,1,18),new Rectangle(0,0,1,17),new Rectangle(0,0,1,11),new Rectangle(0,0,1,15),
					new Rectangle(0,0,1,20),new Rectangle(0,0,1,16),new Rectangle(0,0,1,14),new Rectangle(0,0,1,20)));
			FirstPart.notLargestOrSmallest(test1);
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
		Rectangle[] actual2;
		try {
			++testNum;	
			test1 = new ArrayList<>(Arrays.asList(
					new Rectangle(0,0,1,10), new Rectangle(0,0,1,19), new Rectangle(0,0,1,20),  
					new Rectangle(0,0,1,18),new Rectangle(0,0,1,17),new Rectangle(0,0,1,11),new Rectangle(0,0,1,15),
					new Rectangle(0,0,1,20),new Rectangle(0,0,1,16),new Rectangle(0,0,1,14),new Rectangle(0,0,1,20)));
			actual2 = FirstPart.notLargestOrSmallest(test1); 
			String expected = "[" + new Rectangle(0,0,1,19) + ", " + new Rectangle(0,0,1,18) + ", " +
					new Rectangle(0,0,1,17) + ", " + new Rectangle(0,0,1,11) + ", " + new Rectangle(0,0,1,15) + ", " +
					new Rectangle(0,0,1,16) + ", " + new Rectangle(0,0,1,14) + "]";
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
					new Rectangle(0,0,1,19), new Rectangle(0,0,1,10), new Rectangle(0,0,1,18),  
					new Rectangle(0,0,1,20),new Rectangle(0,0,1,17),new Rectangle(0,0,1,11),new Rectangle(0,0,1,15),
					new Rectangle(0,0,1,20),new Rectangle(0,0,1,16),new Rectangle(0,0,1,20),new Rectangle(0,0,1,14)));
			actual2 = FirstPart.notLargestOrSmallest(test1); 
			String expected = "[" + new Rectangle(0,0,1,19) + ", " + new Rectangle(0,0,1,18) + ", " +
					new Rectangle(0,0,1,17) + ", " + new Rectangle(0,0,1,11) + ", " + new Rectangle(0,0,1,15) + ", " +
					new Rectangle(0,0,1,16) + ", " + new Rectangle(0,0,1,14) + "]";
			testEquality(expected, Arrays.toString(actual2), "TEST " + testNum + " notLargestOrSmallest(" + test1 + ")\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: notLargestOrSmallest(" + test1 + ")");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		
		try{
			++testNum;
			new Angle(1,1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Angle(1,1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad input", e.getMessage(), "TEST " + testNum + " new Angle(1,1)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Angle(1,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			new Angle(1,1,1,1,1);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Angle(1,1,1,1,1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Angle(1,1,1,1,1)\n");
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Angle(1,1,1,1,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		Angle actual4 = null;
		System.out.println("Expected 53^ 11' 5\", got " + new Angle(412,70,65));
		try {
			++testNum;	
			actual4 = new Angle(412,70,65); 
			String expected = "53^ 11' 5\"";
			if(!testEquality(expected, "" + actual4, "TEST " + testNum + " new Angle(412,70,65)\n")) {
				System.out.println("Angle constructor failed--maybe it's correctUnits");
				System.out.println("Please paste getter and setter into students code to be " + 
						"able to test \"correctUnits\"");
				System.out.println("	public int[] getAngle() {\n" + 
						"		return angle;\n" + 
						"	}\n" + 
						"	public void setAngle(int[] angle) {\n" + 
						"		this.angle = angle;\n" + 
						"	}\n");
			}
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Angle(412,70,65)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		//testing of correctUnits
		boolean foundMethods = false;
		try {
			Angle.class.getMethod("getAngle");
			foundMethods = true;
		} catch (NoSuchMethodException nsm) {
		}
		try {
			Angle.class.getMethod("setAngle", new int[] {}.getClass());
		} catch (NoSuchMethodException nsm) {
			foundMethods = false;
		}
		if(foundMethods) {
			try {
				actual4 = new Angle(1,1,1); 
				actual4.getClass().getMethod("setAngle", new int[] {}.getClass()).invoke(actual4, new int[] {412,70,65});
				actual4.correctUnits();
				System.out.println("SPECIAL TEST OF correctUnits");
				String result = Arrays.toString((int[])actual4.getClass().getMethod("getAngle").invoke(actual4));
				String expected = "[53, 11, 5]";
				if(!testEquality(expected, result, "TEST " + testNum)) {
					System.out.println("correctUnits failed"
							+ " -- SUBTRACT 0.3 (THIS FAILURE IS NOT COUNTED IN THE GRADING");
					System.out.println("Please comment out correctUnits and paste this into "
							+ "students code to be able to test other methods");
					System.out.println("	public void correctUnits() {\n" + 
							"		angle[1] += angle[2]/FACTORS[2];\n" + 
							"		angle[2] = angle[2]%FACTORS[2];\n" + 
							"		angle[0] += angle[1]/FACTORS[1];\n" + 
							"		angle[1] = angle[1]%FACTORS[1];\n" + 
							"		angle[0] = angle[0]%FACTORS[0];\n" + 
							"	}\n");
					
				} else {
					System.out.println("Student's code for correctUnits worked for this test");
					System.out.println("Maybe the constructor failed to call correctUnits");
					System.out.println("Please check the student's constructor");
					System.out.println("Here is my constructor, try with this one");
					System.out.println("	public Angle(int... units) {\n" + 
							"		if(units.length != FACTORS.length) throw new IllegalArgumentException(\"Bad input\");\n" + 
							"		for(int i = 0; i < 3; i++) angle[i] = units[i];\n" + 
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
			actual4 = new Angle(-1); 
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Angle(-1) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Bad...", e.getMessage().substring(0,3)+"...", "TEST " + testNum + " new Angle(-1)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Angle(-1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Angle(191465); 
			String expected = "53^ 11' 5\"";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Angle(191465)\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new Angle(191465)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Angle(53,11,5);
			int value = actual4.angleInSeconds();
			String expected = "191465";
			testEquality(expected, "" + value, "TEST " + testNum + " angleInSeconds()\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: angleInSeconds");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Angle(53,11,5);
			actual4.add(new Angle(40,58,56));
			String expected = "94^ 10' 1\"";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Angle(53,11,5).add(new Angle(40,58,56))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: add");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Angle(53,11,5);
			actual4 = actual4.angleDifference(new Angle(40,58,56));
			String expected = "12^ 12' 9\"";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Angle(53,11,5).timeDifference(new Angle(40,58,56))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: angleDifference");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Angle(40,58,56);
			actual4 = actual4.angleDifference(new Angle(53,11,5));
			String expected = "12^ 12' 9\"";
			testEquality(expected, "" + actual4, "TEST " + testNum + " new Angle(40,58,56).timeDifference(new Angle(53,11,5))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: angleDifference");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Angle(40,58,56);
			boolean b = actual4.largerThan(new Angle(53,11,5));
			String expected = "false";
			testEquality(expected, "" + b, "TEST " + testNum  + " new Angle(13,23,11,55).largerThan(new Angle(15,20,5,50))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: angleDifference");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;	
			actual4 = new Angle(53,11,5);
			boolean b = actual4.largerThan(new Angle(40,58,56));
			String expected = "true";
			testEquality(expected, "" + b, "TEST " + testNum + " new Angle(15,20,5,50).largerThan(new Angle(13,23,11,55))\n");
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: angleDifference");
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