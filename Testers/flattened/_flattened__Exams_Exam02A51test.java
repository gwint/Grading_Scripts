package exam02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam02A51test {
	private static PrintStream out = System.out;
	private static Parent parent = new Parent(new int[] {4,7,5,8,3});
	private static List<Parent> testList = 
			new ArrayList<> (Arrays.asList(
					new Child(new int[] {2,3,5,3,6}),
					new Parent(new int[] {2,4,5,3,6}),
					new Child(new int[] {3,3,5,3,6}),
					new Child(new int[] {4,3,5,3,6}),
					new Parent(new int[] {6,2,5,3,0}),
					new Parent(new int[] {9,1,5,3,6}),
					new Child(new int[] {5,9,5,3,6}),
					new Child(new int[] {1,3,5,3,6}),
					new Parent(new int[] {7,8,5,3,6}),
					new Child(new int[] {2,6,5,3,6})
					));
	private static List<Parent> testListOrdered = 
			new ArrayList<> (Arrays.asList(
					new Child(new int[] {1,3,5,3,6}),
					new Child(new int[] {2,3,5,3,6}),
					new Child(new int[] {2,6,5,3,6}),
					new Parent(new int[] {2,4,5,3,6}),
					new Child(new int[] {3,3,5,3,6}),
					new Child(new int[] {4,3,5,3,6}),
					new Parent(new int[] {6,2,5,3,0}),
					new Child(new int[] {5,9,5,3,6}),
					new Parent(new int[] {7,8,5,3,6}),
					new Parent(new int[] {9,1,5,3,6})
					));
	private static int[] numWrong = new int[3];
	private static int testNum = 0;
	private static int q1Count = 1;
	private static int q2Count = 1;
	private static int q3Count = 1;
	public static void main(String[] args) throws FileNotFoundException {
		// can change output here
		String file = "/home/mllab/Desktop/CS140/Grading_Scripts/exam02-a51/report.txt";
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
		out.println("*********TESTING Parent********\n");
		try{
			++testNum;
			parent.compareFields(null);
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
			actual = parent.compareFields(new Parent(new int[] {4,7,5,8,3}));
			testEquality("0", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: parent.compareFields(new Parent(new int[] {4,7,5,8,3}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = parent.compareFields(new Parent(new int[] {2,7,5,8,3}));
			testEquality("2", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: parent.compareFields(new Parent(new int[] {2,7,5,8,3}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = parent.compareFields(new Parent(new int[] {4,9,5,8,3}));
			testEquality("-2", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: parent.compareFields(new Parent(new int[] {4,9,5,8,3}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = parent.compareFields(new Parent(new int[] {4,7,5,5,3}));
			testEquality("3", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: parent.compareFields(new Parent(new int[] {4,7,5,5,3}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = parent.compareFields(new Parent(new int[] {4,7,5,8,6}));
			testEquality("-3", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: parent.compareFields(new Parent(new int[] {4,7,5,8,6}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		String actual1 = "";
		try {
			++testNum;		
			actual1 = parent.type();
			testEquality("Parent", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: parent.type()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = parent.compareTo(new Parent(new int[] {4,7,5,8,6}));
			testEquality("-3", ""+actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: parent.compareTo(new Parent(new int[] {4,7,5,8,6}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = parent.toString();
			testEquality("[4, 7, 5, 8, 3]", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: parent.toString()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = new Child(new int[] {4, 7, 7, 7, 3}).toString();
			testEquality("[4, 7, 7, 7, 3]", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Child constructor");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = new Child(null).type();
			testEquality("Child", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: child.type()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual1 = new Child(null).type();
			testEquality("Child", actual1, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: child.type()");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try{
			++testNum;
			int[] arg = null;
			Factory.makeObject(arg);
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: compareFields(null) gave no Exception");
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
			out.println("TEST " + testNum + " FAILED: compareFields(null) gave no Exception");
		} catch(IllegalArgumentException e){
			testEquality("invalid input", e.getMessage().toLowerCase(), "TEST " + testNum, 0);
		} catch(Exception e){
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);
		}
		try {
			++testNum;		
			Parent p = Factory.makeObject(1,2,3,4,5,6);
			testEquality("Parent[1, 2, 3, 4, 5]", p.type()+p.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(1,2,3,4,5,6)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Parent p = Factory.makeObject(1,2,3,4,5,5);
			testEquality("Parent[1, 2, 3, 4, 5]", p.type()+p.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(1,2,3,4,5,5)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Parent p = Factory.makeObject(1,2,3,2,5,6);
			testEquality("Child[1, 2, 3, 2, 5]", p.type()+p.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(1,2,3,2,5,6)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			Parent p = Factory.makeObject(1,2,3);
			testEquality("Child[1, 2, 3, 0, 0]", p.type()+p.toString(), "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.makeObject(1,2,3)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(parent, parent);
			testEquality("0", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(parent, parent)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(null, parent);
			testEquality("-1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(null, parent)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(parent, null);
			testEquality("1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(parent, null)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Child(new int[] {5,7,5,5,3}), new Parent(new int[] {4,7,6,5,3}));
			testEquality("-1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Child(new int[] {5,7,5,5,3}), new Parent(new int[] {4,7,6,5,3}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Parent(new int[] {4,7,6,5,3}),new Child(new int[] {5,7,5,5,3}));
			testEquality("1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Parent(new int[] {4,7,6,5,3}),new Child(new int[] {5,7,5,5,3}))");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(parent, new Parent(new int[] {4,7,5,6,3}));
			testEquality("2", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(parent, new Parent(new int[] {4,7,5,6,3})");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Parent(new int[] {4,7,5,6,3}), parent);
			testEquality("-2", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Parent(new int[] {4,7,5,6,3}), parent)");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = Factory.compare(new Child(new int[] {5,7,5,5,3}), new Child(new int[] {5,7,6,5,3}));
			testEquality("-1", "" + actual, "TEST " + testNum, 0);
		} catch (Exception e) {
			++numWrong[0];
			out.println("TEST " + testNum + " FAILED: Factory.compare(new Child(new int[] {5,7,5,5,3}), new Child(new int[] {5,7,6,5,3}))");
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
			testEquality("{Parent=[[2, 4, 5, 3, 6], [6, 2, 5, 3, 0], "
					+ "[9, 1, 5, 3, 6], [7, 8, 5, 3, 6]], Child=[[2, 3, 5, 3, 6], "
					+ "[3, 3, 5, 3, 6], [4, 3, 5, 3, 6], [5, 9, 5, 3, 6], "
					+ "[1, 3, 5, 3, 6], [2, 6, 5, 3, 6]]}", actual, "TEST " + testNum, 1);
		} catch (Exception e) {
			++numWrong[1];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}
		try {
			++testNum;		
			actual = ""+Factory.sort(testListOrdered.stream());
			testEquality("{Parent=[[2, 4, 5, 3, 6], [6, 2, 5, 3, 0], "
					+ "[7, 8, 5, 3, 6], [9, 1, 5, 3, 6]], Child=[[1, 3, 5, 3, 6], "
					+ "[2, 3, 5, 3, 6], [2, 6, 5, 3, 6], "
					+ "[3, 3, 5, 3, 6], [4, 3, 5, 3, 6], [5, 9, 5, 3, 6]]}",
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
			testEquality("[[2, 3, 5, 3, 6], [3, 3, 5, 3, 6], [4, 3, 5, 3, 6], "
					+ "[5, 9, 5, 3, 6], [1, 3, 5, 3, 6], [2, 6, 5, 3, 6]]", 
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
			testEquality("[[1, 3, 5, 3, 6], [2, 3, 5, 3, 6], [2, 6, 5, 3, 6], "
					+ "[3, 3, 5, 3, 6], [4, 3, 5, 3, 6], [5, 9, 5, 3, 6]]",
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
		BinarySearchTree<Parent> t = new BinarySearchTree<>();
		for(Parent p : testList) t.add(p);
		try {
			++testNum;		
			actual = ""+t.inorderList();
			testEquality("[[1, 3, 5, 3, 6], [2, 3, 5, 3, 6], [2, 6, 5, 3, 6], "
					+ "[3, 3, 5, 3, 6], [4, 3, 5, 3, 6], [5, 9, 5, 3, 6], "
					+ "[2, 4, 5, 3, 6], [6, 2, 5, 3, 0], [7, 8, 5, 3, 6], "
					+ "[9, 1, 5, 3, 6]]",
					actual, "TEST " + testNum, 2);
		} catch (Exception e) {
			++numWrong[2];
			out.println("TEST " + testNum + " FAILED: Factory.sort(testList.stream())");
			out.println("ERROR MESSAGE SHOWN BELOW");
			e.printStackTrace(out);			
		}

		BinarySearchTree<Parent> t1 = new BinarySearchTree<>();
		for(Parent p : testListOrdered) t1.add(p);
		try {
			++testNum;		
			actual = ""+t.inorderList();
			testEquality("[[1, 3, 5, 3, 6], [2, 3, 5, 3, 6], [2, 6, 5, 3, 6], "
					+ "[3, 3, 5, 3, 6], [4, 3, 5, 3, 6], [5, 9, 5, 3, 6], "
					+ "[2, 4, 5, 3, 6], [6, 2, 5, 3, 0], [7, 8, 5, 3, 6], "
					+ "[9, 1, 5, 3, 6]]",
					actual, "TEST " + testNum, 2);
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