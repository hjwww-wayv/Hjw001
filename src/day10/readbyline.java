package day10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class readbyline {
    public static void main(String[] args) throws FileNotFoundException, IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("src/day10/1.txt"));
    String line;
    int linenum=1;
    while((line=bufferedReader.readLine())!=null){
        System.out.println("line "+linenum+": "+line);
        linenum++;
    //找关键词
        if(line.contains("aa")){
            System.out.println("yes");
        }
        linenum++;
    }
    }}
