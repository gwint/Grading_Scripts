package assignment04;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Assn05Tester {
  public static void testReadString() {
    String testString = "   10  8    1       92";
    int[] expectedResult = new int[] {10, 8, 1, 92};
    int[] resultantIntArr = NumberReader.readString(testString);
    if(Arrays.equals(expectedResult, resultantIntArr)) {
      System.out.printf("readString() passed test 1 with input \"%s\"\n", testString);
      if(Arrays.equals(new int[] {}, NumberReader.readString(""))) {
        System.out.println("readString() passed test 2 with input \"\"");
      }
      else {
        System.out.println("readString() faiiled test 2 with input \"\": -0.50");
      }
    }
    else {
      System.out.printf("readString() failed test 1 with input \"%s\": -0.50\n",
                        testString);
    }
  }

  public static void testReadArray() {
    String testFileName = "assn05TestFile.txt";
    int[][] expectedResultArr = new int[][] {{1, 2, 3, 5}, {11}, {}, {100}};
    try {
      int[][] actualResultArr = NumberReader.readArray(testFileName);
      for(int i = 0; i < actualResultArr.length; i++) {
        if(!Arrays.equals(actualResultArr[i], expectedResultArr[i])) {
          System.out.printf("readArray() test failed [%s != %s]: -0.50\n",
                            Arrays.toString(actualResultArr[i]),
                            Arrays.toString(expectedResultArr[i]));
          return;
        }
      }
      System.out.printf("readArray() test passed with input file %s\n",
                        testFileName);

    }
    catch(Exception e) {
      System.out.printf("readArray test 1 with input file %s failed: -0.50",
                        testFileName);
      e.printStackTrace();
    }
  }

  public static void testReadString2() {
    String testString = "   10  8    1       92";
    List<Integer> expectedResult =
            new ArrayList<>(Arrays.asList(10, 8, 1, 92));
    List<Integer> resultantIntArr = NumberReader2.readString2(testString);
    if(expectedResult.equals(resultantIntArr)) {
      System.out.printf("readString2() passed test 1 with input \"%s\"\n", testString);
      if(NumberReader2.readString2("").equals(new ArrayList<Integer>())) {
        System.out.println("readString2() passed test 2 with input \"\"");
      }
      else {
        System.out.println("readString2() faiiled test 2 with input \"\": -0.50");
      }
    }
    else {
      System.out.printf("readString2() failed test 1 with input \"%s\": -0.50\n",
                        testString);
    }
  }

  public static void testReadList2() {
    String testFileName = "assn05TestFile.txt";
    List<List<Integer>> expectedResultList =
              new ArrayList<List<Integer>>(Arrays.asList(
                              Arrays.asList(1, 2, 3, 5),
                              Arrays.asList(11),
                              Arrays.asList(),
                              Arrays.asList(100)));
    try {
      List<List<Integer>> actualResultList =
                                NumberReader2.readList2(testFileName);
      for(int i = 0; i < actualResultList.size(); i++) {
        if(!actualResultList.get(i).equals(expectedResultList.get(i))) {
          System.out.printf("readList2() test failed [%s != %s]: -0.75\n",
                            actualResultList.get(i),
                            expectedResultList.get(i));
          return;
        }
      }
      System.out.printf("readList2() test passed with input file %s\n",
                        testFileName);

    }
    catch(Exception e) {
      System.out.printf("readList2() test 1 with input file %s failed: -0.75",
                        testFileName);
      e.printStackTrace();
    }
  }

  public static void testAddCourse() {
    try {
      Student testStudent = new Student("Test");
      testStudent.addCourse(Courses.CS101);
      if(testStudent.getTaken().equals(new HashSet<Courses>(
                                       Arrays.asList(Courses.CS101)))) {
        System.out.println("addCourse() test passed");
      }
      else {
        System.out.println("addCourse() test failed: -0.50");
      }
    }
    catch(Exception e) {
      System.out.println("Error encountered during addCourse() test: -0.50");
    }
  }

  public static void testNeedToTakeBefore() {
    try {
      Student testStudent = new Student("Test");
      testStudent.addCourse(Courses.CS110);
      Set<Courses> expectedPrereqsNeeded =
                  new HashSet<>(Arrays.asList(Courses.CS140, Courses.CS120));
      Set<Courses> actualPrereqsNeeded =
                           testStudent.needToTakeBefore(Courses.CS240);
      if(expectedPrereqsNeeded.equals(actualPrereqsNeeded)) {
        System.out.println("needToTakeBefore() test passed");
      }
      else {
        System.out.println("needToTakeBefore() test failed: -1");
      }
    }
    catch(Exception e) {
      System.out.println("needToTakeBefore() test failed due to error: -1");
    }
  }

  public static void main(String[] args) {
    // Testing part 1
    System.out.println("******************************************************");
    System.out.println("********************Testing Part 1********************");
    System.out.println("******************************************************");
    System.out.println();

    testReadString();
    testReadArray();
    testReadString2();
    testReadList2();

    System.out.println();

    // Testing part 2
    System.out.println("******************************************************");
    System.out.println("********************Testing Part 2********************");
    System.out.println("******************************************************");
    System.out.println();

    testAddCourse();
    testNeedToTakeBefore();
  }
}
