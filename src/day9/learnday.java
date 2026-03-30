package day9;

import java.text.ParseException;
import java.util.Date;
import java.time.LocalDate;
import java.text.SimpleDateFormat;//格式化日期
public class learnday {
    public static void main(String[] args) throws ParseException {
        //也包括时分秒
        Date date = new Date();
        //创建一个格式对象
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //转换为字符串
        String str = dateFormat.format(date);
        System.out.println(str);
        //字符串转换为日期
        String str2 = "2022-12-12 12:12:12";
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = dateFormat2.parse(str2);
        System.out.println(date2);
        //一百天后的日期
        // 今天是2026-03-29
        LocalDate today = LocalDate.now();
// 加100天：plusDays(天数)，还有plusYears/plusMonths/plusHours
        LocalDate after100Days = today.plusDays(100);
        System.out.println("100天后的日期：" + after100Days);
// 输出：100天后的日期：2026-07-06，和我之前推算的结果一致




}}
