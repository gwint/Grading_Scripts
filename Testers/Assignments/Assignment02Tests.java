package assignment02;

import org.junit.*;
import wrapper.Instance;
import wrapper.ClassWrapper;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;

public class Assignment02Tests {

    @Test
    public void testMostPages() throws Exception {
        ClassWrapper libraryWrapper = new ClassWrapper("assignment02.Library");
        ClassWrapper bookWrapper = new ClassWrapper("assignment02.Book");

        Instance[] bookInstanceArr = new Instance[]{
            bookWrapper.getInstance("Title 1", 100),
            bookWrapper.getInstance("Title 2", 200),
            bookWrapper.getInstance("Title 3", 300)
        };

        int largestPageCount =
             libraryWrapper.executeMethod("mostPages",
                                               new Object[]{bookInstanceArr});

        Assert.assertEquals(300, largestPageCount);
    }

    @Test
    public void testNumPagesInLibrary() throws Exception {
        ClassWrapper libraryWrapper = new ClassWrapper("assignment02.Library");
        ClassWrapper bookWrapper = new ClassWrapper("assignment02.Book");

        Instance[] bookInstanceArr = new Instance[]{
            bookWrapper.getInstance("Title 1", 100),
            bookWrapper.getInstance("Title 2", 200),
            bookWrapper.getInstance("Title 3", 300)
        };

        int totalPageCount =
             libraryWrapper.executeMethod("numPagesInLibrary",
                                               new Object[]{bookInstanceArr});

        Assert.assertEquals(600, totalPageCount);
    }

    @Test
    public void testMakeStringArray() throws Exception {
        ClassWrapper question2Wrapper = new ClassWrapper("assignment02.Question2");

        Instance question2Instance = question2Wrapper.getInstance(5);

        String[] strArr = question2Instance.executeMethod("makeStringArray");

        Assert.assertNotNull(strArr);

        for(int i = 0; i < strArr.length; i++) {
            Assert.assertNotNull(strArr[i]);
            Assert.assertTrue(strArr[i].length() == i + 1);

            byte[] bytes = strArr[i].getBytes();
            for(int j = 0; j < bytes.length; j++) {
                Assert.assertTrue(bytes[j] >= 65 && bytes[j] <= 90);
            }
        }

        Assert.assertTrue(true);
    }

    @Test
    public void testTriangleArray() throws Exception {
        ClassWrapper question2Wrapper =
                             new ClassWrapper("assignment02.Question2");

        Instance question2Instance = question2Wrapper.getInstance(5);

        int[][] triangleArr =
                       question2Instance.executeMethod("makeTriangleArray");

        Assert.assertNotNull(triangleArr);

        for(int i = 0; i < triangleArr.length; i++) {
            Assert.assertNotNull(triangleArr[i]);
            Assert.assertTrue(triangleArr[i].length == i + 1);
        }
    }

    @Test
    public void testMakeSymmetricArray() throws Exception {
        ClassWrapper question2Wrapper = new ClassWrapper("assignment02.Question2");

        Instance question2Instance = question2Wrapper.getInstance(4);
        int[][] squareMatrix =
                     question2Instance.executeMethod("makeSymmetricArray");


        System.out.println(Arrays.deepToString(squareMatrix));
        for(int i = 0; i < squareMatrix.length; i++) {
            for(int j = 0; j < squareMatrix[i].length; j++) {
                Assert.assertEquals(squareMatrix[i][j], squareMatrix[j][i]);
            }
        }
    }

    @Test
    public void testMakePascalTriangle() throws Exception {
        ClassWrapper question2Wrapper =
                             new ClassWrapper("assignment02.Question2");

        Instance question2Instance = question2Wrapper.getInstance(4);
        int[][] pascalsTriangle =
                     question2Instance.executeMethod("makePascalTriangle");

        Assert.assertEquals(1, pascalsTriangle[0][0]);

        for(int row = 1; row < pascalsTriangle.length - 1; row++) {
            Assert.assertEquals(1, pascalsTriangle[row][0]);
            Assert.assertEquals(1, pascalsTriangle[row][pascalsTriangle[row].length-1]);

            for(int col = 0; col < pascalsTriangle[row].length-1; col++) {
                int actualSum = pascalsTriangle[row][col] +
                               pascalsTriangle[row][col+1];
                Assert.assertEquals(pascalsTriangle[row+1][col+1], actualSum);
            }
        }
    }

    @Test
    public void testMakeRowMajor() throws Exception {
        ClassWrapper question2Wrapper = new ClassWrapper("assignment02.Question2");

        int[][] nums = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };

        int[] numsSingleFile =
                question2Wrapper.executeMethod("makeRowMajor",
                                                    new Object[]{nums});

        int[] expectedNumsSingleFile = new int[] {
            3,4,1,2,3,4,5,6,7,8,9,10,11,12
        };

        Assert.assertArrayEquals(expectedNumsSingleFile, numsSingleFile);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMakeRowMajorNull() throws Exception {
        ClassWrapper question2Wrapper = new ClassWrapper("assignment02.Question2");

        question2Wrapper.executeMethod("", null);
    }

    @Test
    public void testUnfoldRowMajor() throws Exception {
        ClassWrapper question2Wrapper = new ClassWrapper("assignment02.Question2");

        int[] numsSingleFile = new int[] {
            3,4,1,2,3,4,5,6,7,8,9,10,11,12
        };

        int[][] nums2D = question2Wrapper.executeMethod("unfoldRowMajor",
                                                new Object[]{numsSingleFile});

        int[][] expectedNums2D = new int[][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };

        Assert.assertArrayEquals(expectedNums2D, nums2D);
    }

    @Test
    public void testSortByGPA() throws Exception {
        ClassWrapper personWrapper = new ClassWrapper("assignment02.Person");
        ClassWrapper studentWrapper =
                             new ClassWrapper("assignment02.Student");
        ClassWrapper personStudentTestWrapper =
                         new ClassWrapper("assignment02.PersonStudentTest");

        Instance[] studentInstances = new Instance[] {
            studentWrapper.getInstance(personWrapper.getInstance("A", "B", 1, 2, 3),
                                       "Computer Science", 3.4),
            studentWrapper.getInstance(personWrapper.getInstance("D", "E", 1, 4, 3),
                                       "Computer Science", 3.2),
            studentWrapper.getInstance(personWrapper.getInstance("H", "I", 1, 2, 3),
                                       "Computer Science", 4.0),
            studentWrapper.getInstance(personWrapper.getInstance("J", "K", 1, 2, 3),
                                       "Computer Science", 1.2),
            studentWrapper.getInstance(personWrapper.getInstance("L", "M", 1, 2, 3),
                                       "Computer Science", 3.7)
        };

        Object[] underlyingStudents =
                    personStudentTestWrapper.executeMethod("sortByGpa",
                                                      new Object[]{studentInstances});


        for(int i = 1; i < underlyingStudents.length; i++) {
            Instance student1 = new Instance(underlyingStudents[i-1]);
            Instance student2 = new Instance(underlyingStudents[i]);

            double student1Gpa = student1.getDataMember("gpa");
            double student2Gpa = student2.getDataMember("gpa");

            Assert.assertTrue(student1Gpa <= student2Gpa);
        }
    }
}
