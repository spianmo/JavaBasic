package org.spianmo.learn.week11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName TxtFileTest
 * @Description TODO
 * @Author Finger
 * @Date 11/30/2020
 **/
public class TxtFileTest {
    public static String rootPath = "D:\\JetBrainProjects\\JavaLearn\\JavaBasic\\src\\main\\java\\org\\spianmo\\learn\\week11\\";
    public static String TXTEXP = ".txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String s = scanner.nextLine();

        //FileWriter
        char[] chars = s.toCharArray();
        File file1 = new File(rootPath + UUID.randomUUID() + TXTEXP);
        Writer out = new FileWriter(file1);
        out.write(chars);
        out.close();

        //BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rootPath + UUID.randomUUID() + TXTEXP));
        bufferedWriter.write(s);
        bufferedWriter.close();

        //FileOutputStream
        File file2 = new File(rootPath + UUID.randomUUID() + TXTEXP);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        if (!file2.exists()) {
            file2.createNewFile();
        }
        fileOutputStream.write(s.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();

        //OutputStreamWriter
        File file3 = new File(rootPath + UUID.randomUUID() + TXTEXP);
        if (!file3.exists()) {
            file3.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file3);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write(s);
        osw.close();
        fos.close();

        //download
        download("https://public-cdn-oss.mosoteach.cn/mssvc/cover/2020/09/ced793a346088c8e2d15bcf0bc352e4d.jpeg?x-oss-process=style/s100x100","icon.png",rootPath);
    }

    public static void download(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(5000);
        InputStream is = conn.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        File file = new File(savePath);
        if (!file.exists()){
            file.mkdirs();
        }
        OutputStream os = new FileOutputStream(file.getPath()+File.separator+fileName);
        while ((len = is.read(bytes)) != -1){
            os.write(bytes,0,len);
        }
        os.close();
        is.close();
    }

}
