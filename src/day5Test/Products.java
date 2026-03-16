package day5Test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Products {
    private String id;
    private String name;
    private double price;
    private int stock;

    public String toString() {
        return "id: " + id + ", name: " + name + ", price: " + price + ", stock: " + stock;
    }
}
