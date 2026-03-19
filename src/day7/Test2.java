package day7;

import day5.Student;

import java.sql.Driver;

public class Test2{
    public static void main(String[] args) {
    E d=new E();
    d.sing();
    }
}
class Student1{

}
class E extends Student1 implements Drive,Singer {
    @Override
    public void drive()
        {
        }
        @Override
    public void sing()
            {
            }
}
interface Singer{
    void sing();
}
interface Drive{
    void drive();
}