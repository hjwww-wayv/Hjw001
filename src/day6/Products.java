package day6;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Products {
    private String name;
    private int price;
    private int stock;

}
