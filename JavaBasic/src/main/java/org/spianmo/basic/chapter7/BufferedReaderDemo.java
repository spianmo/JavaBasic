package org.spianmo.basic.chapter7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by beigui on 2016/4/2.
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {
        File file = new File("d:/test", "work.txt");
        FileReader fileReader = null;
        BufferedReader buffReader = null;
        try {
            fileReader = new FileReader(file);
            buffReader = new BufferedReader(fileReader);

            String contentLine = "";
            int line = 1;
            while ((contentLine = buffReader.readLine()) != null) {
                System.out.println("第" + line++ + "行，内容为：" + contentLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
