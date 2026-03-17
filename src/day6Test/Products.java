package day6Test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Products {
    private int id;
    private String name;
    private int price;
    private int stock;

}
