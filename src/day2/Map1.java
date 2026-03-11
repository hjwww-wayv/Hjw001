package day2;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Map1 {
    public static void main(String[] args) {
        //一行经典代码，按键值 无序 不重复 无索引
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put(null, null);
        System.out.println(map);

        Map<Integer,String> map2 = new TreeMap<>();
        map2.put(1,"a");
        map2.put(2,"b");
        map2.put(3,"c");
        map2.put(4,"d");
        System.out.println(map2);
        //按照键值大小升序排序
    }
}

