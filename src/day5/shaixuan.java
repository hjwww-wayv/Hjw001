package day5;

import java.util.List;
import java.util.ArrayList;

public class shaixuan {
    public static void main(String[] args) {
        List<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for(Object o : list) {
            if(o.equals(2)) {
                list.remove(o);
            }
        }
        System.out.println(list);
    }

}
