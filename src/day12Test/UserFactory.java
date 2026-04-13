package day12Test;
import day12Test.service.UserService;
import day12Test.entity.User;
import day12Test.service_impl.UserServiceImpl;
import day12Test.service_impl.UserServiceImpl2;


public class UserFactory {
    public static UserService getUserService(String type){
        if("1".equals(type)){
            return new UserServiceImpl();
        }
        else if("2".equals(type)){
            return new UserServiceImpl2();
        }
        throw new UserException("不支持该类型");
    }
}
