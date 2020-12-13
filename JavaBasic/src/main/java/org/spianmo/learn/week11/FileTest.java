package org.spianmo.learn.week11;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author Finger
 * @Date 11/30/2020
 **/
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\JetBrainProjects\\JavaLearn\\JavaBasic\\src\\main\\java\\org\\spianmo\\learn\\week11\\test.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());

        //1-1：根据时间创建文件夹1
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        File dir = new File("D:\\JetBrainProjects\\JavaLearn\\JavaBasic\\src\\main\\java\\org\\spianmo\\learn\\week11\\" + "dir_" + spf.format(new Date()));
        if (!dir.exists()) {
            boolean flag = dir.mkdir();
            System.out.println(flag ? "文件夹创建成功" : "文件夹创建失败");
        }
        //1-1：根据时间创建文件夹2
        LocalDate today = LocalDate.now();
        String dirName = today.getYear() + "-" + today.getMonthValue() + 1 + "-" + today.getDayOfMonth();
        File dir1 = new File("D:\\JetBrainProjects\\JavaLearn\\JavaBasic\\src\\main\\java\\org\\spianmo\\learn\\week11\\" + dirName);
        if (!dir1.exists()) {
            boolean flag = dir1.mkdir();
            System.out.println(flag ? "文件夹创建成功" : "文件夹创建失败");
        }

        //1-2：删除刚刚创建的文件夹
        if (dir1.exists()) {
            boolean isDelete = dir1.delete();
            System.out.println(isDelete ? "文件夹删除成功" : "文件夹删除失败");
        }

        //1-3：递归创建文件夹
        List<String> targetDirs = new ArrayList<>();
        String[] dirNameArray = new String[]{"面向对象", "异常", "集合", "io", "多线程"};
        String[] childDirNameArray = new String[]{"字节流", "字符流"};
        String rootDirPath = "D:\\JetBrainProjects\\JavaLearn\\JavaBasic\\src\\main\\java\\org\\spianmo\\learn\\week11\\Java";
        targetDirs.add(rootDirPath);
        for (String str : dirNameArray) {
            String targetDirName = rootDirPath + File.separator + str;
            if ("io".equals(str)) {
                for (String str1 : childDirNameArray) {
                    targetDirs.add(targetDirName + File.separator + str1);
                }
            } else {
                targetDirs.add(targetDirName);
            }
        }
        createNewDir(targetDirs,0);
    }

    public static void createNewDir(String targetDirName){
        File tmpFile = new File(targetDirName);
        if (!tmpFile.exists()){
            boolean flag = tmpFile.mkdirs();
            System.out.println(flag ? "文件"+targetDirName+"创建成功" : "文件"+targetDirName+"创建失败");
        }
    }
    public static void createNewDir(List<String> targetDirs,int count){
        createNewDir(targetDirs.get(count));
        if (++count != targetDirs.size()) {
            createNewDir(targetDirs,count);
        }
    }
}
