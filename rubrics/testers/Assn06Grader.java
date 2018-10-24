package exam01;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.MultipleFailuresError;

class Assn06Grader {
	private static double spring2018 = 10.0;
	private static double fall2017 = 10.0;
	private static double spring2017 = 10.0;

	//Spring 2018 booleans for missing methods
	//Website
	private boolean missing_websiteConstructor = false;
	private boolean missing_getUrl = false;
	private boolean missing_getPop = false;
	private boolean missing_websiteToString = false;
	private boolean missing_incrPop = false;

	//Tester
	private boolean missing_spring18Tester = false;

	//Internet
	private boolean missing_internetConstructor = false;
	private boolean missing_addSite = false;
	private boolean missing_getSites = false;
	private boolean missing_incPop = false;
	private boolean missing_profile = false;
	private boolean missing_remSite = false;

	//SnobbyInternet
	private boolean missing_snobbyInternetConstructor = false;
	private boolean missing_trim = false;

	//Spring 2018 tests
	//Website Tests
	@Test
	@DisplayName("Website constructor")
	void test001() {
		if(missing_websiteConstructor) {
			System.out.println("-0.5 Website's value constructor is missing");
			spring2018 -= 0.5;
			throw new AssertionError("missing Website's value constructor");
		}
		try {
			new Website("dummy", 1.3);
		}
		catch(Exception e){
			System.out.println("-0.5 Website's value constructor not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Website getUrl()")
	void test002() {
		if(missing_getUrl) {
			System.out.println("-0.25 Website's getUrl() is missing");
			spring2018 -= 0.25;
			throw new AssertionError("missing Website's getUrl()");
		}
		try {
			assertEquals("dummy", new Website("dummy", 1.3).getUrl());
		}
		catch(AssertionError e){
			System.out.println("-0.25 Website's getUrl() not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.25 Website's getUrl() not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Website getPop()")
	void test003() {
		if(missing_getPop) {
			System.out.println("-0.25 Website's getPop() is missing");
			spring2018 -= 0.25;
			throw new AssertionError("missing Website's getPop()");
		}
		try {
			assertEquals(1.3, new Website("dummy", 1.3).getPop(), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("-0.25 Website's getPop() not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.25 Website's getPop() not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Website toString()")
	void test004() {
		if(missing_websiteToString) {
			System.out.println("-0.5 Website's toString() is missing");
			spring2018 -= 0.5;
			throw new AssertionError("missing Website's toString()");
		}
		try {
			assertEquals("dummy(1.3)", new Website("dummy", 1.3).toString());
		}
		catch(AssertionError e){
			System.out.println("-0.5 Website's toString() not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.5;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.5 Website's toString() not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Website incrPop() over 10")
	void test005() {
		if(missing_incrPop) {
			System.out.println("-1.5 Website's incrPop() is missing");
			spring2018 -= 1.5;
			throw new AssertionError("missing Website's incrPop()");
		}
		try {
			Website w = new Website("dummy", 1.3);
			w.incrPop(9);
			assertEquals(10.0, w.getPop(), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("-0.5 Website's incrPop() fails when popularity would go over 10");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.5;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.5 Website's incrPop() fails when popularity would go over 10, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Website incrPop() under 10")
	void test006() {
		if(!missing_incrPop) {
			try {
				Website w = new Website("dummy", 1.3);
				w.incrPop(3);
				assertEquals(3.9, w.getPop(), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("-0.5 Website's incrPop() not implemented correctly");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.5;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.5 Website's incrPop() not implemented correctly, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.5;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Website incrPop() Exception test")
	void test007() {
		if(!missing_incrPop) {
			try {
				new Website("dummy", 1.3).incrPop(-1.5);
				System.out.println("-0.5 Website's incrPop() did not throw an IllegalArgumentException for negative input");
				spring2018 -= 0.5;
				throw new AssertionError("Website's incrPop() did not throw an IllegalArgumentException for negative input");
			}
			catch(IllegalArgumentException e){

			}
			catch(Exception e){
				System.out.println("-0.5 Website's incrPop() not implemented correctly, an exception that is not dealing with IllegalArguments occured");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.5;
				throw e;
			}
		}
	}

	//Spring 2018 Tester Test
	@Test
	@DisplayName("Calling main of Tester")
	void test008() {
		if(missing_spring18Tester) {
			System.out.println("-1 Tester.java is not present or does not contain a main");
			spring2018 -= 1.0;
			throw new AssertionError("spring 18 tester is missing");
		}
		try {
			//want to call the main but not have it print to the screen
			//just to make sure it was written
			PrintStream original = System.out;
			System.setOut(new PrintStream(new OutputStream() {
				public void write(int b) {
					//DO NOTHING
				}
			}));
			Tester.main(null);
			System.setOut(original);
		}
		catch(Exception e){
			System.out.println("-1.0 Tester.java is not present or does not contain a main, or has exception occuring in main");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 1.0;
			throw e;
		}
	}

	//Internet tests
	@Test
	@DisplayName("Internet's constructor")
	void test009() {
		if(missing_internetConstructor) {
			System.out.println("-0.25 Internet's value constructor is missing");
			spring2018 -= 0.25;
			throw new AssertionError("Internet's value constructor is missing");
		}
		try {
			new Internet(new ArrayList<Website>(Arrays.asList(new Website("dummy", 1.3))));
		}
		catch(Exception e){
			System.out.println("-0.25 Internet's value constructor not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Internet's getSites()")
	void test010() {
		if(missing_getSites) {
			System.out.println("-0.25 Internet's getSites() is missing");
			spring2018 -= 0.25;
			throw new AssertionError("missing Internet's getSites()");
		}
		try {
			List<Website> list = new ArrayList<Website>(Arrays.asList(new Website("dummy", 1.3)));
			Internet net = new Internet(list);
			assertEquals(list, net.getSites());		
		}
		catch(AssertionError e){
			System.out.println("-0.25 Internet's getSites() not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.25 Internet's getSites() not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Internet's addSite()")
	void test011() {
		if(missing_addSite) {
			System.out.println("-0.25 Internet's addSite() is missing");
			spring2018 -= 0.25;
			throw new AssertionError("missing Internet's addSite() constructor");
		}
		try {
			Internet net = new Internet(new ArrayList<Website>(Arrays.asList(new Website("dummy", 1.3))));
			net.addSite(new Website("dummy2", 4.5));
			assertEquals(2, net.getSites().size());
		}
		catch(Exception e){
			System.out.println("-0.25 Internet's addSite() not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Internet's incPop() factor used properly")
	void test012() {
		if(missing_incPop) {
			System.out.println("-1.0 Internet's incPop() is missing");
			spring2018 -= 1.0;
			throw new AssertionError("missing Internet's incPop()");
		}
		try {
			Internet net = new Internet(new ArrayList<Website>(Arrays.asList(new Website("dummy", 1.3))));
			net.addSite(new Website("dummy2", 4.4));
			net.addSite(new Website("dummy3", 5.6));
			net.incPop("dummy2", 2);
			assertEquals(1.3, net.getSites().get(0).getPop(), 1e-6);
			assertEquals(8.8, net.getSites().get(1).getPop(), 1e-6);
			assertEquals(5.6, net.getSites().get(2).getPop(), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("-0.5 Internet's incPop() doesn't increase by factor correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.5;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.5 Internet's incPop() doesn't increase by factor correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Internet's incPop() true returned if url present")
	void test013() {
		if(!missing_incPop) {
			try {
				Internet net = new Internet(new ArrayList<Website>(Arrays.asList(new Website("dummy", 1.3))));
				net.addSite(new Website("dummy2", 4.4));
				net.addSite(new Website("dummy3", 5.6));
				assertTrue(net.incPop("dummy2", 2));
			}
			catch(AssertionError e){
				System.out.println("-0.25 Internet's incPop() did not return true when the urlStr was present");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.25;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.25 Internet's incPop() did not return true when the urlStr was present, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.25;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Internet's incPop() false returned if url missing")
	void test014() {
		if(!missing_incPop) {
			try {
				Internet net = new Internet(new ArrayList<Website>(Arrays.asList(new Website("dummy", 1.3))));
				net.addSite(new Website("dummy2", 4.4));
				net.addSite(new Website("dummy3", 5.6));
				assertFalse(net.incPop("not_present", 2));
			}
			catch(AssertionError e){
				System.out.println("-0.25 Internet's incPop() did not return false when the urlStr was missing");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.25;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.25 Internet's incPop() did not return false when the urlStr was missing, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.25;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Internet's profile()")
	void test015() {
		if(missing_profile) {
			System.out.println("-1.0 Internet's profile() is missing");
			spring2018 -= 1.0;
			throw new AssertionError("missing Internet's profile()");
		}
		try {
			Internet net = new Internet(new ArrayList<Website>(Arrays.asList(new Website("dummy", 1.3))));
			net.addSite(new Website("dummy2", 4.4));
			net.addSite(new Website("dummy3", 5.6));
			net.addSite(new Website("dummy3", 2.6));
			net.addSite(new Website("dummy3", 5.8));
			net.addSite(new Website("dummy3", 0.6));
			net.addSite(new Website("dummy3", 3.6));
			net.addSite(new Website("dummy3", 6.6));
			net.addSite(new Website("dummy3", 7.6));
			net.addSite(new Website("dummy3", 8.6));
			net.addSite(new Website("dummy3", 9.6));
			net.addSite(new Website("dummy3", 10.0));
			net.addSite(new Website("dummy3", 9.2));
			assertArrayEquals(new int[]{1,1,1,1,1,2,1,1,1,2,1}, net.profile());
		}
		catch(AssertionError e){
			System.out.println("-1.0 Internet's profile() implemented incorrectly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 1.0;
			throw e;
		}
		catch(Exception e){
			System.out.println("-1.0 Internet's profile() implemented incorrectly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 1.0;
			throw e;
		}
	}

	@Test
	@DisplayName("Internet's remSite()")
	void test016() {
		if(missing_remSite) {
			System.out.println("-0.25 Internet's remSite() is missing");
			spring2018 -= 0.25;
			throw new AssertionError("missing Internet's remSite()");
		}
		try {
			Website w = new Website("dummy", 1.3);
			Website w2 = new Website("dummy1", 1.5);
			Internet net = new Internet(new ArrayList<Website>(Arrays.asList(w, w2)));
			net.remSite(w2);
			assertEquals(new ArrayList<Website>(Arrays.asList(w)), net.getSites());
		}
		catch(AssertionError e){
			System.out.println("-0.25 Internet's addSite() not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.25 Internet's addSite() not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 0.25;
			throw e;
		}
	}

	//SnobbyInternet Tests
	@Test
	@DisplayName("SnobbyInternet's constructor uses super() properly")
	void test017() {
		if(missing_snobbyInternetConstructor) {
			System.out.println("-1.5 SnobbyInternet's constructor is missing");
			spring2018 -= 1.5;
			throw new AssertionError("missing SnobbyInternet's constructor()");
		}
		try {
			List<Website> list = new ArrayList<>();
			list.add(new Website("dummy", 1.3));
			list.add(new Website("dummy2", 3.9));
			list.add(new Website("dummy3", 5.6));
			list.add(new Website("dummy3", 2.6));
			list.add(new Website("dummy3", 5.8));
			SnobbyInternet snob = new SnobbyInternet(list, 3.9);
			assertEquals(list, snob.getSites());
		}
		catch(Exception e){
			System.out.println("-1.0 SnobbyInternet's value constructor doesn't call super() correctly to initialize list in parent class");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 1.0;
			throw e;
		}
	}

	@Test
	@DisplayName("SnobbyInternet's constructor sets threshold")
	void test018() {
		if(!missing_snobbyInternetConstructor) {
			try {
				List<Website> list = new ArrayList<>();
				list.add(new Website("dummy", 1.3));
				list.add(new Website("dummy2", 3.9));
				list.add(new Website("dummy3", 5.6));
				list.add(new Website("dummy3", 2.6));
				list.add(new Website("dummy3", 5.8));
				SnobbyInternet snob = new SnobbyInternet(list, 3.9);
				//let's grab that private field and check the value
				Field f = snob.getClass().getDeclaredField("threshold");
				f.setAccessible(true);
				assertEquals(3.9, (double) f.get(snob), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("-0.5 SnobbyInternet's value constructor doesn't correctly initialize threshold");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.5;
				throw e;
			}
			catch(NoSuchFieldException e) {
				System.out.println("CHECK STUDENTS THRESHOLD FIELD!");
				throw new NullPointerException("CHECK STUDENTS THRESHOLD FIELD!");
			}
			catch(IllegalAccessException e) {
				System.out.println("CHECK STUDENTS THRESHOLD FIELD!");
				throw new NullPointerException("CHECK STUDENTS THRESHOLD FIELD!");
			}
			catch(Exception e){
				System.out.println("-0.5 SnobbyInternet's value constructor doesn't correctly initialize threshold, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2018 -= 0.5;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("SnobbyInternet's trim() method")
	void test019() {
		if(missing_trim) {
			System.out.println("-1.5 SnobbyInternet's trim() is missing");
			spring2018 -= 1.5;
			throw new AssertionError("missing SnobbyInternet's trim()");
		}
		try {
			List<Website> list = new ArrayList<>();
			List<Website> list2 = new ArrayList<>();
			Website w1 = new Website("dummy", 1.3);
			Website w2 = new Website("dummy", 3.9);
			Website w3 = new Website("dummy",5.6);
			Website w4 = new Website("dummy", 2.6);
			Website w5 = new Website("dummy", 5.8);

			list.add(w1);
			list.add(w2);
			list.add(w3);
			list.add(w4);
			list.add(w5);

			list2.add(w2);
			list2.add(w3);
			list2.add(w5);

			SnobbyInternet snob = new SnobbyInternet(list, 3.9);
			snob.trim();
			assertEquals(list2, snob.getSites());
		}
		catch(AssertionError e){
			System.out.println("-1.5 SnobbyInternet's trim() method implemented incorrectly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 1.5;
			throw e;
		}
		catch(Exception e){
			System.out.println("-1.5 SnobbyInternet's trim() method implemented incorrectly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2018 -= 1.5;
			throw e;
		}
	}
	//--------------------------------------------------------------------------------

	//Spring 2017 booleans for missing methods
	//Ques1
	private boolean missing_ques1Constructor = false;
	private boolean missing_smallestFactor = false;
	private boolean missing_factorize = false;
	private boolean missing_ques1ToString = false;

	//Top
	private boolean missing_topConstructor = false;
	private boolean missing_topAverage = false;
	private boolean missing_topMax = false;

	//Lower
	private boolean missing_lowerConstructor = false;
	private boolean missing_lowerAverage = false;
	private boolean missing_lowerMax = false;

	//Spring 2017 Tester
	private boolean missing_spring17Tester = false;

	//Spring 2017 tests
	//Ques1 Tests
	@Test
	@DisplayName("Ques1 constructor for positive parameter")
	void test020() {
		if(missing_ques1Constructor) {
			System.out.println("-0.5 Ques1's value constructor is missing");
			spring2017 -= 0.5;
			throw new AssertionError("missing Ques1's value constructor");
		}
		try {
			Ques1 q = new Ques1(7);
			//let's grab that private field and check the value
			Field f = q.getClass().getDeclaredField("n");
			f.setAccessible(true);
			assertEquals(7, (int) f.get(q));
		}
		catch(AssertionError e){
			System.out.println("-0.25 Ques1's value constructor doesn't correctly initialize n for positive parameter");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
		catch(NoSuchFieldException e) {
			System.out.println("CHECK STUDENTS n FIELD!");
			throw new NullPointerException("CHECK STUDENTS n FIELD!");
		}
		catch(IllegalAccessException e) {
			System.out.println("CHECK STUDENTS n FIELD!");
			throw new NullPointerException("CHECK STUDENTS n FIELD!");
		}
		catch(Exception e){
			System.out.println("-0.25 Website's value constructor not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Ques1 constructor for negative parameter")
	void test021() {
		if(!missing_ques1Constructor) {
			try {
				Ques1 q = new Ques1(-7);
				//let's grab that private field and check the value
				Field f = q.getClass().getDeclaredField("n");
				f.setAccessible(true);
				assertEquals(7, (int) f.get(q));
			}
			catch(AssertionError e){
				System.out.println("-0.25 Ques1's value constructor doesn't correctly initialize n for negative parameter");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
			catch(NoSuchFieldException e) {
				System.out.println("CHECK STUDENTS n FIELD!");
				throw new NullPointerException("CHECK STUDENTS n FIELD!");
			}
			catch(IllegalAccessException e) {
				System.out.println("CHECK STUDENTS n FIELD!");
				throw new NullPointerException("CHECK STUDENTS n FIELD!");
			}
			catch(Exception e){
				System.out.println("-0.25 Website's value constructor not implemented correctly, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Ques1 smallestFactor() zero edge case")
	void test022() {
		if(missing_smallestFactor) {
			System.out.println("-1.0 Ques1's smallestFactor() is missing");
			spring2017 -= 1.0;
			throw new AssertionError("missing Ques1's smallestFactor()");
		}
		try {
			Ques1 q = new Ques1(0);
			assertEquals(0, q.smallestFactor(0));
		}
		catch(AssertionError e){
			System.out.println("-0.25 Ques1's smallestFactor() doesn't handle zero edge case properly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.25 Ques1's smallestFactor() doesn't handle zero edge case properly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Ques1 smallestFactor() one edge case")
	void test023() {
		if(!missing_smallestFactor) {
			try {
				Ques1 q = new Ques1(1);
				assertEquals(1, q.smallestFactor(1));
			}
			catch(AssertionError e){
				System.out.println("-0.25 Ques1's smallestFactor() doesn't handle the one edge case properly");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.25 Ques1's smallestFactor() doesn't handle the one edge case properly, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Ques1 smallestFactor() general case")
	void test024() {
		if(!missing_smallestFactor) {
			try {
				Ques1 q = new Ques1(43043);
				assertEquals(7, q.smallestFactor(43043));
			}
			catch(AssertionError e){
				System.out.println("-0.5 Ques1's smallestFactor() doesn't handle general case properly");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.5 Ques1's smallestFactor() doesn't handle general case properly, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Ques1 factorize() zero edge case")
	void test025() {
		if(missing_factorize) {
			System.out.println("-1.0 Ques1's factorize() is missing");
			spring2017 -= 1.0;
			throw new AssertionError("missing Ques1's factorize()");
		}
		try {
			Ques1 q = new Ques1(0);
			assertEquals(new ArrayList<>(), q.factorize());
		}
		catch(AssertionError e){
			System.out.println("-0.25 Ques1's factorize() doesn't handle zero edge case properly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.25 Ques1's factorize() doesn't handle zero edge case properly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Ques1 factorize() one edge case")
	void test026() {
		if(!missing_factorize) {
			try {
				Ques1 q = new Ques1(1);
				assertEquals(new ArrayList<>(), q.factorize());
			}
			catch(AssertionError e){
				System.out.println("-0.25 Ques1's factorize() doesn't handle the one edge case properly");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.25 Ques1's factorize() doesn't handle the one edge case properly, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Ques1 toString() edge cases")
	void test027() {
		if(missing_ques1ToString) {
			System.out.println("-0.5 Ques1's toString() is missing");
			spring2017 -= 0.5;
			throw new AssertionError("missing Ques1's toString()");
		}
		try {
			assertEquals("0 = 0", new Ques1(0).toString());
			assertEquals("1 = 1", new Ques1(1).toString());
		}
		catch(AssertionError e){
			System.out.println("-0.25 Ques1's toString() doesn't handle edge cases properly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.25 Ques1's toString() doesn't handle edge cases properly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Ques1 toString() general case")
	void test028() {
		if(!missing_ques1ToString) {
			try {
				Ques1 q = new Ques1(86086);
				assertEquals("86086 = 2 x 7 x 11 x 13 x 43", q.toString());
			}
			catch(AssertionError e){
				System.out.println("-0.25 Ques1's toString() doesn't handle general case properly");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\""));
				spring2017 -= 0.25;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.25 Ques1's toString() doesn't handle general case properly, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
		}
	}

	//Top Tests
	@Test
	@DisplayName("Top constructor")
	void test029() {
		if(missing_topConstructor) {
			System.out.println("-0.5 Top's value constructor is missing");
			spring2017 -= 0.5;
			throw new AssertionError("missing Top's value constructor");
		}
		try {
			Top t = new Top(new int[] {1,2,3});
			//let's grab that private field and check the value
			Field f = t.getClass().getDeclaredField("arr");
			f.setAccessible(true);
			assertArrayEquals(new int[] {1,2,3}, (int[]) f.get(t));
		}
		catch(AssertionError e){
			System.out.println("-0.5 Top's value constructor doesn't correctly initialize arr field");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.5;
			throw e;
		}
		catch(NoSuchFieldException e) {
			System.out.println("CHECK STUDENTS arr FIELD!");
			throw new NullPointerException("CHECK STUDENTS arr FIELD!");
		}
		catch(IllegalAccessException e) {
			System.out.println("CHECK STUDENTS arr FIELD!");
			throw new NullPointerException("CHECK STUDENTS arr FIELD!");
		}
		catch(Exception e){
			System.out.println("-0.5 Top's value constructor doesn't correctly initialize arr field, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Top average() null edge case")
	void test030() {
		if(missing_topAverage) {
			System.out.println("-1.5 Top's average() is missing");
			spring2017 -= 1.5;
			throw new AssertionError("missing Top's average()");
		}
		try {
			Top t = new Top(null);
			assertEquals(0.0, t.average(), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("-0.5 Top's average() doesn't work properly for null edge case");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.5;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.5 Top's average() doesn't work properly for null edge case, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Top average() empty edge case")
	void test031() {
		if(!missing_topAverage) {
			try {
				Top t = new Top(new int[] {});
				assertEquals(0.0, t.average(), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("-0.5 Top's average() doesn't work properly for empty edge case");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.5 Top's average() doesn't work properly for empty edge case, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Top average() general case")
	void test032() {
		if(!missing_topAverage) {
			try {
				Top t = new Top(new int[] {1,2,3,4,5,6,7,8,9,10});
				assertEquals(5.5, t.average(), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("-0.5 Top's average() doesn't work properly for general case");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.5 Top's average() doesn't work properly for general case, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
		}
	}
	@Test
	@DisplayName("Top max() null edge case")
	void test033() {
		if(missing_topMax) {
			System.out.println("-1.0 Top's max() is missing");
			spring2017 -= 1.0;
			throw new AssertionError("missing Top's max()");
		}
		try {
			Top t = new Top(null);
			assertEquals(Integer.MIN_VALUE, t.max(), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("-0.25 Top's max() doesn't work properly for null edge case");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
		catch(Exception e){
			System.out.println("-0.25 Top's max() doesn't work properly for null edge case, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Top max() empty edge case")
	void test034() {
		if(!missing_topMax) {
			try {
				Top t = new Top(new int[] {});
				assertEquals(Integer.MIN_VALUE, t.max(), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("-0.25 Top's max() doesn't work properly for empty edge case");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.25 Top's max() doesn't work properly for empty edge case, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.25;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Top max() general case")
	void test035() {
		if(!missing_topMax) {
			try {
				Top t = new Top(new int[] {-2, -96,-3,-6,-4,-1,-7,-5,-8,-9,-10});
				assertEquals(-1, t.max(), 1e-6);
			}
			catch(AssertionError e){
				System.out.println("-0.5 Top's max() doesn't work properly for general case");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
			catch(Exception e){
				System.out.println("-0.5 Top's max() doesn't work properly for general case, exception thrown");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
		}
	}

	//Lower tests
	@Test
	@DisplayName("Lower's constructor initializes its field arr1 properly")
	void test036() {
		if(missing_lowerConstructor) {
			System.out.println("-1.0 Lower's constructor is missing");
			spring2017 -= 1.0;
			throw new AssertionError("missing Lower's constructor()");
		}
		try {
			Lower low = new Lower(new int[] {1,2,3}, new int[] {4,5,6});
			//let's grab that private field and check the value
			Field f = low.getClass().getDeclaredField("arr1");
			f.setAccessible(true);
			assertArrayEquals(new int[] {4,5,6}, (int[]) f.get(low));
		}
		catch(AssertionError e){
			System.out.println("-0.5 Lower's value constructor doesn't correctly initialize arr1 field");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.5;
			throw e;
		}
		catch(NoSuchFieldException e) {
			System.out.println("CHECK LOWER's arr1 FIELD!");
			throw new NullPointerException("CHECK LOWER's arr1 FIELD!");
		}
		catch(IllegalAccessException e) {
			System.out.println("CHECK LOWER's arr1 FIELD!");
			throw new NullPointerException("CHECK LOWER's arr1 FIELD!");
		}
		catch(Exception e){
			System.out.println("-0.5 Lower's value constructor doesn't correctly initialize arr1 field");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Lower's constructor initializes parent's field arr properly")
	void test037() {
		if(!missing_lowerConstructor) {
			try {
				Lower low = new Lower(new int[] {1,2,3}, new int[] {4,5,6});
				//let's grab that private field in the super class and check the value
				Field f = low.getClass().getSuperclass().getDeclaredField("arr");
				f.setAccessible(true);
				assertArrayEquals(new int[] {1,2,3}, (int[]) f.get(low));
			}
			catch(AssertionError e){
				System.out.println("-0.5 Lower's value constructor doesn't correctly initialize arr field in Top");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
			catch(NoSuchFieldException e) {
				System.out.println("CHECK TOP's arr FIELD!");
				throw new NullPointerException("CHECK TOP's arr FIELD!");
			}
			catch(IllegalAccessException e) {
				System.out.println("CHECK TOP's arr FIELD!");
				throw new NullPointerException("CHECK TOP's arr FIELD!");
			}
			catch(Exception e){
				System.out.println("-0.5 Lower's value constructor doesn't correctly initialize arr field in Top");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				spring2017 -= 0.5;
				throw e;
			}
		}
	}

	@Test
	@DisplayName("Lower max()")
	void test038() {
		if(missing_lowerMax) {
			System.out.println("-1.0 Lower's max() is missing");
			spring2017 -= 1.0;
			throw new AssertionError("missing Lower's max()");
		}
		try {
			int[] test1 = null;
			int[] test2 = {};
			int[] test3 = {5, 2, -2, 7, -5, 2};
			assertAll(
					() -> assertEquals(Integer.MIN_VALUE, new Lower(test2, test2).max()),
					() -> assertEquals(Integer.MIN_VALUE, new Lower(test1, test2).max()),
					() -> assertEquals(Integer.MIN_VALUE, new Lower(test2, test1).max()),
					() -> assertEquals(Integer.MIN_VALUE, new Lower(test1, test1).max()),
					() -> assertEquals(7, new Lower(test1, test3).max()),
					() -> assertEquals(7, new Lower(test2, test3).max()),
					() -> assertEquals(7, new Lower(test3, test1).max()),
					() -> assertEquals(7, new Lower(test3, test2).max())
					);
		}
		catch(MultipleFailuresError e){
			e.getFailures().size();
			System.out.println("-" + 0.125* e.getFailures().size() + " Lower's max() doesn't work properly, had " + e.getFailures().size() + " assertion failures, each worth 0.125 points");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.125* e.getFailures().size();
			throw e;
		}
		catch(Exception e){
			System.out.println("-1.0 Lower's max() doesn't work properly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.25;
			throw e;
		}
	}

	@Test
	@DisplayName("Lower average()")
	void test039() {
		if(missing_lowerAverage) {
			System.out.println("-1.0 Lower's average() is missing");
			spring2017 -= 1.0;
			throw new AssertionError("missing Lower's average()");
		}
		try {
			int[] test1 = null;
			int[] test2 = {};
			int[] test3 = {5, 2, -2, 7, -5, 2};
			assertAll(
					() -> assertEquals(0.0, new Lower(test2, test2).average(), 1e-6),
					() -> assertEquals(0.0, new Lower(test1, test2).average(), 1e-6),
					() -> assertEquals(0.0, new Lower(test2, test1).average(), 1e-6),
					() -> assertEquals(0.0, new Lower(test1, test1).average(), 1e-6),
					() -> assertEquals(1.5, new Lower(test1, test3).average(), 1e-6),
					() -> assertEquals(1.5, new Lower(test2, test3).average(), 1e-6),
					() -> assertEquals(0.0, new Lower(test3, test1).average(), 1e-6),
					() -> assertEquals(0.0, new Lower(test3, test2).average(), 1e-6)
					);
		}
		catch(MultipleFailuresError e){
			e.getFailures().size();
			System.out.println("-" + 0.125* e.getFailures().size() + " Lower's average() doesn't work properly, had " + e.getFailures().size() + " assertion failures, each worth 0.125 points");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 0.125* e.getFailures().size();
			throw e;
		}
		catch(Exception e){
			System.out.println("-1.0 Lower's average() doesn't work properly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 1.0;
			throw e;
		}
	}

	//Spring 2017 Tester Test
	@Test
	@DisplayName("Calling main of Tester spring 2017")
	void test040() {
		if(missing_spring17Tester) {
			System.out.println("-1 Tester.java for Spring2017 is not present or does not contain a main");
			spring2017 -= 1.0;
			throw new AssertionError("spring 17 tester is missing");
		}
		try {
			//want to call the main but not have it print to the screen
			//just to make sure it was written
			PrintStream original = System.out;
			System.setOut(new PrintStream(new OutputStream() {
				public void write(int b) {
					//DO NOTHING
				}
			}));
			Tester.main(null);
			System.setOut(original);
		}
		catch(Exception e){
			System.out.println("-1.0 Tester.java is for Spring2017 not present or does not contain a main, or has exception occuring in main");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 1.0;
			throw e;
		}
	}

	//--------------------------------------------------------------------------------
	//Fall 2017 booleans for missing methods
	//Pagination
	private boolean missing_paginationConstructor = false;
	private boolean missing_setChapStartPage = false;
	private boolean missing_assign = false;
	private boolean missing_totalToRead = false;
	private boolean missing_paginationMain = false;

	//Exercise
	private boolean missing_modify = false;

	//TweetQuestion
	private boolean missing_tweetQuestionConstructor = false;
	private boolean missing_tweetQuestionDisplay = false;

	//Fall 2017 tests
	//Pagination Tests
	@Test
	@DisplayName("Pagination constructor")
	void test041() {
		if(missing_paginationConstructor) {
			System.out.println("-1.0 Pagination's value constructor is missing");
			fall2017 -= 1.0;
			throw new AssertionError("missing Pagination's value constructor");
		}
		try {
			Pagination book = new Pagination(158,4);
			//let's grab that private fields in the super class and check the values
			Field pages = book.getClass().getDeclaredField("numPages");
			Field chapters = book.getClass().getDeclaredField("numChapters");
			Field startArray = book.getClass().getDeclaredField("chapStarts");
			Field assignedArray = book.getClass().getDeclaredField("chapAssigned");
			pages.setAccessible(true);
			chapters.setAccessible(true);
			startArray.setAccessible(true);
			assignedArray.setAccessible(true);
			assertAll(
					() -> assertArrayEquals(new int[] {0,0,0,0,0}, (int[]) (startArray.get(book))),
					() -> assertArrayEquals(new int[] {0,0,0,0,0}, (int[]) (assignedArray.get(book))),
					() -> assertEquals(158, (int) pages.get(book)),
					() -> assertEquals(4, (int) chapters.get(book))
					);
		}
		catch(NoSuchFieldException e) {
			System.out.println("CHECK PAGINATIONS FIELDS!");
			throw new NullPointerException("CHECK PAGINATIONS FIELDS!");
		}
		catch(MultipleFailuresError e){
			e.getFailures().size();
			System.out.println("-" + 0.25* e.getFailures().size() + " Paginations's value constructor doesn't instantiate properly, had " + e.getFailures().size() + " assertion failures, each worth 0.25 points");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 0.25* e.getFailures().size();
			throw e;
		}
		catch(Exception e){
			System.out.println("-1.0 Pagination's value constructor doesn't work properly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 1.0;
			throw e;
		}
	}

	@Test
	@DisplayName("Pagination setChapStartPage()")
	void test042() {
		if(missing_setChapStartPage) {
			System.out.println("-0.5 Pagination's setChapStartPage() is missing");
			fall2017 -= 0.5;
			throw new AssertionError("missing Pagination's setChapStartPage()");
		}
		try {
			Pagination book = new Pagination(158,4);

			Field startArray = book.getClass().getDeclaredField("chapStarts");
			startArray.setAccessible(true);

			for(int i = 1; i <= 4; i++) { 
				book.setChapStartPage(i, i*i + 30);
				int[] arr = (int[]) (startArray.get(book));
				assertEquals(i*i + 30, arr[i]);
			}
		}
		catch(AssertionError e){
			System.out.println("-0.5 Pagination's setChapStartPage() not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 0.5;
			throw e;
		}
		catch(NoSuchFieldException e) {
			System.out.println("CHECK PAGINATIONS FIELDS!");
			throw new NullPointerException("CHECK PAGINATIONS FIELDS!");
		}
		catch(IllegalAccessException e) {
			System.out.println("CHECK PAGINATIONS FIELDS!");
			throw new NullPointerException("CHECK PAGINATIONS FIELDS!");
		}
		catch(Exception e){
			System.out.println("-0.5 Pagination's setChapStartPage() not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Pagination assign()")
	void test043() {
		if(missing_assign) {
			System.out.println("-0.5 Pagination's assign() is missing");
			fall2017 -= 0.5;
			throw new AssertionError("missing Pagination's assign()");
		}
		try {
			Pagination book = new Pagination(158,4);

			Field startArray = book.getClass().getDeclaredField("chapAssigned");
			startArray.setAccessible(true);

			for(int i = 1; i <= 4; i++) { 
				int[] arr = (int[]) (startArray.get(book));
				assertEquals(0, arr[i]);
				book.assign(i);
				assertEquals(1, arr[i]);
			}
		}
		catch(AssertionError e){
			System.out.println("-0.5 Pagination's assign() not implemented correctly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 0.5;
			throw e;
		}
		catch(NoSuchFieldException e) {
			System.out.println("CHECK PAGINATIONS FIELDS!");
			throw new NullPointerException("CHECK PAGINATIONS FIELDS!");
		}
		catch(IllegalAccessException e) {
			System.out.println("CHECK PAGINATIONS FIELDS!");
			throw new NullPointerException("CHECK PAGINATIONS FIELDS!");
		}
		catch(Exception e){
			System.out.println("-0.5 Pagination's assign() not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 0.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Pagination totalToRead()")
	void test044() {
		if(missing_totalToRead) {
			System.out.println("-1.5 Pagination's totalToRead() is missing");
			fall2017 -= 1.5;
			throw new AssertionError("missing Pagination's totalToRead()");
		}
		try {
			Pagination book = new Pagination(158,4);
			book.setChapStartPage(1,1);
			book.setChapStartPage(2,55);
			book.setChapStartPage(3,89);
			book.setChapStartPage(4,128);

			try {
				assertEquals(0, book.totalToRead());
			}
			catch(AssertionError e) {
				System.out.println("-0.3 Pagination's totalToRead() didn't work for no pages assigned");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				fall2017 -= 0.3;
			}

			book.assign(1);
			try {
				assertEquals(54, book.totalToRead());
			}
			catch(AssertionError e) {
				System.out.println("-0.3 Pagination's totalToRead() didn't work for first chapter assigned");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				fall2017 -= 0.3;
			}

			book.assign(2);
			try {
				assertEquals(88, book.totalToRead());
			}
			catch(AssertionError e) {
				System.out.println("-0.3 Pagination's totalToRead() didn't work for first 2 chapters assigned");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				fall2017 -= 0.3;
			}


			book.assign(3);

			try{
				assertEquals(127, book.totalToRead());
			}
			catch(AssertionError e) {
				System.out.println("-0.3 Pagination's totalToRead() didn't work for first 3 chapters assigned");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				fall2017 -= 0.3;
			}


			book.assign(4);
			try{
				assertEquals(158, book.totalToRead());
			}
			catch(AssertionError e) {
				System.out.println("-0.3 Pagination's totalToRead() didn't work for last assigned");
				System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
				fall2017 -= 0.3;
			}
		}
		catch(Exception e){
			System.out.println("-1.5 Pagination's totalToRead() not implemented correctly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 1.5;
			throw e;
		}
	}

	@Test
	@DisplayName("Pagination main")
	void test045() {
		if(missing_paginationMain) {
			System.out.println("-1.0 main not present in pagination");
			fall2017 -= 1.0;
			throw new AssertionError("spring 18 tester is missing");
		}
		try {
			//want to call the main but not have it print to the screen
			//just to make sure it was written
			PrintStream original = System.out;
			System.setOut(new PrintStream(new OutputStream() {
				public void write(int b) {
					//DO NOTHING
				}
			}));
			Tester.main(null);
			System.setOut(original);
		}
		catch(Exception e){
			System.out.println("-1.0 main not present in pagination, or has exception occuring");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 1.0;
			throw e;
		}
	}

	//Exercise tests
	@Test
	@DisplayName("Exercise's modify()")
	void test046() {
		if(missing_modify) {
			System.out.println("-3.0 Exercise's modify() is missing");
			fall2017 -= 3.0;
			throw new AssertionError("missing Exercise's modify()");
		}
		try {
			Exercise e = new Exercise(5, '+');
			ArrayList<Character> list1 = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g'));
			e.modify(list1);

			ArrayList<Character> list2 = new ArrayList<>(Arrays.asList('a','b','c','d','e','f'));
			e.modify(list2);

			ArrayList<Character> list3 = new ArrayList<>(Arrays.asList('a','b','c','d','e'));
			e.modify(list3);

			ArrayList<Character> list4 = new ArrayList<>(Arrays.asList('a','b','c'));
			e.modify(list4);

			ArrayList<Character> list5 = new ArrayList<>();
			e.modify(list5);

			ArrayList<Character> list6 = null;
			e.modify(list6);

			assertAll(
					() -> assertEquals("[a, b, c, d, e, +, +]", list1.toString()),
					() -> assertEquals("[a, b, c, d, e, +]", list2.toString()),
					() -> assertEquals("[a, b, c, d, e, +]", list3.toString()),
					() -> assertEquals("[a, b, c, +, +, +]", list4.toString()),
					() -> assertEquals("[+, +, +, +, +, +]", list5.toString()),
					() -> assertNull(list6)
					);
		}
		catch(MultipleFailuresError e){
			e.getFailures().size();
			System.out.println("-" + 0.5* e.getFailures().size() + " Exercise's modify doesn't work properly, had " + e.getFailures().size() + " assertion failures, each worth 0.5 points");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 0.5* e.getFailures().size();
			throw e;
		}
		catch(Exception e){
			System.out.println("-3.0 Exercise's modify() method doesn't work properly, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			fall2017 -= 3.0;
			throw e;
		}
	}

	@Test
	@DisplayName("TweetQuestion's constructor")
	void test047() {
		if(missing_tweetQuestionConstructor) {
			System.out.println("-1.0 TweetQuestion's constructor is missing");
			fall2017 -= 1.0;
			throw new AssertionError("missing TweetQuestion's constructor");
		}
		try {
			TweetQuestion tweet = new TweetQuestion("Which course are you enjoying most?");
			//let's grab that private field in the super class and check the value
			Field f = tweet.getClass().getSuperclass().getDeclaredField("question");
			f.setAccessible(true);
			assertEquals("Which course are you enjoying most?", (String) f.get(tweet));
		}
		catch(AssertionError e){
			System.out.println("-1.0 TweetQuestion's constructor doesn't correctly initialize question field in parent");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 1.0;
			throw e;
		}
		catch(NoSuchFieldException e) {
			System.out.println("CHECK Question's FIELD!");
			throw new NullPointerException("CHECK Question's FIELD!");
		}
		catch(IllegalAccessException e) {
			System.out.println("CHECK Question's FIELD!");
			throw new NullPointerException("CHECK Question's FIELD!");
		}
		catch(Exception e){
			System.out.println("-1.0 TweetQuestion's constructor doesn't correctly initialize question field in parent, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 1.0;
			throw e;
		}
	}
	
	@Test
	@DisplayName("TweetQuestion's display")
	void test000() {
		if(missing_tweetQuestionDisplay) {
			System.out.println("-1.5 TweetQuestion's display() is missing");
			fall2017 -= 1.5;
			throw new AssertionError("missing TweetQuestion's display");
		}
		try {
			TweetQuestion tweet = new TweetQuestion("Which course are you enjoying most?");
			tweet.display();
			System.out.println("----------------------------------------------");
		}
		catch(AssertionError e){
			System.out.println("-1.5 TweetQuestion's display() method not implemented properly");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 1.5;
			throw e;
		}
		catch(Exception e){
			System.out.println("-1.5 TweetQuestion's constructor doesn't correctly initialize question field in parent, exception thrown");
			System.out.println("\t" + e.getMessage().replace("<", "\"").replace(">", "\"").replace(" but was: ", "\n\tactual: "));
			spring2017 -= 1.5;
			throw e;
		}

	}



	//--------------------------------------------------------------------------------
	@Test
	@DisplayName("printing grade")
	void test099() {
		System.out.println("\n*********GRADES ON THREE PRACTICE TESTS*********");
		System.out.println("\tSpring 2018: " + spring2018);
		System.out.println("\tSpring 2017: " + spring2017);
		System.out.println("\tFall 2017: " + fall2017);
		System.out.println("Note: We weigh the highest scored test as 40% and the other two as 30% each");
		//weigh the highest score 40% the other two as 30% each
		System.out.println("\nFinal grade: " + 
				Math.max(0.3*(spring2018 + fall2017) + 0.4*spring2017, 
						Math.max(0.3*(spring2017 + fall2017) + 0.4*spring2018, 
								0.3*(spring2018 + spring2017) + 0.4*fall2017)));
	}

}
