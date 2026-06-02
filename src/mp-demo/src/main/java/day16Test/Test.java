package day16Test;

import day16Test.Service.UserService;
import day16Test.entity.User;
import day16Test.Impl.SerImp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Test {
    public static void main(String[] args) throws ParseException {
        UserService ser=new SerImp();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        LocalDate start = LocalDate.of(1990,8,2);
        LocalDate end = LocalDate.of(1999,8,9);
//        ser.register(new User(null,"day01","123456",LocalDate.of(1999,5,9)));
//        ser.register(new User(null,"day02","123456",LocalDate.of(2009,5,9)));
//        ser.register(new User(null,"day03","123456",LocalDate.of(1987,5,9)));
//        ser.register(new User(null,"day04","123456",LocalDate.of(2023,5,9)));
//        ser.register(new User(null,"test01","123456",LocalDate.of(2003,5,9)));
//        ser.register(new User(null,"test02","123456",LocalDate.of(2017,5,9)));
//        ser.register(new User(null,"test03","123456",LocalDate.of(1993,5,9)));
//        //1.精确查询
        System.out.println("精确查询："+ser.selectone("day01"));

        //2.模糊查询
        List<User> likeList=ser.selectpart("day");
        System.out.println("模糊查询："+likeList);

        //3.生日区间
        List<User> birthList=ser.selectbybirthday(start,end);
        System.out.println("生日范围："+birthList);

        //4.多条件
        List<User> multi=ser.selectgroup("day",start,end);
        System.out.println("多条件："+multi);

        //5.全表分页 第1页，每页3条
        IPage<User> pageAll=ser.findAllUsers(1,3);
        System.out.println("总条数："+pageAll.getTotal());
        System.out.println("总页数："+pageAll.getPages());
        System.out.println("分页数据："+pageAll.getRecords());

        //6.条件分页
        IPage<User> pageLike=ser.findby(1,3,"day");
        System.out.println("条件分页数据："+pageLike.getRecords());
    }
    }

