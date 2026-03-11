package day2;
import java.util.ArrayList;
import java.util.List;

public class List1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //不能写成List<String> list = new List<>(); 因为List是一个接口
        //1.添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        //2.删除
        list.remove(0);
        System.out.println(list);
        //3.修改
        list.set(0,"javaee");
        System.out.println(list);
        //4.获取
        list.get(1);
        System.out.println(list.get(1));
    }
}