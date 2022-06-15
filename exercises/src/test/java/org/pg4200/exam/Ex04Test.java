package org.pg4200.exam;

import org.junit.jupiter.api.Test;
import org.pg4200.exam.ex04extraClasses.Course;
import org.pg4200.exam.ex04extraClasses.Program;
import org.pg4200.exam.ex04extraClasses.Student;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex04Test {
    @Test
    void test(){
        Program p = new Program();

        Course c = new Course();

        p.courses = new ArrayList<>();
        p.courses.add(c);

        Student s = new Student("Harald", "Hadrada", 1066);

        c.students = new HashMap<>();
        c.students.put(1066 , s);
        c.students.put(1823 ,new Student("Nicolas", "Davout", 1823));


        Course c2 = new Course();
        p.courses.add(c2);
        c2.students = new HashMap<>();
        c2.students.put(1066, s);

        ArrayList<String> list = new Ex04().ex04(p);

        for (String email:
                list) {
            System.out.println(email);
        }

        assertTrue(list.contains("HH66@hk.no"));
        assertTrue(list.contains("ND23@hk.no"));
        assertEquals(2, list.size());
    }
}
