package org.pg4200.exam;

import org.pg4200.exam.ex04extraClasses.Program;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ex04 {

    public ArrayList<String> ex04(Program program){

        return program.getCourses().stream()
                .flatMap(course -> course.students.values().stream())
                .distinct()
                .map(student -> "" + student.firstName.charAt(0) +
                        student.lastName.charAt(0) +
                        student.studentId.toString().substring(student.studentId.toString().length() - 2) +
                        "@hk.no")
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
