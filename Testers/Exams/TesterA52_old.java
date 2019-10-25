package exam01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class TesterA52 {
	private static PrintStream out = System.out;
	private static int numWrong;
	private static int testNum = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		out = new PrintStream(new FileOutputStream(new File("exam01-a52/report.txt"), true));
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
			double[] test = null;
			Parts1and2.max(test);
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
			double[] test = {};
			Parts1and2.max(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		double actual = 0;
		try {
			++testNum;
			actual = Parts1and2.max(new double[] {2,1,4,1,2,4,3,4,3,2});
			testEquality("4.0", "" + actual, "TEST " + testNum);
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(new double[] {2,1,4,1,2,4,3,4,3,2}");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Parts1and2.max(new double[] {-2,-1,-4,-1,-2,-4,-3,-4,-3,-2});
			testEquality("-1.0", "" + actual, "TEST " + testNum);
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(new double[] {-2,-1,-4,-1,-2,-4,-3,-4,-3,-2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			double[] test = null;
			Parts1and2.min(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			double[] test = {};
			Parts1and2.min(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(empty) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(empty)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual = Parts1and2.min(new double[] {2,1,4,1,2,4,3,4,3,2});
			testEquality("1.0", "" + actual, "TEST " + testNum); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(new double[] {2,1,4,1,2,4,3,4,3,2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Parts1and2.min(new double[] {-2,-1,-4,-1,-2,-4,-3,-4,-3,-2});
			testEquality("-4.0", "" + actual, "TEST " + testNum); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(new double[] {-2,-1,-4,-1,-2,-4,-3,-4,-3,-2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Parts1and2.min(new double[] {0,2,1,4,1,2,0,4,3,4,3,2});
			testEquality("0.0", "" + actual, "TEST " + testNum); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(new double[] {0,2,1,4,1,2,0,4,3,4,3,2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			double[] test = null;
			Parts1and2.countMinMax(test);
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("Use non-empty arrays", e.getMessage(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + "10 FAILED: countMinMax(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{ 
			++testNum;
			double[] test = {};
			Parts1and2.countMinMax(test);
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
			actual1 = Parts1and2.countMinMax(new double[] {1,3,1,3,1,1,3,3});
			testEquality("8", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new double[] {1,3,1,3,1,1,3,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Parts1and2.countMinMax(new double[] {-1,3,-1,3,4,1,4,3});
			testEquality("4", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new double[] {-1,3,-1,3,4,1,4,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Parts1and2.countMinMax(new double[] {1,3,0,3,4,1,4,3});
			testEquality("3", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(new double[] {1,3,0,3,4,1,4,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		double[] actual2 = {10,10,10};
		try {
			++testNum;
			actual2 = Parts1and2.core((double[])null);
			testEquality("[]", Arrays.toString(actual2), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core((double[])null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual2 = Parts1and2.core(new double[] {});
			testEquality("[]", Arrays.toString(actual2), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(new double[] {})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual2 = Parts1and2.core(new double[] {-1,3,-1,3,4,1,4,3});
			testEquality("[3.0, 3.0, 1.0, 3.0]", Arrays.toString(actual2), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(new double[] {-1,3,-1,3,4,1,4,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		out.println("NOTE TEST " + testNum + " may fail because the arrays are in different orders");
		try {
			++testNum;
			actual2 = Parts1and2.core(new double[] {1,3,1,3,1,1,3,3});
			testEquality("[]", Arrays.toString(actual2), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(new double[] {1,3,1,3,1,1,3,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
	}

	public static void testQ2() {
		out.println("*********TESTING QUESTION 2********\n");
		try{ 
			++testNum;
			List<Double> test = null;
			Parts1and2.max(test);
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
			List<Double> test = List.of();
			Parts1and2.max(test);
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
		double actual = 0;
		try {
			++testNum;
			actual = Parts1and2.max(List.of(2.0,1.0,4.0,1.0,2.0,4.0,3.0,4.0,3.0,2.0));
			testEquality("4.0", "" + actual, "TEST " + testNum);
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(List.of(2.0,1.0,4.0,1.0,2.0,4.0,3.0,4.0,3.0,2.0)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Parts1and2.max(List.of(-2.0,-1.0,-4.0,-1.0,-2.0,-4.0,-3.0,-4.0,-3.0,-2.0));
			testEquality("-1.0", "" + actual, "TEST " + testNum);
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: max(List.of(-2.0,-1.0,-4.0,-1.0,-2.0,-4.0,-3.0,-4.0,-3.0,-2.0))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			List<Double> test = null;
			Parts1and2.min(test);
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
			List<Double> test = List.of();
			Parts1and2.min(test);
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
			actual = Parts1and2.min(List.of(2.0,1.0,4.0,1.0,2.0,4.0,3.0,4.0,3.0,2.0));
			testEquality("1.0", "" + actual, "TEST " + testNum);
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(List.of(2.0,1.0,4.0,1.0,2.0,4.0,3.0,4.0,3.0,2.0))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Parts1and2.min(List.of(-2.0,-1.0,-4.0,-1.0,-2.0,-4.0,-3.0,-4.0,-3.0,-2.0));
			testEquality("-4.0", "" + actual, "TEST " + testNum); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(List.of(-2.0,-1.0,-4.0,-1.0,-2.0,-4.0,-3.0,-4.0,-3.0,-2.0))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;
			actual = Parts1and2.min(List.of(2.0,1.0,4.0,0.0,2.0,4.0,3.0,0.0,3.0,2.0));
			testEquality("0.0", "" + actual, "TEST " + testNum); 
		} catch (Exception e) {
			++numWrong;
			out.println("TEST " + testNum + " FAILED: min(List.of(2.0,1.0,4.0,0.0,2.0,4.0,3.0,0.0,3.0,2.0))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{ 
			++testNum;
			List<Double> test = null;
			Parts1and2.countMinMax(test);
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
			List<Double> test = List.of();
			Parts1and2.countMinMax(test);
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
			actual1 = Parts1and2.countMinMax(List.of(1.0,3.0,1.0,3.0,1.0,1.0,3.0,3.0));
			testEquality("8", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(1.0,3.0,1.0,3.0,1.0,1.0,3.0,3.0)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Parts1and2.countMinMax(List.of(-1.0,3.0,-1.0,3.0,4.0,1.0,4.0,3.0));
			testEquality("4", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(-1.0,3.0,-1.0,3.0,4.0,1.0,4.0,3.0))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual1 = Parts1and2.countMinMax(List.of(1.0,3.0,0.0,3.0,4.0,1.0,4.0,3.0));
			testEquality("3", "" + actual1, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: countMinMax(List.of(1.0,3.0,0.0,3.0,4.0,1.0,4.0,3.0))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		List<Double> actual2 = List.of(10.0, 10.0, 10.0);
		try {
			++testNum;
			actual2 = Parts1and2.core((List<Double>)null);
			testEquality("[]", actual2, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core((List<Double>)null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual2 = Parts1and2.core(List.of());
			testEquality("[]", actual2, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(List.of())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			actual2 = Parts1and2.core(List.of(-1.0,3.0,-1.0,3.0,4.0,1.0,4.0,3.0)); 
			testEquality("[3.0, 3.0, 1.0, 3.0]", actual2, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(List.of(-1.0,3.0,-1.0,3.0,4.0,1.0,4.0,3.0))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		out.println("NOTE TEST " + testNum + " may fail because the arrays are in different orders");
		try {
			++testNum;
			actual2 = Parts1and2.core(List.of(1.0,3.0,1.0,3.0,1.0,1.0,3.0,3.0));
			testEquality("[]", actual2, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: core(List.of(1.0,3.0,1.0,3.0,1.0,1.0,3.0,3.0))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
	}

	public static void testQ3() {
		out.println("*********TESTING QUESTION 3********\n");
		try {
			++testNum;
			testEquality("L8 7s 8d.", new OldBritishMoney(8,7,8).toString(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new OldBritishMoney(8,7,8)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			testEquality("1148", "" + new OldBritishMoney(4,15,8).convert(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: new OldBritishMoney(4,15,8).convert()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			testEquality("L4 15s 11d.", OldBritishMoney.convert(1151).toString(), "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: OldBritishMoney.convert(1151)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		OldBritishMoney test = null;
		try {
			++testNum;
			test = new OldBritishMoney(10,16,10).add(new OldBritishMoney(8,7,8));
			if("L0 0s 0d.".equals(test.toString())) {
				out.println("TEST " + testNum + " Failed--Got L0 0s 0d.");
				numWrong++;
			} else testEquality(new OldBritishMoney(19,4,6), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: OldBritishMoney.add");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			test = new OldBritishMoney(10,6,1).subtract(new OldBritishMoney(8,7,8));
			if("L0 0s 0d.".equals(test.toString())) {
				out.println("TEST " + testNum + " FAILED--Got L0 0s 0d.");
				numWrong++;
			} else testEquality(new OldBritishMoney(1,18,5), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: OldBritishMoney.subtract");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;
			test = new OldBritishMoney(8,7,8).subtract(new OldBritishMoney(10,6,1));
			if("L0 0s 0d.".equals(new OldBritishMoney(8,7,8).toString())) {
				out.println("TEST " + testNum + " FAILED--see Test 37");
				numWrong++;
			} else testEquality(new OldBritishMoney(0,0,0), test, "TEST " + testNum);
		} catch(Exception e){
			++numWrong;
			out.println("TEST " + testNum + " FAILED: OldBritishMoney.subtract--neg return");
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

