package com.tw;

import java.util.Map;

public class Student {
    private String name;
    private String number;
    Map<String, Double> course;

    public Student(String name, String number, Map<String, Double> course) {
        this.name = name;
        this.number = number;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Map<String, Double> getCourse() {
        return course;
    }

    public void setCourse(Map<String, Double> course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return name.equals(student.getName())
                && number.equals(student.getNumber())
                && course.equals(student.getCourse());
    }
}
