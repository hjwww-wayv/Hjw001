package day9;
import java.time.Period;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class Age18 {
    //先获取用户的生日
    public static void main(String[] args)
    {
        LocalDate Birthday = LocalDate.of(2005,12,3);
        LocalDate now= LocalDate.now();
        Period p= Period.between(Birthday,now);
        int age=p.getYears();
        if(age>=18)
        {
            System.out.println("成年了");
        }
        else
        {
            System.out.println("未成年");
        }
    }
}
