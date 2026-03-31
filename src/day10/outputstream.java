package day10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class outputstream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/day10/1.txt",true);
        String str1="aaaaaa";
        byte[] bytes1 = str1.getBytes();
        fileOutputStream.write(bytes1);
        String wrap="\r\n";
        byte[] bytes3 = wrap.getBytes();
        fileOutputStream.write(bytes3);
        String str2="aavvaaa";
        byte[] bytes2 = str2.getBytes();
        fileOutputStream.write(bytes2);
}}