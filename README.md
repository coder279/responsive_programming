### Responsive programming

- Introduces several common functional programming usages in Java；
- Supports Lamda expressions, Stream streaming, parallel streaming, collectors；

**Personal Java Practice Items**

> Better integration into team Java development

#### Java code 　

```java
        Set<Integer> ages = students.stream().map(Student::getAge)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Trees:" + ages);

		//Summary information
        IntSummaryStatistics agesSummaryStatistics = students.stream()
                .collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("Student age summary information:" + agesSummaryStatistics);

        // Stream set blocking
        Map<Boolean,List<Student>> genders = students.stream().collect(Collectors.partitioningBy(s->s.getGender() == Gender.MALE));
        System.out.println("List of male and female students:"+genders);

        //Stream set grouping
        Map<Grade,List<Student>> gradeListMap = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("Student list:"+gradeListMap);

        //Stream gets the number of all student classes
        Map<Grade,Long> gradesCount = students.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.counting()));
        System.out.println("Number of student class lists:"+gradesCount);
```

### End

Test