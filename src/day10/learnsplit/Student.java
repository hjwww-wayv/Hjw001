package day10.learnsplit;

// 存学生信息的实体类
public class Student {
    private int id;    // 学号
    private String name; // 姓名
    private int age;    // 年龄
    private double score; // 成绩

    // 构造方法
    public Student(int id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // 方便打印看结果
    @Override
    public String toString() {
        return String.format("学号：%d，姓名：%s，年龄：%d，成绩：%.1f",
                id, name, age, score);
    }
}
