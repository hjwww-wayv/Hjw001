package day6;

public class ProductsTest {
    public static void main(String[] args) {
        ProductsService service = new ProductsService();
        System.out.println(service.filterByName("a"));
        System.out.println(service.filterByStock(100));
        System.out.println(service.filterByMinPrice(500.0));
    }
}
