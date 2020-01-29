package assignment03;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Assignment3Tests {
    ClassRoom classroom;

	@BeforeEach
	void setUp() throws Exception {
        this.classroom = new ClassRoom();
        Student a = new Student(5, "Gina");
        Student b = new Student(4, "Tyler");
        Student c = new Student(3, "Arnold");
        Student d = new Student(2, "Jessica");
        Student e = new Student(1, "Richard");

        this.classroom.addStudent(a);
        this.classroom.addStudent(b);
        this.classroom.addStudent(c);
        this.classroom.addStudent(d);
        this.classroom.addStudent(e);
	}

	@Test
	void testSortById1() {
        List<Student> students = new ArrayList<>(
            Arrays.asList(
                new Student(4, "first"),
                new Student(1, "second"),
                new Student(3, "third"),
                new Student(2, "forth")
            )
        );

        ClassRoom.sortById(students);

        assertAll (
            () -> assertEquals("second", students.get(0).getName()),
            () -> assertEquals("forth", students.get(1).getName()),
            () -> assertEquals("third", students.get(2).getName()),
            () -> assertEquals("first", students.get(3).getName())
        );
	}

	@Test
	void testSortById2() {
        List<Student> students = new ArrayList<>(
            Arrays.asList(
                new Student(1, "first"),
                new Student(2, "second"),
                new Student(3, "third"),
                new Student(4, "forth")
            )
        );

        ClassRoom.sortById(students);

        assertAll (
            () -> assertEquals("first", students.get(0).getName()),
            () -> assertEquals("second", students.get(1).getName()),
            () -> assertEquals("third", students.get(2).getName()),
            () -> assertEquals("forth", students.get(3).getName())
        );
	}

	@Test
	void testIsRegistered1() {
        assertTrue(this.classroom.isRegistered(1));
	}

	@Test
	void testIsRegistered2() {
        assertFalse(this.classroom.isRegistered(-1));
	}

    private static boolean contains(List<Student> studentList, Student student) {
        for(Student stud : studentList) {
            if(stud.getId() == student.getId())
                return true;
        }

        return false;
    }

	@Test
	void testRegisteredInAll1() {
        Student a = new Student(5, "Gina");
        Student b = new Student(4, "Tyler");
        Student c = new Student(3, "Arnold");
        Student d = new Student(2, "Jessica");
        Student e = new Student(1, "Richard");

        ClassRoom classroom1 = new ClassRoom();
        classroom1.addStudent(a);
        classroom1.addStudent(b);
        classroom1.addStudent(c);
        classroom1.addStudent(d);
        classroom1.addStudent(e);

        ClassRoom classroom2 = new ClassRoom();
        classroom2.addStudent(a);
        classroom2.addStudent(b);
        classroom2.addStudent(c);

        ClassRoom classroom3 = new ClassRoom();
        classroom3.addStudent(b);
        classroom3.addStudent(c);

        List<Student> containedInAll =
             ClassRoom.registeredInAll(classroom1, classroom2, classroom3);

        assertAll (
            () -> assertTrue(Assignment3Tests.contains(containedInAll, b)),
            () -> assertTrue(Assignment3Tests.contains(containedInAll, c)),
            () -> assertTrue(containedInAll.size() == 2)
        );
	}

	@Test
	void testRegisteredInAll2() {
        Student a = new Student(5, "Gina");
        Student b = new Student(4, "Tyler");
        Student c = new Student(3, "Arnold");
        Student d = new Student(2, "Jessica");
        Student e = new Student(1, "Richard");

        ClassRoom classroom1 = new ClassRoom();
        classroom1.addStudent(a);
        classroom1.addStudent(b);

        ClassRoom classroom2 = new ClassRoom();
        classroom2.addStudent(c);
        classroom2.addStudent(d);

        ClassRoom classroom3 = new ClassRoom();
        classroom3.addStudent(e);

        List<Student> containedInAll =
             ClassRoom.registeredInAll(classroom1, classroom2, classroom3);

        assertTrue(containedInAll.size() == 0);
	}

	@Test
	void testAlsoRegisteredIn1() {
        Student a = new Student(5, "Gina");
        Student b = new Student(4, "Tyler");
        Student c = new Student(3, "Arnold");
        Student d = new Student(2, "Jessica");
        Student e = new Student(1, "Richard");

        ClassRoom classroom1 = new ClassRoom();
        classroom1.addStudent(a);
        classroom1.addStudent(b);

        ClassRoom classroom2 = new ClassRoom();
        classroom2.addStudent(c);
        classroom2.addStudent(d);

        ClassRoom classroom3 = new ClassRoom();
        classroom3.addStudent(e);

        List<Student> containedInAll =
             classroom1.alsoRegisteredIn(classroom2, classroom3);

        assertTrue(containedInAll.size() == 0);
	}

	@Test
	void testAlsoRegisteredIn2() {
        Student a = new Student(5, "Gina");
        Student b = new Student(4, "Tyler");
        Student c = new Student(3, "Arnold");
        Student d = new Student(2, "Jessica");
        Student e = new Student(1, "Richard");

        ClassRoom classroom1 = new ClassRoom();
        classroom1.addStudent(a);
        classroom1.addStudent(b);
        classroom1.addStudent(c);
        classroom1.addStudent(d);
        classroom1.addStudent(e);

        ClassRoom classroom2 = new ClassRoom();
        classroom2.addStudent(a);
        classroom2.addStudent(b);
        classroom2.addStudent(c);

        ClassRoom classroom3 = new ClassRoom();
        classroom3.addStudent(b);
        classroom3.addStudent(c);

        List<Student> containedInAll =
             classroom1.alsoRegisteredIn(classroom2, classroom3);

        System.out.println(containedInAll.size());
        for(Student stud : containedInAll) {
            System.out.println(stud.getName());
        }
        assertTrue(containedInAll.size() == 2);
        assertAll (
            () -> assertTrue(Assignment3Tests.contains(containedInAll, b)),
            () -> assertTrue(Assignment3Tests.contains(containedInAll, c)),
            () -> assertTrue(containedInAll.size() == 2)
        );
	}

	@Test
	void testRegisteredInOne1() {
        Student a = new Student(5, "Gina");
        Student b = new Student(4, "Tyler");
        Student c = new Student(3, "Arnold");
        Student d = new Student(2, "Jessica");
        Student e = new Student(1, "Richard");

        ClassRoom classroom1 = new ClassRoom();

        classroom1.addStudent(a);
        classroom1.addStudent(b);

        ClassRoom classroom2 = new ClassRoom();
        classroom2.addStudent(c);
        classroom2.addStudent(d);

        ClassRoom classroom3 = new ClassRoom();
        classroom3.addStudent(e);

        List<Student> containedInAny =
             ClassRoom.registeredInOne(classroom1, classroom2, classroom3);

        assertAll (
            () -> assertTrue(containedInAny.get(4).getName() == "Gina"),
            () -> assertTrue(containedInAny.get(3).getName() == "Tyler"),
            () -> assertTrue(containedInAny.get(2).getName() == "Arnold"),
            () -> assertTrue(containedInAny.get(1).getName() == "Jessica"),
            () -> assertTrue(containedInAny.get(0).getName() == "Richard"),
            () -> assertTrue(containedInAny.size() == 5)
        );
	}

	@Test
	void testRegisteredInOne2() {
        Student a = new Student(5, "Gina");
        Student b = new Student(4, "Tyler");
        Student c = new Student(3, "Arnold");
        Student d = new Student(2, "Jessica");
        Student e = new Student(1, "Richard");

        ClassRoom classroom1 = new ClassRoom();
        classroom1.addStudent(a);
        classroom1.addStudent(b);
        classroom1.addStudent(c);

        ClassRoom classroom2 = new ClassRoom();
        classroom2.addStudent(c);
        classroom2.addStudent(d);

        ClassRoom classroom3 = new ClassRoom();
        classroom3.addStudent(d);
        classroom3.addStudent(e);

        List<Student> containedInAny =
             ClassRoom.registeredInOne(classroom1, classroom2, classroom3);

        assertAll (
            () -> assertTrue(containedInAny.get(4).getName() == "Gina"),
            () -> assertTrue(containedInAny.get(3).getName() == "Tyler"),
            () -> assertTrue(containedInAny.get(2).getName() == "Arnold"),
            () -> assertTrue(containedInAny.get(1).getName() == "Jessica"),
            () -> assertTrue(containedInAny.get(0).getName() == "Richard"),
            () -> assertTrue(containedInAny.size() == 5)
        );
	}
}
