package assignment06;

import org.junit.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.Assert;
import java.util.Comparator;
import org.junit.runners.MethodSorters;
import java.util.Map;
import java.util.HashMap;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment06Tests {
    @Test
    public void countryTestEnumOrder() {
        boolean africaBeforeEurope =
                  Continent.AFRICA.ordinal() < Continent.EUROPE.ordinal();
        boolean europeBeforeOceania =
                 Continent.EUROPE.ordinal() < Continent.OCEANIA.ordinal();

        Assert.assertTrue(africaBeforeEurope && europeBeforeOceania);
    }

    @Test
    public void countryTestSort() {
        Comparator<Country> comp = Country.contThenNameComp();
        List<Country> countries = new ArrayList<>();
        Country country1 = new Country("C", 0.0, 0.0, 0, 0, Continent.AFRICA);
        Country country2 = new Country("B", 0.0, 0.0, 0, 0, Continent.OCEANIA);
        Country country3 = new Country("A", 0.0, 0.0, 0, 0, Continent.AFRICA);

        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        countries.sort(comp);

        Assert.assertTrue(countries.get(0) == country3);
        Assert.assertTrue(countries.get(1) == country1);
        Assert.assertTrue(countries.get(2) == country2);
    }

    @Test
    public void removeTest1() {
        Comparator<Integer> comp = (Integer i1, Integer i2)->i1.compareTo(i2);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(comp);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);

        Assert.assertTrue(tree.getElements().size() > 0);

        tree = tree.remove(4);
        tree = tree.remove(3);

        Assert.assertTrue(tree == tree.remove(2));
    }

    @Test
    public void removeTest2() {
        Comparator<Integer> comp = (Integer i1, Integer i2)->i1.compareTo(i2);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(comp);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        Assert.assertTrue(tree.remove(1) == tree);
    }

    @Test
    public void removeTest3() {
        Comparator<Integer> comp = (Integer i1, Integer i2)->i1.compareTo(i2);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(comp);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        Assert.assertTrue(tree.remove(3) == tree);
    }

    @Test
    public void removeTest4() {
        Comparator<Integer> comp = (Integer i1, Integer i2)->i1.compareTo(i2);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(comp);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        Assert.assertTrue(tree.remove(1).find(2).equals(2));
    }

    @Test
    public void removeTestCount1() {
        Comparator<Integer> comp = (Integer i1, Integer i2)->i1.compareTo(i2);
        BinarySearchTreeCount<Integer> tree = new BinarySearchTreeCount<>(comp);
        tree.insert(1);
        tree.insert(1);

        Assert.assertTrue(tree.remove(1) == tree);
    }

    @Test
    public void removeTestCount2() {
        Comparator<Integer> comp = (Integer i1, Integer i2)->i1.compareTo(i2);
        BinarySearchTreeCount<Integer> tree = new BinarySearchTreeCount<>(comp);
        tree.insert(2);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        Assert.assertTrue(tree.remove(2) == tree);
    }

    @Test
    public void removeTestCount3() {
        Comparator<Integer> comp = (Integer i1, Integer i2)->i1.compareTo(i2);
        BinarySearchTreeCount<Integer> tree = new BinarySearchTreeCount<>(comp);
        tree.insert(1);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);

        Assert.assertTrue(tree.remove(1) == tree);
    }

    @Test
    public void removeTestCount4() {
        Comparator<Integer> comp = (Integer i1, Integer i2)->i1.compareTo(i2);
        BinarySearchTreeCount<Integer> tree = new BinarySearchTreeCount<>(comp);
        tree.insert(-1);
        tree.insert(-2);

        Assert.assertTrue(tree.remove(-1).getElements().get(0).equals(-2));
    }
}
