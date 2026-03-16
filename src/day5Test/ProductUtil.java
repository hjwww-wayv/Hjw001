package day5Test;

import java.util.ArrayList;
import java.util.List;

public class ProductUtil {
    public static List<Products> filterInStock(List<Products> list){
        List<Products> listfinal=new ArrayList<>();
        for (Products p:list){
            if (p.getStock()>0)
                listfinal.add(p);
        }
        return listfinal;
    }
}
