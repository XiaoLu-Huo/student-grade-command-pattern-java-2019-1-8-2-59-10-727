package com.tw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public Student Student1() {
        Map<String, Double> map = new HashMap<>();
        map.put("语文", 85.5);
        map.put("数学", 95.5);
        return new Student("张三", "201801", map);
    }

    public Student Student2() {
        Map<String, Double> map = new HashMap<>();
        map.put("语文", 90.0);
        map.put("数学", 80.0);
        return new Student("李四", "201802", map);
    }

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_output_main_page() {
        Output output = new Output();
        output.outputMainPage();
        Assert.assertEquals("1. 添加学生\n" + "2. 生成成绩单\n" + "3. 退出\n", systemOut());
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_output_one_student_report_card() {
        Output output = new Output();
        List<Student> students = new ArrayList<>();
        students.add(Student1());
        output.outputReport(students);
        String card = "成绩单\n";
        String str = "========================\n";
        String inForName = "姓名|数学|语文|平均分|总分\n";
        String inFor = "张三|95.5|85.5|90.5|181.0\n";
        String sumAverageScore = "全班总分平均数：181.0\n";
        String sumMiddleScore = "全班总分中位数：181.0\n\n";
        String expected = card + inForName + inFor + str + sumAverageScore + sumMiddleScore;
        Assert.assertEquals(expected, systemOut());
    }

    @Test
    public void should_output_two_student_report_card() {
        Output output = new Output();
        List<Student> students = new ArrayList<>();
        students.add(Student1());
        students.add(Student2());
        output.outputReport(students);
        String card = "成绩单\n";
        String str = "========================\n";
        String inForName = "姓名|数学|语文|平均分|总分\n";
        String inFor1 = "张三|95.5|85.5|90.5|181.0\n";
        String inFor2 = "李四|80.0|90.0|85.0|170.0\n";
        String sumAverageScore = "全班总分平均数：175.5\n";
        String sumMiddleScore = "全班总分中位数：175.5\n\n";
        String expected = card + inForName + inFor1 + inFor2 + str + sumAverageScore + sumMiddleScore;
        Assert.assertEquals(expected, systemOut());
    }
}
