package day16Test.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import day16Test.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}