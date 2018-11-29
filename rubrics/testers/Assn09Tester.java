package assignment09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import java.util.Comparator;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Assn09Tester {
  public static void main(String[] args) {

    System.out.println("****************************************");
    System.out.println("***************subStrs()****************");
    System.out.println("****************************************");
    System.out.println(subStrs("pizza"));

    System.out.println("****************************************");
    System.out.println("**************subStr1()*****************");
    System.out.println("****************************************");
    System.out.println(subStr1("pizza"));

    System.out.println("****************************************");
    System.out.println("************NaiveQuickSort**************");
    System.out.println("****************************************");

    Sorter sorter1 = new InsertionSorter();
    Sorter sorter2 = new NaiveQuickSort();

    JFrame frame = new JFrame();

    Random r = new Random();
    final int FACTOR = 5000;
    double[] x = {0,1,2,3,4,5,6,7,8,9};
    double[] y1 = new double[x.length];
    double[] y2 = new double[x.length];
    List<Double> sample;
    List<Double> copy;
    for (int i = 1; i < x.length; i++) {
      sample = new ArrayList<Double>();
      for(int j = 0; j < FACTOR*i; j++) {
        sample.add(r.nextDouble());
      }
      copy = new ArrayList<>();
      copy.addAll(sample);

      y1[i] = sorter1.timedSort(sample);
      System.out.println(y1[i]);

      y2[i] = sorter2.timedSort(copy);
      System.out.println(y2[i]);

      System.out.println("----------------");
    }
    for(int i = 1; i < x.length; i++) {
      x[i] = 20 + 500*x[i]/x[x.length-1];
    }
    double max = y1[y1.length-1];
    max = 1 + Math.max(max, y2[y2.length-1]);
    for(int i = 0; i < y1.length; i++) {
      y1[i] = 550 - 550*y1[i]/max;
      y2[i] = 550 - 550*y2[i]/max;
    }
    frame.setSize(540, 600);
    frame.setTitle("Times");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Graph component = new Graph(x,y1,x,y2);

    frame.add(component);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    List<Double> listToSort =
              new ArrayList<>(Arrays.asList(3.,2.,10.,5.,4.));

    System.out.println(String.format("NaiveQuickSorter Result: %s\n",
                     ((NaiveQuickSort) sorter2).sort(listToSort).toString()));

    System.out.println("****************************************");
    System.out.println("***************StringTree***************");
    System.out.println("****************************************");
    var s1 = new StringTree("section_4");
    var s2 = new StringTree("section_1");
    var s3 = new StringTree("section_2");
    var s4 = new StringTree("worked_example_1");
    var s5 = new StringTree("how_to_1");
    var s6 = new StringTree("ch01");
    var s7 = new StringTree("ch02");
    var s8 = new StringTree("Sample_Code");
    s7.addSubTree(s2);
    System.out.println("s7 + s2: " + s7.listContent());
    s7.addSubTree(s3);
    System.out.println("s7 + s2 + s3: " + s7.listContent());
    s7.addSubTree(s4);
    System.out.println("s7 + s2 + s3 + s4: " + s7.listContent());
    s7.addSubTree(s5);
    System.out.println("finished s7 = s7 + s2 + s3 + s4 + s5: " + s7.listContent());
    s6.addSubTree(s1);
    System.out.println("finished s6 = s6 + s1: " + s6.listContent());
    s8.addSubTree(s6);
    System.out.println("s8 + s6: " + s8.listContent());
    s8.addSubTree(s7);
    System.out.println("finished s8 = s8 + s6 + s7: " + s8.listContent());
    s8 = s8.treeDelete("ch02");
    System.out.println(s8.listContent());
    s8 = s8.treeDelete("Sample_Code");
    System.out.println(s8.listContent());
  }
}
