package bitlab.springtask3_1.Models;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Student> students = new ArrayList<>();

    private static long id = 6L;

    static {
        students.add(new Student(1L,"Adam","Smith",76,"B"));
        students.add(new Student(2L, "John", "Doe", 35, "F"));
        students.add(new Student(3L, "Jane", "Smith", 53, "D"));
        students.add(new Student(4L, "Peter", "Parker", 70, "c"));
        students.add(new Student(5L, "Bruce", "Wayne", 95, "A"));
        students.add(new Student(6L, "Clark", "Kent", 83, "B"));
    }

    public static ArrayList<Student> getStudents(){
        return students;
    }

    public static void addStudent(Student student){

        student.setId(++id);

        if(student.getExam()>90){
            student.setMark("A");
        } else if(student.getExam()>75 && student.getExam()<89){
            student.setMark("B");
        } else if(student.getExam()>60 && student.getExam()<74){
            student.setMark("C");
        } else if (student.getExam()>50 && student.getExam()<59) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }
        students.add(student);
    }
}
