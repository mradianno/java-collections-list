package com.endava.internship.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList();

        students.add(new Student("Adrian", LocalDate.of(2000, 10, 18), "test"));
        students.add(new Student("Ion", LocalDate.of(2000, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Mihai", LocalDate.of(2002, 10, 18), "test"));
        students.add(new Student("Adrian2", LocalDate.of(1999, 10, 18), "test"));

        StudentList studentsList = new StudentList(students);
//        studentsList.remove(2);
        studentsList.add(2, new Student("Ion2s", LocalDate.of(2000, 10, 18), "test"));
        Iterator<Student> stIterator = studentsList.iterator();
        while (stIterator.hasNext()) {
            System.out.println(stIterator.next().getName());
        }
        System.out.println("Finish");
    }
}
