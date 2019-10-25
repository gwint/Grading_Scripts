package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class TesterA53 {
	
	private static PrintStream out = System.out;
	private static int numWrong;
	private static int testNum = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		out = new PrintStream(new FileOutputStream(new File("exam01-a53/report.txt"), true));
		//out = new PrintStream(new FileOutputStream(new File("report54.txt"), true));
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
			int[] test = null;
			Questions1and2.max(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			int[] test = {};
			Questions1and2.max(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		int actual = 0;
		try {
			++testNum;
			actual = Questions1and2.max(new int[] {2,1,4,1,2,4,3,4,3,2});
			testEquality("4", "" + actual, "TEST " + (testNum));
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(new int[] {2,1,4,1,2,4,3,4,3,2}");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Questions1and2.max(new int[] {-2,-1,-4,-1,-2,-4,-3,-4,-3,-2});
			testEquality("-1", "" + actual, "TEST " + (testNum));
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(new int[] {-2,-1,-4,-1,-2,-4,-3,-4,-3,-2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			int[] test = null;
			Questions1and2.min(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			int[] test = {};
			Questions1and2.min(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Questions1and2.min(new int[] {2,1,4,1,2,4,3,4,3,2});
			testEquality("1", "" + actual, "TEST " + (testNum)); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(new int[] {2,1,4,1,2,4,3,4,3,2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Questions1and2.min(new int[] {-2,-1,-4,-1,-2,-4,-3,-4,-3,-2});
			testEquality("-4", "" + actual, "TEST " + (testNum)); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(new int[] {-2,-1,-4,-1,-2,-4,-3,-4,-3,-2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Questions1and2.min(new int[] {0,2,1,4,1,2,0,4,3,4,3,2});
			testEquality("0", "" + actual, "TEST " + (testNum)); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(new int[] {0,2,1,4,1,2,0,4,3,4,3,2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			int[] test = null;
			Questions1and2.countMinMax(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			int[] test = {};
			Questions1and2.countMinMax(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Questions1and2.countMinMax(new int[] {1,3,1,3,1,1,3,3});
			testEquality("8", "" + actual, "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new int[] {1,3,1,3,1,1,3,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Questions1and2.countMinMax(new int[] {-1,3,-1,3,4,1,4,3});
			testEquality("4", "" + actual, "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new int[] {-1,3,-1,3,4,1,4,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Questions1and2.countMinMax(new int[] {1,3,0,3,4,1,4,3});
			testEquality("3", "" + actual, "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new int[] {1,3,0,3,4,1,4,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		int[] actual1 = {10,10,10}; 
		try {
			++testNum;
			actual1 = Questions1and2.allMinMax((int[])null);
			testEquality("[]", Arrays.toString(actual1), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: allMinMax((int[])null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Questions1and2.allMinMax(new int[] {});
			testEquality("[]", Arrays.toString(actual1), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: allMinMax(new int[] {})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Questions1and2.allMinMax(new int[] {-1,3,-1,3,4,1,4,3});
			testEquality("[-1, -1, 4, 4]", Arrays.toString(actual1), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: allMinMax(new int[] {-1,3,-1,3,4,1,4,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		out.println("NOTE TEST " + testNum + " may fail because the arrays are in different orders");
		try {
			++testNum;
			actual1 = Questions1and2.allMinMax(new int[] {1,3,1,3,1,1,3,3});
			testEquality("[1, 3, 1, 3, 1, 1, 3, 3]", Arrays.toString(actual1), "TEST " + (testNum));
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: allMinMax(new int[] {1,3,1,3,1,1,3,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		out.println("NOTE TEST " + testNum + " may fail because the arrays are in different orders");
	}

	public static void testQ2() {
		out.println("*********TESTING QUESTION 2********\n");
		try{ 
			++testNum;
			List<Integer> test = null;
			Questions1and2.max(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			List<Integer> test = List.of();
			Questions1and2.max(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		int actual = 0;
		try {
			++testNum;
			actual = Questions1and2.max(List.of(2,1,4,1,2,4,3,4,3,2));
			testEquality("4", "" + actual, "TEST " + testNum);
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(List.of(2,1,4,1,2,4,3,4,3,2)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Questions1and2.max(List.of(-2,-1,-4,-1,-2,-4,-3,-4,-3,-2));
			testEquality("-1", "" + actual, "TEST " + testNum);
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(List.of(-2,-1,-4,-1,-2,-4,-3,-4,-3,-2))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			List<Integer> test = null;
			Questions1and2.min(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			List<Integer> test = List.of();
			Questions1and2.min(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty lists", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Questions1and2.min(List.of(2,1,4,1,2,4,3,4,3,2));
			testEquality("1", "" + actual, "TEST " + testNum); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(List.of(2,1,4,1,2,4,3,4,3,2))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Questions1and2.min(List.of(-2,-1,-4,-1,-2,-4,-3,-4,-3,-2));
			testEquality("-4", "" + actual, "TEST " + testNum); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(List.of(-2,-1,-4,-1,-2,-4,-3,-4,-3,-2))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Questions1and2.min(List.of(0,2,1,4,1,2,0,4,3,4,3,2));
			testEquality("0", "" + actual, "TEST " + testNum); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(List.of(0,2,1,4,1,2,0,4,3,4,3,2))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			List<Integer> test = null;
			Questions1and2.countMinMax(test);
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
		try{
			++testNum;
			List<Integer> test = List.of();
			Questions1and2.countMinMax(test);
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
		try {
			++testNum;
			actual = Questions1and2.countMinMax(List.of(1,3,1,3,1,1,3,3));
			testEquality("8", "" + actual, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(1,3,1,3,1,1,3,3))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Questions1and2.countMinMax(List.of(-1,3,-1,3,4,1,4,3));
			testEquality("4", "" + actual, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(-1,3,-1,3,4,1,4,3))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Questions1and2.countMinMax(List.of(1,3,0,3,4,1,4,3));
			testEquality("3", "" + actual, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(1,3,0,3,4,1,4,3))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		List<Integer> actual1 = List.of(10,10,10); 
		try {
			++testNum;
			actual1 = Questions1and2.allMinMax((List<Integer>)null);
			testEquality("[]", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: allMinMax((List<Integer>)null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Questions1and2.allMinMax(List.of());
			testEquality("[]", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: allMinMax(List.of())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Questions1and2.allMinMax(List.of(-1,3,-1,3,4,1,4,3));
			testEquality("[-1, -1, 4, 4]", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: allMinMax(List.of(-1,3,-1,3,4,1,4,3))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		out.println("NOTE TEST " + testNum + " may fail because the arrays are in different orders");
		try {
			++testNum;
			actual1 = Questions1and2.allMinMax(List.of(1,3,1,3,1,1,3,3));
			testEquality("[1, 3, 1, 3, 1, 1, 3, 3]", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: allMinMax(List.of(1,3,1,3,1,1,3,3))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		out.println("NOTE TEST " + testNum + " may fail because the arrays are in different orders");
	}

	public static void testQ3() {
		out.println("*********TESTING QUESTION 3********\n");
		try {
			++testNum;
			testEquality("8m 700yds 2ft 7ins.", new USLinearMeasure(8,700,2,7).toString(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new USLinearMeasure(8,700,2,7)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			testEquality("254007", "" + new USLinearMeasure(4,15,2,3).convert(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new USLinearMeasure(4,15,2,3).convert()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			testEquality("3m 275yds 1ft 8ins.", USLinearMeasure.convert(200000).toString(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: USLinearMeasure.convert(200000)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		USLinearMeasure test = null;
		try {
			++testNum;
			test = new USLinearMeasure(10,16,1,10).add(new USLinearMeasure(8,7,0,7));

			if("0m 0yds 0ft 0ins.".equals(test.toString())) {
				out.println("TEST " + testNum + " FAILED: Got 0m 0yds 0ft 0ins.");
				numWrong++;
			} else testEquality(new USLinearMeasure(18,23,2,5), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: USLinearMeasure.add");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			test = new USLinearMeasure(10,6,1,11).subtract(new USLinearMeasure(8,7,2,8));
			if("0m 0yds 0ft 0ins.".equals(test.toString())) {
				out.println("TEST " + testNum + " FAILED: Got 0m 0yds 0ft 0ins.");
				numWrong++;
			} else testEquality(new USLinearMeasure(1,1758,2,3), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: USLinearMeasure.subtract");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			test = new USLinearMeasure(8,7,1,9).subtract(new USLinearMeasure(10,6,1,10));
			if("0m 0yds 0ft 0ins.".equals(new USLinearMeasure(8,7,8,1).toString())) {
				out.println("TEST " + testNum + " FAILED: See Test 37");
				numWrong++;
			} else testEquality(new USLinearMeasure(0,0,0,0), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: USLinearMeasure.subtract--neg return");
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
