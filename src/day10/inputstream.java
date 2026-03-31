package day10;

import java.io.FileInputStream;
import java.io.IOException;

public class inputstream{
    //循环读取
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("src/day10/1.txt");
        int b=fis.read();
        while(b!=-1){
            System.out.print((char)b);
            b=fis.read();
        }
}}
