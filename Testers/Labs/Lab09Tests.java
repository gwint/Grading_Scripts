package lab09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.IOException;

class Lab09Tests {
	@Test
	void testGrabBingo1() {
        List<String> bingoNums = Streams.grabBingoNums("B");
        Assert.assertTrue(bingoNums.contains("B12") &&
                          bingoNums.contains("B6") &&
                          bingoNums.size() == 2);
	}

	@Test
	void testGrabBingo2() {
        List<String> bingoNums = Streams.grabBingoNums("Z");
        Assert.assertTrue(bingoNums.size() == 0);
	}

	@Test
	void testGrabBingo3() {
        List<String> bingoNums = Streams.grabBingoNums("O");
        Assert.assertTrue(bingoNums.contains("O71") &&
                          bingoNums.size() == 1);
	}

	@Test
	void testExtractNums1() {
        List<Integer> bingoNums = Streams.extractNums();
        Assert.assertTrue(bingoNums.contains(40) &&
                          bingoNums.contains(36) &&
                          bingoNums.contains(12) &&
                          bingoNums.contains(6) &&
                          bingoNums.contains(49) &&
                          bingoNums.contains(53) &&
                          bingoNums.contains(60) &&
                          bingoNums.contains(50) &&
                          bingoNums.contains(64) &&
                          bingoNums.contains(26) &&
                          bingoNums.contains(17) &&
                          bingoNums.contains(29) &&
                          bingoNums.contains(71) &&
                          bingoNums.size() == 13);
	}

	@Test
	void testSumLists1() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>(Arrays.asList(4,5,6));
        List<List<Integer>> superList = new ArrayList<>(Arrays.asList(list1, list2, list3));

        Assert.assertTrue(Streams.sumLists(superList) == 21);
	}

	@Test
	void testSumLists2() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<List<Integer>> superList = new ArrayList<>(Arrays.asList(list1, list2, list3));

        Assert.assertTrue(Streams.sumLists(superList) == 0);
    }

    @Test
    void testSumLists3() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(-1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(3));
        List<List<Integer>> superList = new ArrayList<>(Arrays.asList(list1, list2, list3));

        Assert.assertTrue(Streams.sumLists(superList) == 4);
    }

	@Test
	void testIsPal1() {
        Assert.assertTrue(Streams.isPalindrome("able was i ere i saw elba"));
    }

	@Test
	void testIsPal2() {
        Assert.assertFalse(Streams.isPalindrome("abcdef"));
    }

	@Test
	void testCountOdd1() {
        Assert.assertTrue(Streams.countOdd(new int[]{1,2,3,4,5}) == 3);
    }
}
