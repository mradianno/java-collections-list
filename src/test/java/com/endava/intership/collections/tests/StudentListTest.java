package com.endava.intership.collections.tests;

import com.endava.internship.collections.Student;
import com.endava.internship.collections.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StudentListTest {
    StudentList list;

    Student[] studentsArray = {
            new Student("Adrian", LocalDate.of(2000, 10, 18), "test"),
            new Student("Adrian2", LocalDate.of(2000, 10, 18), "test"),
            new Student("Adrian3", LocalDate.of(2000, 10, 18), "test")
    };

    @BeforeEach
    void setUp() {
        list = new StudentList();
    }

    void fillListWithElements() {
        for (Student student : studentsArray) {
            list.add(student);
        }
    }

    @Test
    void addStudentsInStudentList() {
        fillListWithElements();

        assertFalse(list.isEmpty());
        assertEquals(3, list.getSize());
    }

    @Test
    void containsMethod() {
        fillListWithElements();

        assertTrue(list.contains(new Student("Adrian", LocalDate.of(2000, 10, 18), "test")));
        assertFalse(list.contains(new Student("Adrian", LocalDate.of(2001, 11, 18), "test")));
    }

    @Test
    void toArrayMethod() {
        fillListWithElements();

        assertArrayEquals(studentsArray, list.toArray());
    }

    @Test
    void clearMethod() {
        fillListWithElements();

        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void indexOfAndGetMethods() {
        fillListWithElements();
        int index = 1;

        assertEquals(index, list.indexOf(studentsArray[index]));

        assertEquals(studentsArray[index], list.get(index));
        assertEquals(new Student("Adrian2", LocalDate.of(2000, 10, 18), "test"), list.get(index));
    }

    @Test
    void setMethod() {
        fillListWithElements();
        int index = 1;

        Student oldValue = list.set(index, new Student("ION", LocalDate.of(2000, 10, 18), "test"));

        assertEquals("Adrian2", oldValue.getName());
        assertEquals("ION", list.get(index).getName());

    }

    @Test
    void removeMethod() {
        fillListWithElements();
        int index = 1;
        int secondIndex = 2;

        list.remove(index);
        assertFalse(list.contains(studentsArray[index]));

        list.remove(studentsArray[secondIndex]);
        assertFalse(list.contains(studentsArray[secondIndex]));

    }

    @Test
    void addAllMethod() {
        list.addAll(Arrays.asList(studentsArray));

        assertArrayEquals(studentsArray,list.toArray());
    }

}
