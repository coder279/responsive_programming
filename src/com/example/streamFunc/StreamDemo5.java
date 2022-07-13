package com.example.streamFunc;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;



/**
 * Ñ§Éú ¶ÔÏó
 */
class Student {
    /**
     * ÐÕÃû
     */
    private String name;

    /**
     * ÄêÁä
     */
    private int age;

    /**
     * ÐÔ±ð
     */
    private Gender gender;

    /**
     * °à¼¶
     */
    private Grade grade;

    public Student(String name, int age, Gender gender, Grade grade) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", age=" + age + ", gender=" + gender
                + ", grade=" + grade + "]";
    }

}

enum Gender {
    MALE, FEMALE
}


enum Grade {
    ONE, TWO, THREE, FOUR;
}

public class StreamDemo5 {

    public static void main(String[] args) {
        // ²âÊÔÊý¾Ý
        List<Student> students = Arrays.asList(
                new Student("1", 10, Gender.MALE, Grade.ONE),
                new Student("2", 9, Gender.MALE, Grade.THREE),
                new Student("3", 8, Gender.FEMALE, Grade.TWO),
                new Student("4", 13, Gender.FEMALE, Grade.FOUR),
                new Student("5", 7, Gender.FEMALE, Grade.THREE),
                new Student("6", 13, Gender.MALE, Grade.ONE),
                new Student("7", 13, Gender.FEMALE, Grade.THREE),
                new Student("8", 9, Gender.FEMALE, Grade.TWO),
                new Student("9", 6, Gender.MALE, Grade.ONE),
                new Student("10", 6, Gender.MALE, Grade.ONE),
                new Student("11", 14, Gender.FEMALE, Grade.FOUR),
                new Student("12", 13, Gender.MALE, Grade.FOUR));

        // µÃµ½ËùÓÐÑ§ÉúµÄÄêÁäÁÐ±í
        // s -> s.getAge() --> Student::getAge , ²»»á¶àÉú³ÉÒ»¸öÀàËÆ lambda$0ÕâÑùµÄº¯Êý
        Set<Integer> ages = students.stream().map(Student::getAge)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("ËùÓÐÑ§ÉúµÄÄêÁä:" + ages);

        // 计算collections的汇总信息
        IntSummaryStatistics agesSummaryStatistics = students.stream()
                .collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("ÄêÁä»ã×ÜÐÅÏ¢:" + agesSummaryStatistics);

        // stream集合分块
        Map<Boolean,List<Student>> genders = students.stream().collect(Collectors.partitioningBy(s->s.getGender() == Gender.MALE));
        System.out.println("男女学生列表:"+genders);

        //stream集合分组
        Map<Grade,List<Student>> gradeListMap = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("学生列表:"+gradeListMap);
        //stream得到所有学生班级数量
        Map<Grade,Long> gradesCount = students.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.counting()));
        System.out.println("学生班级列表数量:"+gradesCount);


    }

}
