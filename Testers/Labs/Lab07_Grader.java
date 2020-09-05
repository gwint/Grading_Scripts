package lab07;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;



public class Lab07_Grader {

	FileWriter fw;

	Animal topPredator;
	Animal primaryPredator;
	Animal unrelatedPredator;
	Animal unrelatedPredator2;
	Animal pred;
	Animal herb1;
	Animal herb2;
	Animal herb3;
	Animal herb4;
	ArrayList<Animal> list;


	@Rule
	public TestWatcher watchman = new TestWatcher() {

		@Override
		protected void failed(Throwable e, Description description) {
			try{ 
    			fw.write("FAILED ");// Write FAILED token to file for each failed test
    			fw.close();
    		}catch(Exception ex){}
  		}

		@Override
		protected void succeeded(Description description) {
			try{ 
    			fw.write("PASSED ");// Write PASSED token to file for each successful test
    			fw.close();
    		}catch(Exception ex){}
		}
	};
	
	@Before
	public void setup() throws Exception{
		fw = new FileWriter("temp.txt", true); //write a token in temp fil

		topPredator =  new Tiger("Hyena", 3, "Tony");
		primaryPredator = new Hyena("Deer", 1, "Ed");
		unrelatedPredator = new Tiger("Antelope", 4, "Troy");
		unrelatedPredator2 = new Hyena("Arbies", 1, "Dave1");
		pred = new Tiger("elk", 50, "Joe");

		herb1 = new Deer("grass", 0, "Bambi");
		herb2 = new Deer("apple", 2, "Pippin");
		herb3 = new Deer("carrot", 2, "Dave2");
		herb4 = new Deer("steroids", 9000, "Arnold");

		list = new ArrayList<Animal>();
		list.add(herb3);
		list.add(topPredator);
		list.add(unrelatedPredator);
		list.add(herb1);
		list.add(primaryPredator);
		list.add(herb4);
		list.add(pred);
	}

	@Test
	public void testTiger(){
		Animal a = new Tiger("prey", 1, "Dave");
		assertTrue(((Tiger)a).getAnimalName().equals("Tiger") &&
			((Tiger)a).getName().equals("Dave"));
	}

	@Test
	public void test01(){ 	//two carnivores where A eats B
		assertEquals(1, AnimalComparator.staticCompare(topPredator, primaryPredator));
	}
	
	@Test
	public void test02(){ 	//two carnivores where B eats A
		assertEquals(-1, AnimalComparator.staticCompare(primaryPredator, topPredator));
	}
	
	@Test
	public void test03(){ 	//two carnivores, B higher predator than A
		assertTrue(AnimalComparator.staticCompare(topPredator, unrelatedPredator) < 0);
	}

	@Test
	public void test05(){ 	//two carnivores, A and B both same predatoryLevel
		assertEquals(0, AnimalComparator.staticCompare(primaryPredator, unrelatedPredator2));
	}
	

	@Test
	public void test06(){ //two herbivores, equal agressionLevel
		assertEquals(0, AnimalComparator.staticCompare(herb3, herb2));
	}


	@Test
	public void test07(){ 	//two herbivores, A more agressive than B
		assertTrue(AnimalComparator.staticCompare(herb3, herb1) > 0);
	}


	@Test
	public void test08(){	//two herbivores, B more agressive than A
		assertTrue(AnimalComparator.staticCompare(herb1, herb2) < 0);
	}

	
	@Test
	public void test09(){	//A carnivore that eats Herbivore B
		assertEquals(1, AnimalComparator.staticCompare(primaryPredator, herb1));
	}

	
	@Test
	public void test10(){	//A carnivore unrelated to Herbivore B
		assertTrue(AnimalComparator.staticCompare(unrelatedPredator2, herb3) > 0);
	}
	
	@Test
	public void test11(){	//A herbivore which is eaten by Carnivore B
		assertTrue(AnimalComparator.staticCompare(herb1, primaryPredator) < 0);
	}

	@Test
	public void test12(){	//A herbivore which is unrelated to Carnivore B
		assertTrue(AnimalComparator.staticCompare(herb1, topPredator) < 0);
	}



	//Adding this same test 4 times to count for more points. 
	//There definately exists a better way to add more weight to this.
	@Test
	public void test13(){	//sort test
		AnimalComparator.staticSortAnimals(list);

		Animal a = list.get(6);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Joe"));

		a = list.get(5);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Troy"));

		a = list.get(4);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Tony"));

		a = list.get(3);
		assertTrue(a instanceof Hyena);
		assertTrue(((Hyena)a).getName().equals("Ed"));

		a = list.get(2);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Arnold"));

		a = list.get(1);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Dave2"));

		a = list.get(0);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Bambi"));

	}


	@Test
	public void test14(){	//sort test
		AnimalComparator.staticSortAnimals(list);

		Animal a = list.get(6);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Joe"));

		a = list.get(5);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Troy"));

		a = list.get(4);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Tony"));

		a = list.get(3);
		assertTrue(a instanceof Hyena);
		assertTrue(((Hyena)a).getName().equals("Ed"));

		a = list.get(2);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Arnold"));

		a = list.get(1);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Dave2"));

		a = list.get(0);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Bambi"));

	}

	@Test
	public void test15(){	//sort test
		AnimalComparator.staticSortAnimals(list);

		Animal a = list.get(6);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Joe"));

		a = list.get(5);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Troy"));

		a = list.get(4);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Tony"));

		a = list.get(3);
		assertTrue(a instanceof Hyena);
		assertTrue(((Hyena)a).getName().equals("Ed"));

		a = list.get(2);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Arnold"));

		a = list.get(1);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Dave2"));

		a = list.get(0);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Bambi"));
	}

	@Test
	public void test16(){	//sort test
		AnimalComparator.staticSortAnimals(list);

		Animal a = list.get(6);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Joe"));

		a = list.get(5);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Troy"));

		a = list.get(4);
		assertTrue(a instanceof Tiger);
		assertTrue(((Tiger)a).getName().equals("Tony"));

		a = list.get(3);
		assertTrue(a instanceof Hyena);
		assertTrue(((Hyena)a).getName().equals("Ed"));

		a = list.get(2);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Arnold"));

		a = list.get(1);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Dave2"));

		a = list.get(0);
		assertTrue(a instanceof Deer);
		assertTrue(((Deer)a).getName().equals("Bambi"));

	}

	@Test
	public void lambdaTest1(){
		Comparator<Animal> animalComp = Animal.getComp();
		assertEquals(-1, animalComp.compare(primaryPredator, topPredator));
	}
	@Test
	public void lambdaTest2(){
		Comparator<Animal> animalComp = Animal.getComp();
		assertEquals(1, animalComp.compare(primaryPredator, herb1));
	}

}
