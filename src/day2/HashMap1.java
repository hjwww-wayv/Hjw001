package day2;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Set;

public class HashMap1 {
    public static void main(String[] args) {
        Map<Student, String> map = new HashMap<>();
        map.put(new Student("zhangsan", 18, 1.81), "一班");
        map.put(new Student("lisi", 19, 1.82), "二班");
        map.put(new Student("wangwu", 20, 1.83), "三班");
        map.put(new Student("wangwu", 20, 1.83), "三班");
        System.out.println(map);

//        //1.通过先获取所有键再找值
//        Set<Student> set = map.keySet();
//        System.out.println(set);
//        for (Student s : set) {
//            System.out.println(s + "-->" + map.get(s));
//        }
//        //2.键值对
//        //3.lamba表达式
//        map.forEach((k, v) -> {
//            System.out.println(k + "-->" + v);
//        });
    }}