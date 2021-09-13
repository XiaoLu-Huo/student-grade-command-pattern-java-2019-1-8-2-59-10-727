package com.tw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    public final String addStudent = "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：";
    public final String falseRemindForAddStudent = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：";
    public final String printStudent = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    public final String falseRemindForPrintStudent = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";

    public void outputMainPage() {
        System.out.println("1. 添加学生");
        System.out.println("2. 生成成绩单");
        System.out.println("3. 退出");
    }

    public void outputReport(List<Student> students) {
        System.out.println("成绩单");
        List<String> courseNames = new ArrayList<>();
        List<Double> sumScores = new ArrayList<>();
        if (students.size() != 0) {
            System.out.print("姓名|");
            for (String key : students.get(0).getCourse().keySet()) {
                courseNames.add(key);
                System.out.print(key + "|");
            }
            System.out.println("平均分|总分");
        }
        for (Student student : students) {
            System.out.print(student.getName() + "|");
            double sumScore = 0.0;
            for (String course : courseNames) {
                System.out.print(student.getCourse().get(course) + "|");
                sumScore = sumScore + student.getCourse().get(course);
            }
            System.out.println(sumScore / courseNames.size() + "|" + sumScore);
            sumScores.add(sumScore);
        }
        System.out.println("========================");
        System.out.println("全班总分平均数：" + getAverageScore(sumScores));
        System.out.println("全班总分中位数：" + getCenterScore(sumScores) + "\n");
    }

    private Double getAverageScore(List<Double> sumScores) {
        return sumScores.stream()
                .collect(Collectors.averagingDouble(i -> i));
    }

    private Double getCenterScore(List<Double> sumScores) {
        Collections.sort(sumScores);
        if (sumScores.size() % 2 == 0) {
            return (sumScores.get(sumScores.size() / 2 - 1) + sumScores.get(sumScores.size() / 2)) / 2;
        }
        return sumScores.get(sumScores.size() / 2);
    }
}
