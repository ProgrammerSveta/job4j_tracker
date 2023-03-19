package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Svetlana Trebushnaia");
        student.setGroup("Java Intern");
        student.setAdmission(new Date());
        System.out.println(student.getFullName() + " enrolled to " + student.getGroup() + " group at " + student.getAdmission());
    }
}