package lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class Employee {
  private String name;
  private int age;

  public Employee(String n, int a){
    name = n;
    age = a;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString(){
    return name + "(" + age + ")";
  }
}

class Department {
  private String departmentName;
  private List<Employee> employees;

  public Department(String n) {
    departmentName = n;
    employees = new ArrayList<>();
  }

  public void addEmployee(Employee e){
    employees.add(e);
  }

  public String getDepartmentName(){
    return departmentName;
  }

  public List<Employee> getEmployees(){
    return employees;
  }

  public String toString(){
    return employees.toString();
  }
}


public class Lab10Tester {
  private static List<Department> departments = new ArrayList<>();
  static {
    Employee john = new Employee("John Doe", 30);
    Employee jane = new Employee("Jane Deer", 25);
    Employee jack = new Employee("Jack Hill", 40);
    Employee snow = new Employee("Snow White", 22);
    Employee jared = new Employee("Jared Miller", 60);
    Employee jeff = new Employee("Jeff Jackson", 27);
    Employee gerald = new Employee("Gerald House", 15);
    Employee mary = new Employee("Mary Lou", 23);

    Department hr = new Department("Human Resources");
    hr.addEmployee(jane);
    hr.addEmployee(jack);
    hr.addEmployee(snow);
    Department accounting = new Department("Accounting");
    accounting.addEmployee(john);
    accounting.addEmployee(jared);
    accounting.addEmployee(jeff);
    accounting.addEmployee(gerald);
    accounting.addEmployee(mary);

    departments.add(hr);
    departments.add(accounting);
  }

  public static void main(String[] args) {
    System.out.println("**************************************************");
    System.out.println("*************grabBingoNums() tests****************");
    System.out.println("**************************************************");

    try {
      Class streamClass = Class.forName("lab10.Streams");
      try {
        Method grabBingoNumsMethod = streamClass.getMethod("grabBingoNums",
                                                          String.class);
        /* B test */
        try {
          List<String> bRes =
             (List<String>) grabBingoNumsMethod.invoke(null, "B");
          List<String> bExpected = Arrays.asList("B12","B6");
          if(!bRes.equals(bExpected)) {
            System.out.println(
              String.format("Expected %s as bingo numbers, but %s was returned: -0.3",
                            bExpected.toString(), bRes.toString()));
          }
        }
        catch(IllegalAccessException e) {
          System.out.println("Error getting B bingo numbers: -0.3");
          System.exit(1);
        }
        catch(IllegalArgumentException e) {
          System.out.println("Error getting B bingo numbers: -0.3");
          System.exit(1);
        }
        catch(InvocationTargetException e) {
          System.out.println("Error getting B bingo numbers: -0.3");
          System.exit(1);
        }
        catch(Exception e) {
          System.out.println("Error getting B bingo numbers: -0.3");
          System.exit(1);
        }

        /* I test */
        try {
          List<String> iRes =
             (List<String>) grabBingoNumsMethod.invoke(null, "I");
          List<String> iExpected = Arrays.asList("I17","I26","I29");
          if(!iRes.equals(iExpected)) {
            System.out.println(
              String.format("Expected %s as bingo numbers, but %s was returned: -0.3",
                            iExpected.toString(), iRes.toString()));
          }
        }
        catch(IllegalAccessException e) {
          System.out.println("Error getting I bingo numbers: -0.3");
          System.exit(1);
        }
        catch(IllegalArgumentException e) {
          System.out.println("Error getting I bingo numbers: -0.3");
          System.exit(1);
        }
        catch(InvocationTargetException e) {
          System.out.println("Error getting I bingo numbers: -0.3");
          System.exit(1);
        }
        catch(Exception e) {
          System.out.println("Error getting I bingo numbers: -0.3");
          System.exit(1);
        }

        /* N test */
        try {
          List<String> nRes =
             (List<String>) grabBingoNumsMethod.invoke(null, "N");
          List<String> nExpected = Arrays.asList("N36","N40");
          if(!nRes.equals(nExpected)) {
            System.out.println(
              String.format("Expected %s as bingo numbers, but %s was returned: -0.3",
                            nExpected.toString(), nRes.toString()));
          }
        }
        catch(IllegalAccessException e) {
          System.out.println("Error getting N bingo numbers: -0.3");
          System.exit(1);
        }
        catch(IllegalArgumentException e) {
          System.out.println("Error getting N bingo numbers: -0.3");
          System.exit(1);
        }
        catch(InvocationTargetException e) {
          System.out.println("Error getting N bingo numbers: -0.3");
          System.exit(1);
        }
        catch(Exception e) {
          System.out.println("Error getting N bingo numbers: -0.3");
          System.exit(1);
        }

        /* G test */
        try {
          List<String> gRes =
             (List<String>) grabBingoNumsMethod.invoke(null, "G");
          List<String> gExpected = Arrays.asList("G49","G50","G53","G60","G64");
          if(!gRes.equals(gExpected)) {
            System.out.println(
              String.format("Expected %s as bingo numbers, but %s was returned: -0.3",
                            gExpected.toString(), gRes.toString()));
          }
        }
        catch(IllegalAccessException e) {
          System.out.println("Error getting G bingo numbers: -0.3");
          System.exit(1);
        }
        catch(IllegalArgumentException e) {
          System.out.println("Error getting G bingo numbers: -0.3");
          System.exit(1);
        }
        catch(InvocationTargetException e) {
          System.out.println("Error getting G bingo numbers: -0.3");
          System.exit(1);
        }
        catch(Exception e) {
          System.out.println("Error getting G bingo numbers: -0.3");
          System.exit(1);
        }

        /* O test */
        try {
          List<String> oRes =
             (List<String>) grabBingoNumsMethod.invoke(null, "O");
          List<String> oExpected = Arrays.asList("O71");
          if(!oRes.equals(oExpected)) {
            System.out.println(
              String.format("Expected %s as bingo numbers, but %s was returned: -0.3",
                          oExpected.toString(), oRes.toString()));
          }
        }
        catch(IllegalAccessException e) {
          System.out.println("Error getting O bingo numbers: -0.3");
          System.exit(1);
        }
        catch(IllegalArgumentException e) {
          System.out.println("Error getting O bingo numbers: -0.3");
          System.exit(1);
        }
        catch(InvocationTargetException e) {
          System.out.println("Error getting O bingo numbers: -0.3");
          System.exit(1);
        }
        catch(Exception e) {
          System.out.println("Error getting O bingo numbers: -0.3");
          System.exit(1);
        }

      }
      catch(NoSuchMethodException e) {
        System.out.println("grabBingoNums() method not found: -2");
        System.exit(1);
      }
      catch(SecurityException e) {
        System.out.println("Security Issue probably related to access modifier");
        System.exit(1);
      }

      System.out.println("**************************************************");
      System.out.println("***************extractNums() tests****************");
      System.out.println("**************************************************");

      try {
        Method extractNumsMethod = streamClass.getMethod("extractNums");
        try {
          List<Integer> nums = (List<Integer>) extractNumsMethod.invoke(null);
          List<Integer> expected =
             Arrays.asList(40,36,12,6,49,53,60,50,64,26,17,29,71);
          if(!nums.equals(expected)) {
            System.out.println(
              String.format(
               "Expected %s as the bingo numbers, but %s was returned: -1.5",
               expected.toString(), nums.toString()));
          }
        }
        catch(IllegalAccessException e) {
          System.out.println("Error extracting bingo numbers: -1.5");
          System.exit(1);
        }
        catch(IllegalArgumentException e) {
          System.out.println("Error extracting bingo numbers: -1.5");
          System.exit(1);
        }
        catch(InvocationTargetException e) {
          System.out.println("Error extracting bingo numbers: -1.5");
          System.exit(1);
        }
        catch(Exception e) {
          System.out.println("Error extracting bingo numbers: -1.5");
          System.exit(1);
        }

      }
      catch(NoSuchMethodException e) {
        System.out.println("grabBingoNums() method not found: -2");
        System.exit(1);
      }
      catch(SecurityException e) {
        System.out.println("Security Issue probably related to access modifier");
        System.exit(1);
      }

      System.out.println("**************************************************");
      System.out.println("*****************sumLists() tests*****************");
      System.out.println("**************************************************");

      List<List<Integer>> lists = new ArrayList<>();
      lists.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
      lists.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
      lists.add(new ArrayList<Integer>(Arrays.asList(7,8,9, 10)));

      try {
        Method sumListsMethod =
                      streamClass.getMethod("sumLists", List.class);
        try {
          int sum = (Integer) sumListsMethod.invoke(null, lists);
          if(sum != 55) {
            System.out.println(
              String.format("Expected 55, but %d was returned: -1.5", sum));
          }
        }
        catch(IllegalAccessException e) {
          System.out.println("Error summing lists: -1.5");
          System.exit(1);
        }
        catch(IllegalArgumentException e) {
          System.out.println("Error summing lists: -1.5");
          System.exit(1);
        }
        catch(InvocationTargetException e) {
          System.out.println("Error summing lists: -1.5");
          System.exit(1);
        }
        catch(Exception e) {
          System.out.println("Error summing lists: -1.5");
          System.exit(1);
        }
      }
      catch(NoSuchMethodException e) {
        System.out.println("sumLists() method not found: -2");
        System.exit(1);
      }
      catch(SecurityException e) {
        System.out.println("Security Issue probably related to access modifier");
        System.exit(1);
      }

      System.out.println("**************************************************");
      System.out.println("*****************countOdd() tests*****************");
      System.out.println("**************************************************");

      try {
        Streams.countOdd(new int[]{1,2,3,4,5,6,7,8,9});
        Method countOddMethod =
                      streamClass.getMethod("countOdd",
                                            int[].class);
        try {
          long numOdd = (Long) countOddMethod.invoke(null,
                                               new int[]{1,2,3,4,5,6,7,8,9});
          if(numOdd != 5) {
            System.out.println(
              String.format("Expected 5, but %d was returned: -1.5", numOdd));
          }
        }
        catch(IllegalAccessException e) {
          System.out.println("Error 1 counting odds: -1.5");
        }
        catch(IllegalArgumentException e) {
          System.out.println("Error 2 counting odds: -1.5");
        }
        catch(InvocationTargetException e) {
          System.out.println("Error 3 counting odds: -1.5");
        }
        catch(Exception e) {
          System.out.println("Error 4 counting odds: -1.5");
          e.printStackTrace();
        }
      }
      catch(NoSuchMethodException e) {
        System.out.println("numOdds() method not found: -2");
      }
      catch(SecurityException e) {
        System.out.println("Security Issue probably related to access modifier");
      }


      System.out.println("**************************************************");
      System.out.println("***************isPalindrome() tests***************");
      System.out.println("**************************************************");
      System.out.println("If expected and actual do not match, deduct 1.5 pts");

      System.out.println("Expected:");
      System.out.println("12321");
      System.out.println("rotator");
      System.out.println("racecar");

      List<String> words = new ArrayList<>();
      words.add("12321");
      words.add("dog");
      words.add("rotator");
      words.add("racecar");
      words.add("banana");
      words.add("animal");

      System.out.println("Actual");
      Streams.printPalindromes(words);
    }
    catch(ClassNotFoundException e) {
      System.out.println("Streams class not found: -10");
      System.exit(1);
    }
  }
}
