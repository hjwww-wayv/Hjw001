package day4;

public class ExcpLearn {
    public static void main(String[] args) throws Exception{
       //保存一个合法年龄
        try {
            checkAge(180);
        } catch (AgeRunException e) {
            e.printStackTrace();
        }

    }
    public static void checkAge(int age) throws AgeException {
        if(age>0 && age<150){
            System.out.println("合法年龄"+age);}
        else{
            //用一个对象封装这个问题
            throw new AgeException("年龄非法");
        }
    }
}
