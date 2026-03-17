package day6Test;

import day6.ProductsService;

public class ProTest {
    public static void main(String[] args) {
        ProductService ps = new ProductService();
        try {
            System.out.println(ps.finbyId(-1));
        } catch (ProException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(ps.findInStockProducts());
        } catch (ProException e) {
            System.out.println(e.getMessage());
        }
    }
}
