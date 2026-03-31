package day10.learnsplit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVParse {
    public static void main(String[] args) throws IOException,FileNotFoundException {
        String csvpath = "src/day10/learnsplit/students.csv";
        List<Student> students = new ArrayList<>();
        BufferedReader br=new BufferedReader(new FileReader(csvpath));
        String line;
        int linenum=0;
        boolean isfirstline=true;
        while((line=br.readLine())!=null){
            linenum++;
            if(line.trim().isEmpty()) continue;
            if(isfirstline) {
                isfirstline = false;
                continue;
            }
            String[] fields = line.split(",");
            int id=Integer.parseInt(fields[0].trim());
            String name=fields[1].trim();
            int age=Integer.parseInt(fields[2].trim());
            double score=Double.parseDouble(fields[3].trim());
            Student student=new Student(id,name,age,score);
            students.add(student);
        }
        System.out.println("解析完成，一共拿到" + students.size() + "个学生：");
        for (Student s : students) {
            System.out.println(s);
        }
        }
    }