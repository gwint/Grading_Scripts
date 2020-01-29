package lab04;

import org.junit.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.runners.MethodSorters;
import java.util.Map;
import java.util.HashMap;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab04Tests {

    private static FileWriter fw;
    private static FileExtractor emptyExtractor;
    private static FileExtractor normalExtractor;
    private static FileExtractor nonExistentExtractor;

    @BeforeClass
    public static void initTests() throws IOException {
        // Create test files
        PrintWriter writer = new PrintWriter("empty.txt", "UTF-8");
        writer.println("\n");
        writer.close();

        writer = new PrintWriter("normal.txt", "UTF-8");
        writer.println("83\n\n");
        writer.println("8");
        writer.println("50\n\n13\n");
        writer.println("101\n\n\n");
        writer.close();
    }

    @Test
    public void echoArgs1() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("EchoArgs.java")));
        Assert.assertTrue(content.contains("1. []") || content.contains("1.[]"));
    }

    @Test
    public void echoArgs2() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("EchoArgs.java")));
        Assert.assertTrue(content.contains("2. [hello]") || content.contains("2.[hello]"));
    }

    @Test
    public void echoArgs3() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("EchoArgs.java")));
        Assert.assertTrue(content.contains("3. [hello, world]") || content.contains("3.[hello, world]"));
    }

    @Test
    public void echoArgs4() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("EchoArgs.java")));
        Assert.assertTrue(content.contains("4. [hello world]") || content.contains("4.[hello world]"));
    }

    @Test
    public void atestNonExistentFileExtractorCreation() {
        Lab04Tests.nonExistentExtractor = new FileExtractor("doesntexist.txt");
        Assert.assertTrue(true);
    }

    @Test
    public void atestEmptyFileExtractorCreation() {
        Lab04Tests.emptyExtractor = new FileExtractor("empty.txt");
        Assert.assertTrue(true);
    }

    @Test
    public void atestNormalFileExtractorCreation() {
        Lab04Tests.normalExtractor = new FileExtractor("normal.txt");
        Assert.assertTrue(true);
    }

    @Test
    public void testEmptyRemoveOddElements() {
        Lab04Tests.emptyExtractor.removeOddElements();
        String originalStr = Lab04Tests.emptyExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String arrayPortion = pieces[0].trim();
        Assert.assertEquals("array: []", arrayPortion);
    }

    @Test
    public void testNonExistentRemoveOddElements() {
        Lab04Tests.nonExistentExtractor.removeOddElements();
        String originalStr = Lab04Tests.nonExistentExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String arrayPortion = pieces[0].trim();
        Assert.assertEquals("array: []", arrayPortion);
    }

    @Test
    public void testNormalRemoveOddElements() {
        Lab04Tests.normalExtractor.removeOddElements();
        String originalStr = Lab04Tests.normalExtractor.toString();
        String[] pieces = originalStr.split("\n");
        System.out.println(originalStr);
        String arrayPortion = pieces[0].trim();
        Assert.assertEquals("array: [8, 50]", arrayPortion);
    }

    @Test
    public void testEmptyRemoveEvenElements() {
        Lab04Tests.emptyExtractor.removeEvenElements();
        String originalStr = Lab04Tests.emptyExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String listPortion = pieces[1].trim();
        Assert.assertEquals("list: []", listPortion);
    }

    @Test
    public void testNonExistentRemoveEvenElements() {
        Lab04Tests.nonExistentExtractor.removeEvenElements();
        String originalStr = Lab04Tests.nonExistentExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String listPortion = pieces[1].trim();
        Assert.assertEquals("list: []", listPortion);
    }

    @Test
    public void testNormalRemoveEvenElements() {
        Lab04Tests.normalExtractor.removeEvenElements();
        String originalStr = Lab04Tests.normalExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String listPortion = pieces[1].trim();
        Assert.assertEquals("list: [83, 13, 101]", listPortion);
    }
}
