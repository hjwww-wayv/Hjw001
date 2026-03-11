package day2;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class Bianli {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //有索引，因此可以遍历
        //1.for
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //2.迭代器
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        //3.for each
        for(String s : list) {
            System.out.println(s);
        }

    }


}
