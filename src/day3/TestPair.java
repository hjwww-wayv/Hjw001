package day3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestPair {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("key", 100);
        String s1=pair.getKey();
        Integer i1=pair.getValue();
    }
    public static void printStr(String s){
        System.out.println(s);
    }
    //改写成泛型方法,一种有返回值一种没有：
    public static <T> void printA(T t){
        System.out.println(t);
    }
    public static <T> T printB(T t){
        System.out.println(t);
        return t;
    }
}
