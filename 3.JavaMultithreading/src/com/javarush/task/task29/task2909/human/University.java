package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {

        for (Student student :students) {
            if(student.getAverageGrade() == averageGrade){
                return student;
            }
        }
        
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {

        Student current = null;
        for (Student student :students) {
            if(current == null){
                current = student;
            }

            if(current.getAverageGrade() < student.getAverageGrade()){
                current = student;
            }
        }
        return current;
    }

    public Student getStudentWithMinAverageGrade() {
        Student current = null;
        for (Student student :students) {
            if(current == null){
                current = student;
            }

            if(current.getAverageGrade() > student.getAverageGrade()){
                current = student;
            }
        }
        return current;
    }

    public void expel(Student student){
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;
}