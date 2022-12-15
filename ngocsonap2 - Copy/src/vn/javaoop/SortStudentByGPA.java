package vn.javaoop;

import java.util.Comparator;

/**
 * SortStudentByGPA class
 * 
 * @author ADMIN
 */
public class SortStudentByGPA implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getGpa() > student2.getGpa()) {
            return 1;
        }
        return -1;
    }
}
