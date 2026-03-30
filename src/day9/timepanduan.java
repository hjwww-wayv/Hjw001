package day9;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class timepanduan {
    //判断会员是否过期
    public static void main(String[] args) {
        LocalDate expireDate= LocalDate.of(2022, 12, 31);
        LocalDate nowDate=LocalDate.now();
        if(nowDate.isAfter(expireDate)){
            System.out.println("会员已过期");
        }else{
            System.out.println("会员未过期");
        }
    }
}
