package day5Test;

import java.util.ArrayList;
import java.util.List;

public class ProductsTest {
    List <Products> list1 = new ArrayList<>();
    public static void main(String[] args) {
        List<Products> list1 = new ArrayList<>();
        list1.add(new Products("1","Apple", 10, 0));
        list1.add(new Products("2","Banana", 20, 10));
        list1.add(new Products("3","Orange", 30, 0));
        list1.add(new Products("4","Grapes", 40, 20));
        list1.add(new Products("5","Pineapple", 50, 25));
        System.out.println("原商品："+ list1);
        List<Products> list2 = ProductUtil.filterInStock(list1);
        System.out.println("库存商品："+ list2);
    }

}
