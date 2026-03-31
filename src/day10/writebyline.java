package day10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class writebyline {
    public static void main(String[] args) throws IOException {
        List<String> dataList = Arrays.asList(
                "第一行内容：今天天气不错",
                "第二行内容：学习JavaIO",
                "第三行内容：按行读写很方便"
        );
        //先读取数据，再写入进指定文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\day10\\1.txt",true));
        for(String line : dataList) {
            bw.write(line);
            bw.newLine();
        }
        System.out.println("写入"+dataList.size()+"行数据");
        bw.close();
        }
    }

