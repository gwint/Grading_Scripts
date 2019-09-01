package lab09;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class DataClass {
  private int i;
  public DataClass(int val) {
    this.i = val;
  }

  public int getI() {
    return this.i;
  }

  @Override
  public String toString() {
    return String.format("%s", this.getI());
  }

  @Override
  public boolean equals(Object o) {
    return this.getI() == ((DataClass) o).getI();
  }
}

public class Lab09Tester {
  public static boolean equals(BinarySearchTree<DataClass> tree1,
                               BinarySearchTree<DataClass> tree2) {
    return false;
  }

  public static void main(String[] args) {
    /* Create Binary Tree */
    Comparator<DataClass> testComp = (i, j) -> i.getI() - j.getI();
    BinarySearchTree<DataClass> tree = new BinarySearchTree<>(testComp);
    tree.insert(new DataClass(13));
    tree.insert(new DataClass(7));
    tree.insert(new DataClass(-5));
    tree.insert(new DataClass(9));
    tree.insert(new DataClass(3));
    tree.insert(new DataClass(11));
    tree.insert(new DataClass(-3));
    tree.insert(new DataClass(15));
    tree.insert(new DataClass(14));

    /* prettyPrint() tests */
    System.out.println("****************************************");
    System.out.println("************prettyPrint()***************");
    System.out.println("****************************************");
    System.out.println("If the following do not match, subtract 2 pts");
    System.out.println("Actual:");
    tree.prettyPrint();
    System.out.println("Expected:");
    System.out.println("  -5");
    System.out.println("    -3");
    System.out.println("   3");
    System.out.println(" 7");
    System.out.println("  9");
    System.out.println("   11");
    System.out.println("13");
    System.out.println("  14");
    System.out.println(" 15");

    /* find() tests */
    System.out.println("****************************************");
    System.out.println("***************find()*******************");
    System.out.println("****************************************");

    DataClass shouldBeNull = tree.find(new DataClass(100));
    DataClass shouldBeMinus3 = tree.find(new DataClass(3));
    DataClass shouldBe13 = tree.find(new DataClass(13));
    DataClass shouldBeNull2 = tree.find(new DataClass(-10));
    DataClass shouldBe14 = tree.find(new DataClass(14));
    DataClass shouldBeNull3 = tree.find(new DataClass(16));
    DataClass shouldBe9 = tree.find(new DataClass(9));

    if(shouldBeNull != null) {
      System.out.println("Find test 1 failed: Expected null, but got " +
                         shouldBeNull.toString());
    }

    if(shouldBeMinus3 != null) {
      if(shouldBeMinus3.getI() != -3) {
        System.out.println("Find test 2 failed: Expected -3, but got " +
                           shouldBeMinus3.toString());
      }
    }

    if(shouldBe13 != null) {
      if(shouldBe13.getI() != 13) {
        System.out.println("Find test 3 failed: Expected 13 but got " +
                           shouldBe13.toString());
      }
    }

    if(shouldBeNull2 != null) {
      System.out.println("Find test 4 failed: Expected null but got " +
                         shouldBeNull2);
    }

    if(shouldBe14 != null) {
      if(shouldBe14.getI() != 14) {
        System.out.println("Find test 5 failed: Expected 14 but got " +
                           shouldBe14.toString());

      }
    }

    if(shouldBeNull3 != null) {
      System.out.println("Find test 6 failed: Expected null but got " +
                         shouldBeNull.toString());
    }

    if(shouldBe9 != null) {
      if(shouldBe9.getI() != 9) {
        System.out.println("Find test 7 failed: Expected 9 but got " +
                           shouldBe9.toString());
      }
    }

    /* getElements() tests */
    System.out.println("****************************************");
    System.out.println("************getElements()***************");
    System.out.println("****************************************");

    List<DataClass> actualResult = tree.getElements();
    if(!(actualResult.equals(
           new ArrayList<DataClass>(Arrays.asList(new DataClass(-5),
                                                  new DataClass(-3),
                                                  new DataClass(3),
                                                  new DataClass(7),
                                                  new DataClass(9),
                                                  new DataClass(11),
                                                  new DataClass(13),
                                                  new DataClass(14),
                                                  new DataClass(15)))))) {
      System.out.println("Get Elements test failed");
    }


    /* bonus tests - credit only given for 1 of the 2 */
    System.out.println("****************************************");
    System.out.println("*****************Bonus******************");
    System.out.println("****************************************");

    Class cls = tree.getClass();
    Method methods[] = cls.getMethods();
    ArrayList<String> mthNames = new ArrayList<>();

    for(Method mth : methods) {
      mthNames.add(mth.getName());
    }

    boolean firstBonusSuccessful = false;
    // Grade height() if completed
    if(mthNames.contains("height")) {
      try {
        Method heightMth = cls.getDeclaredMethod("height");
        try {
          Integer actual = ((Integer) heightMth.invoke(tree));
          if(actual.intValue() == 4) {
            firstBonusSuccessful = true;
            System.out.println(
              "Bonus: height() method implemented successfully (+2)");
          }
          else {
            System.out.println(
             "Bonus: height() implemented unsuccessfully. 4 was expected but " +
             actual.toString() + " was returned");
          }
        }
        catch(InvocationTargetException e) {
          System.err.println(e);
        }
        catch(IllegalAccessException e) {
          System.err.println(e);
        }
        finally {}

      }
      catch(NoSuchMethodException e) {
        System.err.println("height() method not found");
      }
    }

    // Grade nonLeaves() if completed
    else if(mthNames.contains("nonLeaves") && !firstBonusSuccessful) {
      System.out.println("nonLeaves() method completed.");
      try {
        Method nonLeavesMth = cls.getDeclaredMethod("nonLeaves");
        try {
          List<DataClass> actual = (List<DataClass>) nonLeavesMth.invoke(tree);
          List<DataClass> expected =
            new ArrayList<>(Arrays.asList(new DataClass(15),
                                          new DataClass(13),
                                          new DataClass(9),
                                          new DataClass(7),
                                          new DataClass(3),
                                          new DataClass(-5)));
          if(actual.equals(expected)) {
            System.out.println("Bonus: nonLeaves() implemented correctly (+2)");
          }
          else {
            System.out.println("Bonus: nonLeaves() implemented incorrectly.");
            System.out.println(String.format("Expected %s but returned %s",
                                             expected.toString(),
                                             actual.toString()));
          }
        }
        catch(InvocationTargetException e) {
          System.err.println(e);
        }
        catch(IllegalAccessException e) {
          System.err.println(e);
        }
        finally {}

      }
      catch(NoSuchMethodException e) {
        System.err.println("nonLeaves() method not found");
      }
    }
  }
}
