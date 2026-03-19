package day7.Student_Management;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClassManage {

    List<Students> students=new ArrayList<>();
    private StudentOPeration stu=new Classoperaterimpl();
    public ClassManage(){
        students.add(new Students("Nguyen Van A", '女', 12));
        students.add(new Students("Nguyen Van B", '女', 99.0));
        students.add(new Students("Nguyen Van C", '女', 55));
        students.add(new Students("Nguyen Van D", '男', 100));
    }
    public void PrintStudent() {
        stu.PrintStudent(students);
    }
    public void AveStudent() {
        stu.AveStudent(students);
    }
}
