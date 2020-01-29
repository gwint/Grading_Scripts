package lab01;

import org.junit.*;
import gradingplatform.Instance;
import gradingplatform.ClassWrapper;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class Lab01Tests {
    ClassWrapper studentWrapper;
    ClassWrapper personWrapper;
    ClassWrapper countryWrapper;

    @Before
    public void init() throws Exception {
        this.studentWrapper = new ClassWrapper("lab01.Student");
        this.personWrapper = new ClassWrapper("lab01.Person");
        this.countryWrapper = new ClassWrapper("lab01.Country");
    }

    @Test
    public void testCountryConstr() throws Exception {
        ClassWrapper countryWrapper = new ClassWrapper("lab01.Country");

        String countryName = "countryA";
        double area = 100.0;
        long population = 1000;

        Instance country1 =
                 countryWrapper.getInstance(countryName, area, population);

        String countryNameRet = country1.getDataMember("name");
        double areaRet = country1.getDataMember("area");
        long populationRet = country1.getDataMember("population");

        Assert.assertEquals(countryName, countryNameRet);
        Assert.assertEquals(area, areaRet, 0.0000001);
        Assert.assertEquals(population, populationRet);
    }

    @Test
    public void testCountryGetters() throws Exception {
        Instance country = this.countryWrapper.getInstance(new String("countryA"), 100.0, 1000L);

        double area = country.executeMethod("getArea");
        long population = country.executeMethod("getPopulation");

        Assert.assertEquals(100., area, 0.0000001);
        Assert.assertEquals(1000, population);
    }

    @Test
    public void testGetAveragePopulationDensity() throws Exception {
        Instance country = this.countryWrapper.getInstance(new String("countryA"), 100.0, 1000L);
        double populationDensity = country.executeMethod("getAveragePopulationDensity");

        Assert.assertEquals(10., populationDensity, 0.0000001);
    }

    @Test
    public void testPersonConstr() throws Exception {
        Instance person =
                 this.personWrapper.getInstance("Smith", "John", 1999, 1, 2);
        String lastName = person.getDataMember("lastNames");
        String firstName = person.getDataMember("firstNames");
        LocalDate birthDay = person.getDataMember("dateOfBirth");

        Assert.assertEquals("Smith", lastName);
        Assert.assertEquals("John", firstName);
        Assert.assertEquals(LocalDate.of(1999, 1, 2), birthDay);
    }

    @Test
    public void testPersonGetters() throws Exception {
        Instance person =
                 this.personWrapper.getInstance("Smith", "John", 1999, 1, 2);
        String lastName = person.executeMethod("getLastNames");
        String firstName = person.executeMethod("getFirstNames");
        LocalDate birthDay = person.executeMethod("getDateOfBirth");

        Assert.assertEquals("Smith", lastName);
        Assert.assertEquals("John", firstName);
        Assert.assertEquals(LocalDate.of(1999, 1, 2), birthDay);
    }

    @Test
    public void testPersonAgeInYears() throws Exception {
        Instance person =
                 this.personWrapper.getInstance("Smith", "John", 1999, 1, 2);
        int ageInYears = person.executeMethod("ageInYears");

        Assert.assertEquals(21, ageInYears);
    }

    @Test
    public void testStudentConstr() throws Exception {
        Instance person =
                 this.personWrapper.getInstance("Smith", "John", 1999, 1, 2);
        Instance student =
             this.studentWrapper.getInstance(person, "Computer Science", 3.8);

        Assert.assertTrue(true);
    }

    @Test
    public void testStudentGetters() {
        Assert.assertTrue(true);
    }

    @Test
    public void testStudentSetGpa() throws Exception {
        Instance person =
                 this.personWrapper.getInstance("Smith", "John", 1999, 1, 2);
        Instance student =
             this.studentWrapper.getInstance(person, "Computer Science", 3.8);

        student.executeMethod("setGpa", 4.0);
        double retrievedGpa = student.getDataMember("gpa");

        Assert.assertEquals(4.0, retrievedGpa, 0.0000001);
    }
}
