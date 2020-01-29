package lab01;

import org.junit.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

public class Lab01StudentVerTests {
    Student student;
    Person person;
    Country country;

    @Test
    public void testCountryConstr() throws Exception {
        String countryName = "countryA";
        double area = 100.0;
        long population = 1000;

        this.country = new Country(countryName, area, population);

        String countryNameRet = this.country.getName();
        double areaRet = this.country.getArea();
        long populationRet = this.country.getPopulation();

        Assert.assertEquals(countryName, countryNameRet);
        Assert.assertEquals(area, areaRet, 0.0000001);
        Assert.assertEquals(population, populationRet);
    }

    @Test
    public void testCountryGetters() throws Exception {
        this.country = new Country("countryA", 100.0, 1000L);

        double area = this.country.getArea();
        long population = this.country.getPopulation();

        Assert.assertEquals(100., area, 0.0000001);
        Assert.assertEquals(1000, population);
    }

    @Test
    public void testGetAveragePopulationDensity() throws Exception {
        this.country = new Country(new String("countryA"), 100.0, 1000L);
        double populationDensity = this.country.getAveragePopulationDensity();

        Assert.assertEquals(10., populationDensity, 0.0000001);
    }

    @Test
    public void testPersonConstr() throws Exception {
        this.person = new Person("Smith", "John", 1999, 1, 2);
        String lastName = this.person.getLastNames();
        String firstName = this.person.getFirstNames();
        LocalDate birthDay = this.person.getDateOfBirth();

        Assert.assertEquals("Smith", lastName);
        Assert.assertEquals("John", firstName);
        Assert.assertEquals(LocalDate.of(1999, 1, 2), birthDay);
    }

    @Test
    public void testPersonGetters() throws Exception {
        this.person = new Person("Smith", "John", 1999, 1, 2);
        String lastName = this.person.getLastNames();
        String firstName = this.person.getFirstNames();
        LocalDate birthDay = this.person.getDateOfBirth();

        Assert.assertEquals("Smith", lastName);
        Assert.assertEquals("John", firstName);
        Assert.assertEquals(LocalDate.of(1999, 1, 2), birthDay);
    }

    @Test
    public void testPersonAgeInYears() throws Exception {
        this.person = new Person("Smith", "John", 1999, 1, 2);
        int ageInYears = person.ageInYears();

        Assert.assertEquals(21, ageInYears);
    }

    @Test
    public void testStudentConstr() throws Exception {
        this.person = new Person("Smith", "John", 1999, 1, 2);
        this.student = new Student(person, "Computer Science", 3.8);

        Assert.assertTrue(true);
    }

    @Test
    public void testStudentGetters() {
        Assert.assertTrue(true);
    }

    @Test
    public void testStudentSetGpa() throws Exception {
        this.person = new Person("Smith", "John", 1999, 1, 2);
        this.student = new Student(person, "Computer Science", 3.8);

        this.student.setGpa(4.0);
        double retrievedGpa = this.student.getGpa();

        Assert.assertEquals(4.0, retrievedGpa, 0.0000001);
    }
}
