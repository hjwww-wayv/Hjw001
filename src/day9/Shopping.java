package day9;
import lombok.AllArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class Shopping {
    private Long id;
    private Double price;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    public Shopping(Long id,Double price){
        this.id=id;
        this.price=price;
        this.createtime= LocalDateTime.now();
        this.updatetime= LocalDateTime.now();
    }
    public void updatePrice(Double price){
        this.price=price;
        this.updatetime= LocalDateTime.now();
    }
}
