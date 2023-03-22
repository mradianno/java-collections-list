package com.endava.internship.collections;

import java.util.*;


public class StudentList implements List<Student> {
    private int size;

    public int getSize() {
        return size;
    }

    private Student[] students;


    public StudentList() {
        students = new Student[10];
        size = 0;
    }

    public StudentList(int capacity) {
        super();
        if (capacity < 0) throw new IllegalArgumentException();

        this.students = new Student[capacity];
    }

    public StudentList(Collection<Student> students) {
        super();
        if (students == null) throw new NullPointerException();

        this.addAll(students);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }

    @Override
    public Iterator<Student> iterator() {

        return new StudentIterator();
    }

    private class StudentIterator implements Iterator<Student> {
        int current = 0;

        StudentIterator() {
        }

        @Override
        public boolean hasNext() {
            return this.current != size;
        }

        @Override
        public Student next() {
            return students[current++];
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.students, this.size);
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return (T[]) Arrays.copyOf(this.students, this.size, ts.getClass());
    }

    @Override
    public boolean add(Student student) {
        extendArrayLengthIfNeeded();

        this.students[this.size++] = student;
        return true;
    }

    private void extendArrayLengthIfNeeded() {
        if (this.size == this.students.length) {
            this.students = Arrays.copyOf(this.students, this.students.length * 2);
        }
    }

    @Override
    public void clear() {
        size = 0;
        this.students = new Student[10];
    }

    @Override
    public Student get(int i) {
        return this.students[i];
    }

    @Override
    public Student set(int i, Student student) {
        if (i > this.size)
            throw new IndexOutOfBoundsException();

        Student oldValue = this.students[i];
        this.students[i] = student;
        return oldValue;
    }

    @Override
    public void add(int i, Student student) {
        extendArrayLengthIfNeeded();
        System.arraycopy(this.students, i, this.students, i + 1, this.size + 1);
        this.size++;
        this.students[i] = student;
    }

    @Override
    public Student remove(int i) {
        Student oldValue = this.students[i];

        System.arraycopy(this.students, i + 1, this.students, i, --this.size);

        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        int studentIndex = this.indexOf(o);
        return this.remove(studentIndex) != null;
    }

    @Override
    public int indexOf(Object o) {
        if (o instanceof Student) {
            for (int i = 0; i < this.size; i++) {
                if (this.students[i].equals(o))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = this.size; i >= 0; i--) {
            if (this.students[i].equals(o))
                return i;
        }

        return -1;
    }

    @Override
    public ListIterator<Student> listIterator() {
        return new StudentListIterator();
    }

    @Override
    public ListIterator<Student> listIterator(int i) {

        return new StudentListIterator(i);
    }

    private class StudentListIterator extends StudentIterator implements ListIterator<Student> {
        public StudentListIterator(int index) {
            super();
            current = index;
        }

        public StudentListIterator() {

        }

        @Override
        public boolean hasPrevious() {
            return current != 0;
        }

        @Override
        public Student previous() {
            return students[--current];
        }

        @Override
        public int nextIndex() {
            return current;
        }

        @Override
        public int previousIndex() {
            return current - 1;
        }

        @Override
        public void remove() {
            StudentList.this.remove(current);
            current--;
        }

        @Override
        public void set(Student student) {
            StudentList.this.set(current, student);
        }

        @Override
        public void add(Student student) {
            StudentList.this.add(current, student);
            current++;
        }
    }

    @Override
    public List<Student> subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends Student> collection) {
        if (collection.size() == 0)
            return false;

        for (Student student : collection) {
            this.add(student);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int i, Collection<? extends Student> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }
}
