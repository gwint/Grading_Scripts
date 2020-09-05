package lab08;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestRule;
import org.junit.runner.Description;

import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Lab08_Grader{
	
	FileWriter fw;

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

	private final List<Integer> data = new ArrayList<>(Arrays.asList(4, 8, -3, -1, 9, -12, 0, -12, 1));
    private final Comparator<Integer> intComp = (i, j) -> i - j;
    private BinarySearchTree<Integer> ints;

    private final List<String> stringData = new ArrayList<>(Arrays.asList("az", "bc", "aa", "fa", "ee", "aaa"));

    //Largest strings have the largest sum of ascii values
    //Smallest strings have smallest sums of ascii values
    private final Comparator<String> stringComp = (i, j) -> {

    	int sum1 = 0;
    	char[] letters = i.toCharArray();
    	for(char c : letters){
    		sum1 += (int)c;
    	}

    	int sum2 = 0;
    	letters = j.toCharArray();
    	for(char c : letters){
    		sum2 += (int)c;
    	}

    	return sum1-sum2;

    };
    private BinarySearchTree<String> strings;


	@Before
	public void setUp() throws Exception {
		fw = new FileWriter("temp.txt", true);

		ints = new BinarySearchTree<>(intComp);
        for (int i : data) {
            ints.insert(i);
        }

		strings = new BinarySearchTree<>(stringComp);
        for (String i : stringData) {
            strings.insert(i);
        }
	}

	@Test
    public void testIntFind1() {
        for (int i : data) {
            assertNotNull(ints.find(i));
        }
    }

	@Test
    public void testIntFind2() {
        assertNull(ints.find(6));
        assertNull(ints.find(-4));
        assertNull(ints.find(2));
    }

    @Test
    public void testIntGetElements() {
        List<Integer> elems = ints.getElements();
        List<Integer> gotten = new ArrayList<>();
        for (int i : elems) {
            assertNotNull(ints.find(i));
            assertFalse(gotten.contains(i));
            gotten.add(i);
        }
        for (int i : data) {
            assertTrue(elems.contains(i));
        }
        assertEquals(8, elems.size());
        
        for (int i = 1; i < elems.size(); i++) {
            assertTrue(elems.get(i-1) < elems.get(i));
        }
    }

	@Test
    public void testStringFind1() {
        for (String i : stringData) {
            assertNotNull(strings.find(i));
        }
    }

	@Test
    public void testStringFind2() {
        assertNull(strings.find("ac"));
        assertNull(strings.find("a"));
        assertNull(strings.find("bb"));
    }

    @Test
    public void testStringGetElements() {
        List<String> elems = strings.getElements();
        List<String> gotten = new ArrayList<>();
        for (String i : elems) {
            assertNotNull(strings.find(i));
            assertFalse(gotten.contains(i));
            gotten.add(i);
        }
        for (String i : stringData) {
            assertTrue(elems.contains(i));
        }
        assertEquals(6, elems.size());
        
        for (int i = 1; i < elems.size(); i++) {
        	assertTrue(stringComp.compare(elems.get(i-1), elems.get(i)) < 0);
            //assertTrue(elems.get(i-1) < elems.get(i));
        }
    }


}