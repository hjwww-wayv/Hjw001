package day15Test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
import java.time.Period;


@TableName("[user]") // 直接换个不冲突的表名，肯定不会错
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String Username;
    private String password;
    private LocalDate birthday;

    public int getAge() {
        if (this.birthday == null) return 0;
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}