package assignment05;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CompareTester {
  public static void main(String[] args) {

    System.out.println("--------------------------------------------------");
    System.out.println("---------Testing TwoDimNumArr's compare()---------");
    System.out.println("--------------------------------------------------");

    TwoDimNumArr testArr = null;

    try {
      testArr = new TwoDimNumArr("original.txt");
    }
    catch(FileNotFoundException e) {
      System.out.println(e);
      System.exit(1);
    }
    finally {}

    boolean shouldBeTrue = false;
    try {
      shouldBeTrue = testArr.compare("sameAsOriginal.txt");
    }
    catch(FileNotFoundException e) {
      System.out.println("test failed since FileNotFoundException should not occur: -0.5");
    }
    finally {}

    if(!shouldBeTrue) {
      System.out.println("compare() should return true since test file is same used to create TwoDimNumArr object but returned false: -0.5");
    }
    else {
      System.out.println("compare() passed test where elements in file did match those in the TwoDimNumArr object.");
    }

    boolean shouldBeFalse = true;
    try {
      shouldBeFalse = testArr.compare("notSameAsOriginal.txt");
    }
    catch(FileNotFoundException e) {
      System.out.println("test failed since FileNotFoundException should not occur: -0.5");
    }
    finally {}

    if(shouldBeFalse) {
      System.out.println("compare() should return false since test file is same used to create TwoDimNumArr object but returned true: -0.5");
    }
    else {
      System.out.println("compare() passed test where elements in file did not match those in the TwoDimNumArr object.");
    }

    System.out.println("--------------------------------------------------");
    System.out.println("------------Testing Location's lessEQ()-----------");
    System.out.println("--------------------------------------------------");

    Locations testLocations = new Locations(new int[] {100, 10000, 150});

    if(Arrays.equals(new int[] {0,1}, testLocations.lessEQ(new int[] {1000, 10001, 140}))) {
      System.out.println("Locations lessEQ() test with non-empty values passed.");
    }
    else {
      System.out.println("Locations lessEQ() test with non-empty values failed.");
    }

    System.out.println("--------------------------------------------------");
    System.out.println("----------Testing DiaryEvent's earliest()---------");
    System.out.println("--------------------------------------------------");

    List eventList = new ArrayList<>();
    eventList.add(new DiaryEvent("not earliest event", 2018, 1, 1, 4, 1, 9));
    eventList.add(new DiaryEvent("not earliest event", 2017, 1, 1, 4, 1, 9));
    eventList.add(new DiaryEvent("earliest event", 2016, 5, 1, 4, 1, 9));
    eventList.add(new DiaryEvent("not earliest event", 2016, 6, 1, 4, 1, 9));

    System.out.println(DiaryEvent.earliest(eventList));
  }
}
