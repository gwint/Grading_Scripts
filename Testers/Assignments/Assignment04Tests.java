
package assignment04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.IOException;

class Assignment4Tests {
    CellGrid grid;
    FileExtractor fileExtractor;
    FileExtractor fileExtractorIdentity;
    FileExtractor fileExtractorZero;

    @BeforeAll
    static void createTestFiles() throws IOException {
        PrintWriter m1Writer = new PrintWriter("m1.txt", "UTF-8");
        PrintWriter m2Writer = new PrintWriter("m2.txt", "UTF-8");
        PrintWriter m3Writer = new PrintWriter("m3.txt", "UTF-8");
        PrintWriter m4Writer = new PrintWriter("m4.txt", "UTF-8");

        m1Writer.println("  7 9 4\n2 2\n 1 3 4 4 \n 6 7\n");
        m2Writer.println("3 7  9 \n2 1 6\n 1   3   \n  6  6   7");
        m3Writer.println("  0 0 0 \n 0 0 \n 0 0 \n 0 0");
        m4Writer.println("1 0 0 \n 0 1 0 \n 0 0 1");

        m1Writer.close();
        m2Writer.close();
        m3Writer.close();
        m4Writer.close();
    }

    @BeforeEach
    void setUp() throws Exception {
        this.grid = new CellGrid(3, 3);
        this.fileExtractor = new FileExtractor("m1.txt", "m2.txt");
        this.fileExtractorIdentity = new FileExtractor("m1.txt", "m4.txt");
        this.fileExtractorZero = new FileExtractor("m1.txt", "m3.txt");
    }

