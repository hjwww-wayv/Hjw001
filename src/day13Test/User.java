package day13Test;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Data
public class User {
    private String username;
    private String password;
    private int id;
    private int age;
    private LocalDateTime createTime;
    private LocalDate birthday;

    public User(){

    }
    public User(String username, String password, LocalDate birthday) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.createTime = createTime;
        this.age=calculateage();
    }
    public int calculateage(){
        if(birthday==null){
            return 0;
        }else{
            return Period.between(birthday,LocalDate.now()).getYears();
        }
    }
}
