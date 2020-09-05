package exam02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam02A53test {
	private static PrintStream out = System.out;
	private static Triangle triangle1 = new Scalene(new int[] {4,5,7});
	private static Triangle triangle2 = new Isosceles(new int[] {4,7,7});
	private static Triangle triangle3 = new Equilateral(new int[] {4,4,4});
	private static List<Triangle> testList = 
			new ArrayList<> (Arrays.asList(
					new Scalene(new int[] {4,5,8}),
					new Isosceles(new int[] {4,7,7}),
					new Scalene(new int[] {4,6,7}),
					new Scalene(new int[] {2,5,7}),
					new Equilateral(new int[] {4,4,4}),
					new Isosceles(new int[] {3,7,7}),
					new Equilateral(new int[] {2,2,2}),
					new Scalene(new int[] {1,5,9}),
					new Isosceles(new int[] {3,8,8}),
					new Scalene(new int[] {4,5,7}),
					new Equilateral(new int[] {3,3,3}),
					new Scalene(new int[] {4,5,7}),
					new Isosceles(new int[] {5,6,6})
					));
	private static List<Triangle> testList2 = 
			new ArrayList<> (Arrays.asList(
					new Scalene(new int[] {4,5,8}),
					new Isosceles(new int[] {4,7,7}),
					new Scalene(new int[] {4,6,7}),
					new Scalene(new int[] {2,5,7}),
					new Equilateral(new int[] {4,4,4}),
					new Isosceles(new int[] {3,9,9}),
					new Equilateral(new int[] {2,2,2}),
					new Scalene(new int[] {1,5,9}),
					new Isosceles(new int[] {3,8,8}),
					new Scalene(new int[] {4,5,7}),
					new Equilateral(new int[] {3,3,3}),
					new Scalene(new int[] {4,5,7}),
					new Isosceles(new int[] {5,6,6})
					));
	private static List<Triangle> testListOrdered = 
			new ArrayList<> (Arrays.asList(
					new Scalene(new int[] {1,5,9}),
					new Equilateral(new int[] {2,2,2}),
					new Equilateral(new int[] {3,3,3}),
					new Isosceles(new int[] {3,7,7}),
					new Isosceles(new int[] {3,8,8}),
					new Equilateral(new int[] {4,4,4}),
					new Scalene(new int[] {4,5,7}),
					new Scalene(new int[] {4,5,7}),
					new Scalene(new int[] {4,5,8}),
					new Scalene(new int[] {4,6,7}),
					new Isosceles(new int[] {4,7,7}),
					new Isosceles(new int[] {5,6,6}),
					new Scalene(new int[] {2,5,7})
					));
	private static int[] numWrong = new int[3];
	private static int testNum = 0;
	private static int q1Count = 1;
	private static int q2Count = 1;
	private static int q3Count = 1;
	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		String file = "/home/mllab/Desktop/CS140/Grading_Scripts/exam02-a53/report.txt";
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
		out.println("*********TESTING Triangle********\n");
		try{
			++testNum;
			triangle1.compareTo(null);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: compareTo(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("illegal input", e.getMessage(), "TEST " + testNum, 0);
		} catch(Exception e){
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: compareTo(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		int actual = 0;
		try {
			++testNum;		
			actual = triangle1.compareTo(new Scalene(new int[] {4,5,7}));
			testEquality("0", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.compareTo(Scalene(new int[] {4,5,7}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = triangle1.compareTo(new Scalene(new int[] {2,6,8}));
			testEquality("2", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.compareTo(new Scalene(new int[] {2,6,8}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = triangle1.compareTo(new Scalene(new int[] {4,7,8}));
			testEquality("-2", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.compareTo(new Scalene(new int[] {4,7,8}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = triangle1.compareTo(new Scalene(new int[] {4,5,6}));
			testEquality("1", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.compareTo(new Scalene(new int[] {4,5,6}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		String actual1 = "";
		try {
			++testNum;		
			actual1 = triangle1.name();
			testEquality("Scalene", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.name()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = triangle2.name();
			testEquality("Isosceles", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle2.name()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = triangle3.name();
			testEquality("Equilateral", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle3.name()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = triangle1.toString();
			testEquality("[4, 5, 7]", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.toString()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		boolean actual2 = false;
		try {
			++testNum;		
			actual2 = triangle1.equals(triangle1);
			testEquality("true", ""+actual2, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.equals(triangle1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual2 = triangle1.equals(null);
			testEquality("false", ""+actual2, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.equals(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual2 = triangle1.equals(triangle2);
			testEquality("false", ""+actual2, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.equals(triangle2)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual2 = triangle1.equals(new Scalene(new int[] {4,5,6}));
			testEquality("false", ""+actual2, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.equals(new Scalene(new int[] {4,5,6}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		
		try {
			++testNum;		
			actual = triangle1.hashCode();
			testEquality("" + Arrays.hashCode(new int[] {4,5,7}), ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: triangle1.hashCode()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}

		try{
			++testNum;
			int[] arg = null;
			Factory.makeObject(arg);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(null) gave no Exception");
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
			int[] arg = {};
			Factory.makeObject(arg);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject({}) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("invalid input", e.getMessage().toLowerCase(), "TEST " + testNum, 0);
		} catch(Exception e){
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject({})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			int[] arg = {1,2};
			Factory.makeObject(arg);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject({1,2}) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("invalid input", e.getMessage().toLowerCase(), "TEST " + testNum, 0);
		} catch(Exception e){
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject({1,2})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try{
			++testNum;
			int[] arg = {1,2,4,5};
			Factory.makeObject(arg);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject({1,2,4,5}) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("invalid input", e.getMessage().toLowerCase(), "TEST " + testNum, 0);
		} catch(Exception e){
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject({1,2,4,5})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}

		try {
			++testNum;		
			Triangle p = Factory.makeObject(new int[] {1,2,3});
			testEquality("Scalene[1, 2, 3]", p.name()+p.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(1,2,3)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Triangle p = Factory.makeObject(2,2,1);
			testEquality("Isosceles[1, 2, 2]", p.name()+p.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(2,2,1)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Triangle p = Factory.makeObject(1,1,1);
			testEquality("Equilateral[1, 1, 1]", p.name()+p.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(1,1,1)");
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
			testEquality("{Isosceles=[[4, 7, 7], [3, 7, 7], [3, 8, 8], [5, 6, 6]], "
					+ "Equilateral=[[4, 4, 4], [2, 2, 2], [3, 3, 3]], "
					+ "Scalene=[[4, 5, 8], [4, 6, 7], [2, 5, 7], [1, 5, 9], "
					+ "[4, 5, 7], [4, 5, 7]]}", actual, "TEST " + testNum, 1);
		} catch (Exception e) {
			++numWrong[1];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = ""+Factory.sort(testListOrdered.stream());
			testEquality("{Isosceles=[[3, 7, 7], [3, 8, 8], [4, 7, 7], [5, 6, 6]], "
					+ "Equilateral=[[2, 2, 2], [3, 3, 3], [4, 4, 4]], "
					+ "Scalene=[[1, 5, 9], [4, 5, 7], [4, 5, 7], [4, 5, 8], "
					+ "[4, 6, 7], [2, 5, 7]]}",
					actual, "TEST " + testNum, 1);
		} catch (Exception e) {
			++numWrong[1];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = ""+Factory.selectChildren(testList);
			testEquality("[[4, 7, 7], [3, 7, 7], [3, 8, 8], [5, 6, 6]]", 
					actual, "TEST " + testNum, 1);
		} catch (Exception e) {
			++numWrong[1];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = ""+Factory.selectChildren(testListOrdered);
			testEquality("[[3, 7, 7], [3, 8, 8], [4, 7, 7], [5, 6, 6]]",
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
		BinarySearchTree<Triangle> t = new BinarySearchTree<>();
		for(Triangle p : testList) t.add(p);
		BinarySearchTree<Triangle> t1 = new BinarySearchTree<>();
		for(Triangle p : testListOrdered) t1.add(p);
		BinarySearchTree<Triangle> t2 = new BinarySearchTree<>();
		for(Triangle p : testList2) t2.add(p);

		if(!Arrays.toString(BinarySearchTree.class.getDeclaredMethods()).contains("hashCode")) {
			out.println("hashcode not overriden");
			numWrong[2] += 1;
			testNum += 1; 		
		} else {
			try {
				++testNum;		
				testEquality("29102371", ""+t.hashCode(), "TEST " + testNum, 2);
			} catch (Exception e) {
				++numWrong[2];
				out.println("TEST " + testNum + " FAILED: t.equals(null)");
				out.println("ERROR MESSAGE SHOWN BELOW");
				e.printStackTrace(out);			
			}
		}

		if(!Arrays.toString(BinarySearchTree.class.getDeclaredMethods()).contains("equals")) {
			out.println("equals not overriden");
			numWrong[2] += 4;
			testNum += 4; 		
		} else {
			boolean actual = false;
			try {
				++testNum;		
				actual = t.equals(null);
				testEquality("false", ""+actual, "TEST " + testNum, 2);
			} catch (Exception e) {
				++numWrong[2];
				out.println("TEST " + testNum + " FAILED: t.equals(null)");
				out.println("ERROR MESSAGE SHOWN BELOW");
				e.printStackTrace(out);			
			}
			try {
				++testNum;		
				actual = t.equals(t);
				testEquality("true", ""+actual, "TEST " + testNum, 2);
			} catch (Exception e) {
				++numWrong[2];
				out.println("TEST " + testNum + " FAILED: t.equals(t)");
				out.println("ERROR MESSAGE SHOWN BELOW");
				e.printStackTrace(out);			
			}
			try {
				++testNum;		
				actual = t.equals(t2);
				testEquality("false", ""+actual, "TEST " + testNum, 2);
			} catch (Exception e) {
				++numWrong[2];
				out.println("TEST " + testNum + " FAILED: t.equals(t2)");
				out.println("ERROR MESSAGE SHOWN BELOW");
				e.printStackTrace(out);			
			}
			t=t.balance();
			t1=t1.balance();
			try {
				++testNum;		
				actual = t.equals(t1);
				testEquality("true", ""+actual, "TEST " + testNum, 2);
			} catch (Exception e) {
				++numWrong[2];
				out.println("TEST " + testNum + " FAILED: t.equals(t1)");
				out.println("ERROR MESSAGE SHOWN BELOW");
				e.printStackTrace(out);			
			}
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
