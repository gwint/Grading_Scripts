package assignment07;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestRule;
import org.junit.runner.Description;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Map;
import java.util.Random; 

import java.math.BigInteger; 

public class Assignment07Tester {
	
	FileWriter fw;	

	@Rule
	public TestWatcher watchman= new TestWatcher() {

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
	public void setUp() throws Exception {

		fw = new FileWriter("temp.txt", true); //write a token in temp file

	}

	//Checks if file contains for loops. If so, no points.
	public boolean checkForLoops(String filename){
		String content = "";
	    try{
	        content = new String (
	        	Files.readAllBytes(Paths.get(filename)));
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("TROUBLE READING FILE " + filename);
	    }
		return content.contains("for(") || content.contains("while(")
			|| content.contains("for (") || content.contains("while (");
	}


	@Test
	public void testSelectFrom1() {

		//Check if output is correct
		List<String> in = new ArrayList<>(
			Arrays.asList("Alpha", "Beta", "Gamma", "delta", 
				null, "Binghamton", "", "academic", "business"));
		List<String> out = Assignment7.selectFrom(in, 'B');
		assertTrue(out.contains("Beta") && out.contains("Binghamton") 
			&& out.contains("business") && out.size() == 3);

		assertFalse(checkForLoops("Assignment7.java"));

	}


	@Test
	public void testSelectFrom2() {

		//Check if output is correct
		List<String> in = new ArrayList<>(
			Arrays.asList("Alpha", "Beta", "Gamma", "delta", 
				null, "Binghamton", "", "academic", "business"));
		List<String> out = Assignment7.selectFrom(in, 'b');
		assertTrue(out.contains("Beta") && out.contains("Binghamton") 
			&& out.contains("business") && out.size() == 3);

		assertFalse(checkForLoops("Assignment7.java"));

	}


	@Test
	public void testGroupFirstLetter1(){

		List<String> in = new ArrayList<>(
			Arrays.asList("How", "Wood", "could",
				"a", "wood", "Chuck", "chuck"));
		Map<Character, List<String>> out = Assignment7.groupFirstLetter(in);

		if(out.containsKey('A')){
			assertTrue(out.get('A').size() == 1 && out.get('A').contains("a"));
		}
		else{
			assertTrue(out.get('a').size() == 1 && out.get('a').contains("a"));
		}

		if(out.containsKey('H')){
			assertTrue(out.get('H').size() == 1 && out.get('H').contains("How"));
		}else{
			assertTrue(out.get('h').size() == 1 && out.get('h').contains("How"));
		}

		if(out.containsKey('W')){
			assertTrue(out.get('W').size() == 2 && out.get('W').contains("Wood")
				&& out.get('W').contains("wood"));
		}else{
			assertTrue(out.get('w').size() == 2 && out.get('w').contains("Wood")
				&& out.get('w').contains("wood"));
		}

		if(out.containsKey('C')){
			assertTrue(out.get('C').size() == 3 && out.get('C').contains("could")
				&& out.get('C').contains("Chuck") && out.get('C').contains("chuck"));
		}else{
			assertTrue(out.get('c').size() == 3 && out.get('c').contains("could")
				&& out.get('c').contains("Chuck") && out.get('c').contains("chuck"));
		}

		//There should be 4 keys in total
		assertTrue(out.keySet().size() == 4);

		assertFalse(checkForLoops("Assignment7.java"));

	}


	@Test
	public void testGroupFirstLetter2(){

		List<String> in = new ArrayList<>(
			Arrays.asList("", "Dave", "d", null, "", null));
		Map<Character, List<String>> out = Assignment7.groupFirstLetter(in);

		if(out.containsKey('D')){
			assertTrue(out.get('D').size() == 2 && out.get('D').contains("Dave")
				&& out.get('D').contains("d"));
		}else{
			assertTrue(out.get('d').size() == 2 && out.get('d').contains("Dave")
				&& out.get('d').contains("d"));
		}

		//There should be 1 key in total
		assertTrue(out.keySet().size() == 1);

		assertFalse(checkForLoops("Assignment7.java"));

	}

	@Test
	public void testGroupByContinent1(){

		try {
			String dataPath = "/home/mllab/Desktop/CS140/Grading_Scripts/Testers/Assignments/CountryData.txt";

			UNplusVaticanCity test = new UNplusVaticanCity(dataPath);
			List<Country> countries = test.getCountries();

			Map<Continent, List<Country>> map = test.groupByContinent();

			//We have 6 continents
			assertTrue(map.keySet().size() == 6);

			//Ensure 5 random countries are associated with correct keys
			Random rand = new Random();

			for(int i = 0; i < 5; i++){

        		Country rand_country = countries.get(rand.nextInt(countries.size()));
        		Continent cont = rand_country.getCont();

        		List<Country> possible_countries = map.get(cont);
        		boolean foundInMap = false;

        		for(Country c : possible_countries){
        			if(c.getName().equals(rand_country.getName())){
        				foundInMap = true;
        			}
        		}

        		assertTrue(foundInMap); 
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@Test //try another 10 random contries
	public void testGroupByContinent2(){

		try {
			String dataPath = "/home/mllab/Desktop/CS140/Grading_Scripts/Testers/Assignments/CountryData.txt";

			UNplusVaticanCity test = new UNplusVaticanCity(dataPath);
			List<Country> countries = test.getCountries();

			Map<Continent, List<Country>> map = test.groupByContinent();

			//We have 6 continents
			assertTrue(map.keySet().size() == 6);

			//Ensure 10 random countries are associated with correct keys
			Random rand = new Random();

			for(int i = 0; i < 10; i++){

        		Country rand_country = countries.get(rand.nextInt(countries.size()));
        		Continent cont = rand_country.getCont();

        		List<Country> possible_countries = map.get(cont);
        		boolean foundInMap = false;

        		for(Country c : possible_countries){
        			if(c.getName().equals(rand_country.getName())){
        				foundInMap = true;
        			}
        		}

        		assertTrue(foundInMap); 
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	

	@Test
	public void testPopulationByContinent1(){

		try {
			String dataPath = "/home/mllab/Desktop/CS140/Grading_Scripts/Testers/Assignments/CountryData.txt";

			UNplusVaticanCity test = new UNplusVaticanCity(dataPath);

			Map<Continent, Long> map = test.populationByContinent();

			assertTrue(map.get(Continent.SOUTH_AMERICA) == 426905237l);
			assertTrue(map.get(Continent.NORTH_AMERICA) == 583044898l);
			assertTrue(map.get(Continent.EUROPE) == 619172062l);
			assertTrue(map.get(Continent.ASIA) == 4692210770l);			
			assertTrue(map.get(Continent.AFRICA) == 1306555850l);
			assertTrue(map.get(Continent.OCEANIA) == 41254241l);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test //test this twice to add more weight to grade
	public void testPopulationByContinent2(){

		try {
			String dataPath = "/home/mllab/Desktop/CS140/Grading_Scripts/Testers/Assignments/CountryData.txt";

			UNplusVaticanCity test = new UNplusVaticanCity(dataPath);

			Map<Continent, Long> map = test.populationByContinent();

			assertTrue(map.get(Continent.SOUTH_AMERICA) == 426905237l);
			assertTrue(map.get(Continent.NORTH_AMERICA) == 583044898l);
			assertTrue(map.get(Continent.EUROPE) == 619172062l);
			assertTrue(map.get(Continent.ASIA) == 4692210770l);			
			assertTrue(map.get(Continent.AFRICA) == 1306555850l);
			assertTrue(map.get(Continent.OCEANIA) == 41254241l);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testFactorial1(){


		List<BigInteger> factorials = Assignment7.factorial(15);

		BigInteger five_factorial = new BigInteger("120"); 
        BigInteger ten_factorial = new BigInteger("3628800"); 

		//check 5! and 10!
		assertTrue(factorials.get(5).compareTo(five_factorial) == 0);
		assertTrue(factorials.get(10).compareTo(ten_factorial) == 0);

		assertFalse(checkForLoops("Assignment7.java"));

	}

	@Test
	public void testFactorial2(){


		List<BigInteger> factorials = Assignment7.factorial(100);

		//Calculated result from https://www.nitrxgen.net/factorialdb/
		BigInteger eighty_factorial = new BigInteger("71569457046263802294811533723186532165584657342365752577109445058227039255480148842668944867280814080000000000000000000"); 

		//check 80!
		assertTrue(factorials.get(80).compareTo(eighty_factorial) == 0);

		assertFalse(checkForLoops("Assignment7.java"));

	}

	@Test
	public void testMatcher1(){

		Stream<Integer> stream = Stream.of(5,7,9,11,13,14,21,28,35,42,49,56,63,70,71);
		Predicate<Integer> p0 = n -> n > 10; //greater than 10
		Predicate<Integer> p1 = n -> (n%2) == 0; //even
		Predicate<Integer> p2 = n -> n < 64; //less than 64

		List<Integer> out = Matcher.matchAll(stream, p0, p1, p2);
		assertTrue(out.size() == 4);
		assertTrue(out.contains(14) && out.contains(28) && out.contains(42) 
			&& out.contains(56));

		//assertFalse(checkForLoops("Matcher.java"));

	}

	@Test
	public void testMatcher2(){

		Stream<Integer> stream = Stream.of(4,5,9,13,17,191,198);
		Predicate<Integer> p0 = n -> n != 17; //dont return 17
		Predicate<Integer> p1 = n -> Infinite.isPrime(n); //must be prime
		List<Integer> out = Matcher.matchAll(stream, p0, p1);
		assertTrue(out.size() == 3);
		assertTrue(out.contains(5) && out.contains(13) && out.contains(191));

		//assertFalse(checkForLoops("Matcher.java"));

	}



}