    @Test
    void testPopulateNeighbors1() {
        Cell[][] grid = new Cell[3][3];
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                grid[row][col] = new Cell(row, col);
            }
        }

        grid[0][0].populateNeighbors(grid);

        List<Cell> foundNeighbors = grid[0][0].neighbors;

        assertAll (
            () -> assertTrue(foundNeighbors.contains(grid[0][1])),
            () -> assertTrue(foundNeighbors.contains(grid[1][1])),
            () -> assertTrue(foundNeighbors.contains(grid[1][0])),
            () -> assertTrue(foundNeighbors.size() == 3)
        );
    }

    @Test
    void testPopulateNeighbors2() {
        Cell[][] grid = new Cell[3][3];
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                grid[row][col] = new Cell(row, col);
            }
        }

        grid[1][1].populateNeighbors(grid);

        List<Cell> foundNeighbors = grid[1][1].neighbors;

        assertAll (
            () -> assertTrue(foundNeighbors.contains(grid[0][0])),
            () -> assertTrue(foundNeighbors.contains(grid[0][1])),
            () -> assertTrue(foundNeighbors.contains(grid[0][2])),
            () -> assertTrue(foundNeighbors.contains(grid[1][0])),
            () -> assertTrue(foundNeighbors.contains(grid[1][2])),
            () -> assertTrue(foundNeighbors.contains(grid[2][0])),
            () -> assertTrue(foundNeighbors.contains(grid[2][1])),
            () -> assertTrue(foundNeighbors.contains(grid[2][2])),
            () -> assertTrue(foundNeighbors.size() == 8)
        );
    }

    @Test
    void testAliveNextTime1() {
        Cell[][] grid = new Cell[3][3];
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                grid[row][col] = new Cell(row, col);
            }
        }

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                grid[row][col].setAlive(true);
                grid[row][col].populateNeighbors(grid);
            }
        }

        assertFalse(grid[1][1].aliveNextTime());
    }

    @Test
    void testAliveNextTime2() {
        Cell[][] grid = new Cell[3][3];
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                grid[row][col] = new Cell(row, col);
            }
        }

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                grid[row][col].setAlive(true);
                grid[row][col].populateNeighbors(grid);
            }
        }

        assertTrue(grid[0][0].aliveNextTime());
    }

    @Test
    void testMatrixProduct1() {
        double[][] productArr = new double[3][3];
        productArr[0][0] = 43.0;
        productArr[0][1] = 70.0;
        productArr[0][2] = 141.0;
        productArr[1][0] = 11.0;
        productArr[1][1] = 19.0;
        productArr[1][2] = 36.0;
        productArr[2][0] = 21.0;
        productArr[2][1] = 37.0;
        productArr[2][2] = 75.0;

        assertTrue(Arrays.deepEquals(productArr, this.fileExtractor.matrixProduct()));
    }

    @Test
    void testMatrixProduct2() {
        double[][] productArr = new double[3][3];
        productArr[0][0] = 0;
        productArr[0][1] = 0;
        productArr[0][2] = 0;
        productArr[1][0] = 0;
        productArr[1][1] = 0;
        productArr[1][2] = 0;
        productArr[2][0] = 0;
        productArr[2][1] = 0;
        productArr[2][2] = 0;

        assertTrue(Arrays.deepEquals(productArr, this.fileExtractorZero.matrixProduct()));
    }

    @Test
    void testMatrixProduct3() {
        double[][] productArr = new double[3][3];
        productArr[0][0] = 7.0;
        productArr[0][1] = 9.0;
        productArr[0][2] = 4.0;
        productArr[1][0] = 2.0;
        productArr[1][1] = 2.0;
        productArr[1][2] = 1.0;
        productArr[2][0] = 3.0;
        productArr[2][1] = 4.0;
        productArr[2][2] = 4.0;

        assertTrue(Arrays.deepEquals(productArr, this.fileExtractorIdentity.matrixProduct()));
    }

    @Test
    void testMListProduct1() {
        List<List<Double> > productLst = new ArrayList<>();
        productLst.add(new ArrayList<Double>());
        productLst.add(new ArrayList<Double>());
        productLst.add(new ArrayList<Double>());

        productLst.get(0).add(43.0);
        productLst.get(0).add(70.0);
        productLst.get(0).add(141.0);
        productLst.get(1).add(11.0);
        productLst.get(1).add(19.0);
        productLst.get(1).add(36.0);
        productLst.get(2).add(21.0);
        productLst.get(2).add(37.0);
        productLst.get(2).add(75.0);

        List<List<Double> > actualProduct = this.fileExtractor.mListProduct();

        assertAll (
            () -> assertTrue(actualProduct.get(0).get(0).equals(productLst.get(0).get(0))),
            () -> assertTrue(actualProduct.get(0).get(1).equals(productLst.get(0).get(1))),
            () -> assertTrue(actualProduct.get(0).get(2).equals(productLst.get(0).get(2))),
            () -> assertTrue(actualProduct.get(1).get(0).equals(productLst.get(1).get(0))),
            () -> assertTrue(actualProduct.get(1).get(1).equals(productLst.get(1).get(1))),
            () -> assertTrue(actualProduct.get(1).get(2).equals(productLst.get(1).get(2))),
            () -> assertTrue(actualProduct.get(2).get(0).equals(productLst.get(2).get(0))),
            () -> assertTrue(actualProduct.get(2).get(1).equals(productLst.get(2).get(1))),
            () -> assertTrue(actualProduct.get(2).get(2).equals(productLst.get(2).get(2)))
        );
    }

    @Test
    void testMListProduct2() {
        List<List<Double> > productLst = new ArrayList<>();
        productLst.add(new ArrayList<Double>());
        productLst.add(new ArrayList<Double>());
        productLst.add(new ArrayList<Double>());

        productLst.get(0).add(0.0);
        productLst.get(0).add(0.0);
        productLst.get(0).add(0.0);
        productLst.get(1).add(0.0);
        productLst.get(1).add(0.0);
        productLst.get(1).add(0.0);
        productLst.get(2).add(0.0);
        productLst.get(2).add(0.0);
        productLst.get(2).add(0.0);

        List<List<Double> > actualProduct = this.fileExtractorZero.mListProduct();

        assertAll (
            () -> assertTrue(actualProduct.get(0).get(0).equals(productLst.get(0).get(0))),
            () -> assertTrue(actualProduct.get(0).get(1).equals(productLst.get(0).get(1))),
            () -> assertTrue(actualProduct.get(0).get(2).equals(productLst.get(0).get(2))),
            () -> assertTrue(actualProduct.get(1).get(0).equals(productLst.get(1).get(0))),
            () -> assertTrue(actualProduct.get(1).get(1).equals(productLst.get(1).get(1))),
            () -> assertTrue(actualProduct.get(1).get(2).equals(productLst.get(1).get(2))),
            () -> assertTrue(actualProduct.get(2).get(0).equals(productLst.get(2).get(0))),
            () -> assertTrue(actualProduct.get(2).get(1).equals(productLst.get(2).get(1))),
            () -> assertTrue(actualProduct.get(2).get(2).equals(productLst.get(2).get(2)))
        );
    }

    @Test
    void testMListProduct3() {
        List<List<Double> > productLst = new ArrayList<>();
        productLst.add(new ArrayList<Double>());
        productLst.add(new ArrayList<Double>());
        productLst.add(new ArrayList<Double>());

        productLst.get(0).add(7.0);
        productLst.get(0).add(9.0);
        productLst.get(0).add(4.0);
        productLst.get(1).add(2.0);
        productLst.get(1).add(2.0);
        productLst.get(1).add(1.0);
        productLst.get(2).add(3.0);
        productLst.get(2).add(4.0);
        productLst.get(2).add(4.0);

        List<List<Double> > actualProduct = this.fileExtractorIdentity.mListProduct();

        assertAll (
            () -> assertTrue(actualProduct.get(0).get(0).equals(productLst.get(0).get(0))),
            () -> assertTrue(actualProduct.get(0).get(1).equals(productLst.get(0).get(1))),
            () -> assertTrue(actualProduct.get(0).get(2).equals(productLst.get(0).get(2))),
            () -> assertTrue(actualProduct.get(1).get(0).equals(productLst.get(1).get(0))),
            () -> assertTrue(actualProduct.get(1).get(1).equals(productLst.get(1).get(1))),
            () -> assertTrue(actualProduct.get(1).get(2).equals(productLst.get(1).get(2))),
            () -> assertTrue(actualProduct.get(2).get(0).equals(productLst.get(2).get(0))),
            () -> assertTrue(actualProduct.get(2).get(1).equals(productLst.get(2).get(1))),
            () -> assertTrue(actualProduct.get(2).get(2).equals(productLst.get(2).get(2)))
        );
    }
}
