package day7.Student_Management;

import java.util.List;

public class Classoperaterimpl implements StudentOPeration{
    public void PrintStudent(List<Students> studentList){
        for (Students students:studentList){
            System.out.println(students.getName()+students.getGender()+students.getScore());
        }
        }

    public void AveStudent(List<Students> studentList){
        double sum=0;
        for (Students students:studentList){
            sum=sum+students.getScore();
        }
        System.out.println(sum/studentList.size());
    }
        }
