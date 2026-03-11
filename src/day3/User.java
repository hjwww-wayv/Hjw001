package day3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;

//@Getter@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class User {
    private String name;
    private String password;
    private int age;
    private int height;
}
