package iunsuccessful.demo.base.jwt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读取控制台输入内容
 * Create By LiQZ 2018/9/11
 */
public class ReaderConsole {

    public static void main(String[] args) {
        try {
            demo1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void demo1() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
    }

}
