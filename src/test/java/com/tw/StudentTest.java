package com.tw;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {
    @Test
    public void should_student_have_name_number_and_course() {
        Map<String, Double> map = new HashMap<>();
        map.put("语文", 90.0);
        Student student = new Student("张三", "201801", map);
        Assert.assertEquals("张三",student.getName());
        Assert.assertEquals("201801",student.getNumber());
        Assert.assertEquals(map,student.getCourse());
    }

    @Test
    public void should_student_have_name_number_and_courses() {
        Map<String, Double> map = new HashMap<>();
        map.put("语文", 90.0);
        map.put("数学", 80.0);
        Student student = new Student("张三", "201801", map);
        Assert.assertEquals("张三",student.getName());
        Assert.assertEquals("201801",student.getNumber());
        Assert.assertEquals(map,student.getCourse());
    }
}
