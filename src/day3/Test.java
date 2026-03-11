package day3;

import lombok.Data;

@Data
public class Test {
    public static void main(String[] args) {
        Bigbox<Integer> bigbox1 = new Bigbox<Integer>(5);
        System.out.println(bigbox1.getT());

        Bigbox<String> bigbox2 = new Bigbox<String>("hello");
        System.out.println(bigbox2.getT());

        Student student = new Student("홍길동");
        Bigbox<Student> bigbox3 = new Bigbox<Student>(student);
        System.out.println(bigbox3.getT().getName());

    }
}
