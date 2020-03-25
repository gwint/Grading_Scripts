package assignment03;

import org.junit.*;
import wrapper.Instance;
import wrapper.ClassWrapper;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Assignment03Tests {

    @Test
    public void testAppendArray() throws Exception {
        ClassWrapper assignment03Wrapper =
                         new ClassWrapper("assignment03.Assignment03");
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2,3,4));
        int[] arr = new int[]{5,6};

        Object[] args = assignment03Wrapper.executeMethod("appendArray", lst, arr);

        Assert.assertEquals(args[0], new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test(expected = InvocationTargetException.class)
    public void testAppendArrayNull() throws Exception {
        ClassWrapper assignment03Wrapper =
                         new ClassWrapper("assignment03.Assignment03");
        List<Integer> lst = new ArrayList<>(Arrays.asList(1,2,3,4));
        Object[] args = assignment03Wrapper.executeMethod("appendArray", lst, null);
    }

    @Test
    public void testSumElementWise() throws Exception {
        ClassWrapper assignment03Wrapper =
                         new ClassWrapper("assignment03.Assignment03");
        List<Integer> lst1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> lst2 = new ArrayList<>(Arrays.asList(-1,-2,-3,-4,-5));

        List<Integer> allZeroes = assignment03Wrapper.executeMethod("sumElementWise", lst1, lst2);

        Assert.assertEquals(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)), allZeroes);
    }

    @Test(expected = InvocationTargetException.class)
    public void testSumElementWiseNull() throws Exception {
        ClassWrapper assignment03Wrapper =
                         new ClassWrapper("assignment03.Assignment03");
        List<Integer> lst1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> lst2 = null;

        List<Integer> allZeroes = assignment03Wrapper.executeMethod("sumElementWise", lst1, lst2);
    }

    @Test
    public void testGetClassRoster() throws Exception {
        ClassWrapper personWrapper = new ClassWrapper("assignment03.Person");
        ClassWrapper studentWrapper = new ClassWrapper("assignment03.Student");
        ClassWrapper rosterWrapper = new ClassWrapper("assignment03.Roster");

        Instance personInstance = personWrapper.getInstance("last", "first", 1,1,1);
        Instance studentInstance = studentWrapper.getInstance(personInstance, "comp sci", 4.0, "B001234");
        Instance rosterInstance = rosterWrapper.getInstance();

        List<Object> roster = rosterInstance.executeMethod("getClassRoster");

        Assert.assertTrue(roster.size() == 0);
    }

    @Test
    public void testAddStudent() throws Exception {
        ClassWrapper personWrapper = new ClassWrapper("assignment03.Person");
        ClassWrapper studentWrapper = new ClassWrapper("assignment03.Student");
        ClassWrapper rosterWrapper = new ClassWrapper("assignment03.Roster");

        Instance personInstance = personWrapper.getInstance("last", "first", 1,1,1);
        Instance studentInstance = studentWrapper.getInstance(personInstance, "comp sci", 4.0, "B001234");
        Instance rosterInstance = rosterWrapper.getInstance();

        List<Object> rosterBefore =
                             rosterInstance.getDataMember("classRoster");
        Assert.assertTrue(rosterBefore.size() == 0);

        rosterInstance.executeMethod("addStudent", studentInstance);

        List<Object> rosterAfter =
                             rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 1);
    }

    @Test
    public void testDropStudent() throws Exception {
        ClassWrapper personWrapper = new ClassWrapper("assignment03.Person");
        ClassWrapper studentWrapper = new ClassWrapper("assignment03.Student");
        ClassWrapper rosterWrapper = new ClassWrapper("assignment03.Roster");

        Instance personInstance = personWrapper.getInstance("last", "first", 1,1,1);
        Instance studentInstance =
         studentWrapper.getInstance(personInstance, "comp sci", 4.0, "B001234");
        Instance rosterInstance = rosterWrapper.getInstance();

        List<Object> rosterBefore =
                             rosterInstance.getDataMember("classRoster");
        Assert.assertTrue(rosterBefore.size() == 0);

        rosterInstance.executeMethod("addStudent", studentInstance);

        List<Object> rosterAfter =
                             rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 1);

        rosterInstance.executeMethod("dropStudent", "B0012345");

        rosterAfter = rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 1);

        rosterInstance.executeMethod("dropStudent", "B001234");

        rosterAfter = rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 0);
    }

    @Test
    public void testDropStudent1() throws Exception {
        ClassWrapper personWrapper = new ClassWrapper("assignment03.Person");
        ClassWrapper studentWrapper = new ClassWrapper("assignment03.Student");
        ClassWrapper rosterWrapper = new ClassWrapper("assignment03.Roster");

        Instance personInstance = personWrapper.getInstance("last", "first", 1,1,1);
        Instance studentInstance =
         studentWrapper.getInstance(personInstance, "comp sci", 4.0, "B001234");
        Instance rosterInstance = rosterWrapper.getInstance();

        List<Object> rosterBefore =
                             rosterInstance.getDataMember("classRoster");
        Assert.assertTrue(rosterBefore.size() == 0);

        rosterInstance.executeMethod("addStudent", studentInstance);

        List<Object> rosterAfter =
                             rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 1);

        rosterInstance.executeMethod("dropStudent", "B0012345");

        rosterAfter = rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 1);

        rosterInstance.executeMethod("dropStudent", "B001234");

        rosterAfter = rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 0);
    }

    @Test
    public void testDropStudent2() throws Exception {
        ClassWrapper personWrapper = new ClassWrapper("assignment03.Person");
        ClassWrapper studentWrapper = new ClassWrapper("assignment03.Student");
        ClassWrapper rosterWrapper = new ClassWrapper("assignment03.Roster");

        Instance personInstance = personWrapper.getInstance("last", "first", 1,1,1);
        Instance studentInstance =
         studentWrapper.getInstance(personInstance, "comp sci", 4.0, "B001234");
        Instance rosterInstance = rosterWrapper.getInstance();

        List<Object> rosterBefore =
                             rosterInstance.getDataMember("classRoster");
        Assert.assertTrue(rosterBefore.size() == 0);

        rosterInstance.executeMethod("addStudent", studentInstance);

        List<Object> rosterAfter =
                             rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 1);

        rosterInstance.executeMethod("dropStudent", "B0012345");

        rosterAfter = rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 1);

        rosterInstance.executeMethod("dropStudent", "B001234");

        rosterAfter = rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 0);
    }

    @Test
    public void testSortByBNum() throws Exception {
        ClassWrapper personWrapper = new ClassWrapper("assignment03.Person");
        ClassWrapper studentWrapper = new ClassWrapper("assignment03.Student");
        ClassWrapper rosterWrapper = new ClassWrapper("assignment03.Roster");

        Instance personInstance = personWrapper.getInstance("last", "first", 1,1,1);
        Instance studentInstance = studentWrapper.getInstance(personInstance, "comp sci", 4.0, "B001234");
        Instance studentInstance1 = studentWrapper.getInstance(personInstance, "comp sci", 1.3, "B001236");
        Instance studentInstance2 = studentWrapper.getInstance(personInstance, "comp sci", 1.3, "B001230");
        Instance studentInstance3 = studentWrapper.getInstance(personInstance, "comp sci", 1.3, "B001229");

        Instance rosterInstance = rosterWrapper.getInstance();

        List<Object> rosterBefore =
                             rosterInstance.getDataMember("classRoster");
        Assert.assertTrue(rosterBefore.size() == 0);

        rosterInstance.executeMethod("addStudent", studentInstance);
        rosterInstance.executeMethod("addStudent", studentInstance1);
        rosterInstance.executeMethod("addStudent", studentInstance2);
        rosterInstance.executeMethod("addStudent", studentInstance3);

        List<Object> rosterAfter =
                             rosterInstance.getDataMember("classRoster");

        Assert.assertTrue(rosterAfter.size() == 4);

        rosterInstance.executeMethod("sortByBNum");

        rosterAfter = rosterInstance.getDataMember("classRoster");

        Assert.assertEquals(studentInstance3.getObj(), rosterAfter.get(0));
        Assert.assertEquals(studentInstance2.getObj(), rosterAfter.get(1));
        Assert.assertEquals(studentInstance.getObj(), rosterAfter.get(2));
        Assert.assertEquals(studentInstance1.getObj(), rosterAfter.get(3));
    }
}
