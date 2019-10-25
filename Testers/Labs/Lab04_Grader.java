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
public class Lab04_Grader {
    public class ReportWriter extends TestWatcher {
        private String reportFileName;
        private FileWriter fileWriter;
        private Map<String, Double> penalties;
        private List<String> reportLines;
        private int failures;

        public ReportWriter(String fileName, Map<String, Double> perTestPenalties) {
            this.reportFileName = fileName;
            this.penalties = perTestPenalties;
            this.failures = 0;
            try {
                this.fileWriter = new FileWriter(fileName, true);
            }
            catch(IOException e) {}
            finally {}
        }

        private void writeLine(String line) {
            try {
                this.fileWriter.write(line + "\n");
                this.fileWriter.flush();
            }
            catch(Exception e) {}
            finally {}
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Error description: " + description.toString());
            this.writeLine(description.toString());
            this.writeLine(String.format("Deduction: %f", this.penalties.get(description.toString())));
        }
    }

    private static double grade;
    private static FileWriter fw;
    private static FileExtractor emptyExtractor;
    private static FileExtractor normalExtractor;
    private static FileExtractor nonExistentExtractor;
    private static Map<String, Double> penalties = new HashMap<>();

    static {
        Lab04_Grader.penalties.put("echoArgs1(lab04.Lab04_Grader)", 0.2);
        Lab04_Grader.penalties.put("echoArgs2(lab04.Lab04_Grader)", 0.2);
        Lab04_Grader.penalties.put("echoArgs3(lab04.Lab04_Grader)", 0.2);
        Lab04_Grader.penalties.put("echoArgs4(lab04.Lab04_Grader)", 0.2);

        Lab04_Grader.penalties.put("atestNonExistentFileExtractorCreation(lab04.Lab04_Grader)", 1.0);
        Lab04_Grader.penalties.put("atestEmptyFileExtractorCreation(lab04.Lab04_Grader)", 1.0);
        Lab04_Grader.penalties.put("atestNormalFileExtractorCreation(lab04.Lab04_Grader)", 1.0);

        Lab04_Grader.penalties.put("testEmptyRemoveOddElements(lab04.Lab04_Grader)", 1.0);
        Lab04_Grader.penalties.put("testNonExistentRemoveOddElements(lab04.Lab04_Grader)", 1.0);
        Lab04_Grader.penalties.put("testNormalRemoveOddElements(lab04.Lab04_Grader)", 1.0);

        Lab04_Grader.penalties.put("testEmptyRemoveEvenElements(lab04.Lab04_Grader)", 1.0);
        Lab04_Grader.penalties.put("testNonExistentRemoveEvenElements(lab04.Lab04_Grader)", 1.0);
        Lab04_Grader.penalties.put("testNormalRemoveEvenElements(lab04.Lab04_Grader)", 1.0);
    }

    @Rule
    public ReportWriter reportWriter = new ReportWriter("report.txt", Lab04_Grader.penalties);

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
        Lab04_Grader.nonExistentExtractor = new FileExtractor("doesntexist.txt");
        Assert.assertTrue(true);
    }

    @Test
    public void atestEmptyFileExtractorCreation() {
        Lab04_Grader.emptyExtractor = new FileExtractor("empty.txt");
        Assert.assertTrue(true);
    }

    @Test
    public void atestNormalFileExtractorCreation() {
        Lab04_Grader.normalExtractor = new FileExtractor("normal.txt");
        Assert.assertTrue(true);
    }

    @Test
    public void testEmptyRemoveOddElements() {
        Lab04_Grader.emptyExtractor.removeOddElements();
        String originalStr = Lab04_Grader.emptyExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String arrayPortion = pieces[0].trim();
        Assert.assertEquals("array: []", arrayPortion);
    }

    @Test
    public void testNonExistentRemoveOddElements() {
        Lab04_Grader.nonExistentExtractor.removeOddElements();
        String originalStr = Lab04_Grader.nonExistentExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String arrayPortion = pieces[0].trim();
        Assert.assertEquals("array: []", arrayPortion);
    }

    @Test
    public void testNormalRemoveOddElements() {
        Lab04_Grader.normalExtractor.removeOddElements();
        String originalStr = Lab04_Grader.normalExtractor.toString();
        String[] pieces = originalStr.split("\n");
        System.out.println(originalStr);
        String arrayPortion = pieces[0].trim();
        Assert.assertEquals("array: [8, 50]", arrayPortion);
    }

    @Test
    public void testEmptyRemoveEvenElements() {
        Lab04_Grader.emptyExtractor.removeEvenElements();
        String originalStr = Lab04_Grader.emptyExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String listPortion = pieces[1].trim();
        Assert.assertEquals("list: []", listPortion);
    }

    @Test
    public void testNonExistentRemoveEvenElements() {
        Lab04_Grader.nonExistentExtractor.removeEvenElements();
        String originalStr = Lab04_Grader.nonExistentExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String listPortion = pieces[1].trim();
        Assert.assertEquals("list: []", listPortion);
    }

    @Test
    public void testNormalRemoveEvenElements() {
        Lab04_Grader.normalExtractor.removeEvenElements();
        String originalStr = Lab04_Grader.normalExtractor.toString();
        String[] pieces = originalStr.split("\n");
        String listPortion = pieces[1].trim();
        Assert.assertEquals("list: [83, 13, 101]", listPortion);
    }
}
