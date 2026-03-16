package day5;

import lombok.Data;

@Data
public class Operater {
    Student student;
    public Operater(Student student){
        this.student = student;
    }
    public void show(){
        System.out.println(student.getName()+" "+student.getAge());
    }
}
