package org.pg4200.ex08.partE;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartETest {

    public ArrayList<Course> generateCourses(int n){
        ArrayList<Course> result = new ArrayList<>();

        Course pg4200 = new Course();
        pg4200.courseName = "AlgDat";
        pg4200.courseId = "pg4200";

        result.add(pg4200);

        for (int i = 1; i < n; i++){
            Course c = new Course();
            int cid = 4220 + i;
            c.courseId = "pg" + cid;
            c.courseName = "Course " + cid;

            result.add(c);
        }
        return result;
    }

    public ArrayList<Student> generateStudents(int n, ArrayList<Course> courses){
        ArrayList<Student> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i< n; i++){
            Student s = new Student();
            s.name = "Student " + i;
            HashMap<Course, Integer> cou = new HashMap<>();

            for(int j= 0; j< courses.size() - 3; j++){
                int ra = random.nextInt(2);
                int grade = random.nextInt(5);
                cou.put(courses.get(j + ra), grade);
            }

            int pg = random.nextInt(5);
            if(pg > 0){
                cou.put(courses.get(0), pg);
            }

            s.courseList = cou;

            result.add(s);
        }

        return result;
    }

    public ArrayList<DiplomaProject> generateDiplomaProjs(int n, ArrayList<Student> studentsIn){
        ArrayList<DiplomaProject> result = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        students.addAll(studentsIn);
        Random rand = new Random();

        for(int i = 0; i < n && students.size() > 0; i++){
            DiplomaProject d = new DiplomaProject();
            d.title = "Project " + i;
            d.authors = new ArrayList<>();
            int s = 1 + rand.nextInt(2);
            for (int j = 0; j < s && students.size() > 0 ; j++){
                int rs = rand.nextInt(students.size());
                Student st = students.get(rs);
                d.authors.add(st);
                st.diplomaProject = d;
                students.remove(rs);
            }

            result.add(d);
        }

        return result;
    }


    @Test
    void test(){
        ArrayList<Course> courses = generateCourses(200);
        ArrayList<Student> students = generateStudents(1500, courses);
        ArrayList<DiplomaProject> diplomaProjects = generateDiplomaProjs(700, students);

        Course pg4200 = courses.get(0);


        List<String> list = diplomaProjects.stream()
                .flatMap(diplomaProject -> diplomaProject.authors.stream())
                .distinct()
                .filter(student -> student.courseList.containsKey(pg4200))
                .filter(student -> student.courseList.get(pg4200) >= 2)
                .map(student -> student.diplomaProject)
                .distinct()
                .map(diplomaProject -> diplomaProject.title)
                .collect(Collectors.toList());

        //System.out.println(list.size());
        assertTrue(list.size() > 0);

        List<String> rubric = rubric(diplomaProjects, pg4200);
        //System.out.println(rubric.size());

        assertEquals(rubric.size(), list.size());
        assertTrue(list.containsAll(rubric));
        assertTrue(rubric.containsAll(list));
    }

    /**
     * solution from sol08
     */
    public ArrayList<String> rubric(ArrayList<DiplomaProject> diplomaProjects, Course course){
        return diplomaProjects.stream()
                .filter(d -> d.authors.stream()
                        .filter(s -> s.courseList.containsKey(course))
                        .anyMatch(s -> s.courseList.get(course) >= 2)
                )
                .map(d -> d.title)
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
