package com.tonystack;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;


/**
 * @ClassName Main
 * @Description TODO
 * @Author Finger
 * @Date 10/26/2020
 **/
public class Main {
    public static List<Issue> list;
    public static void main(String[] args) throws IOException {
        System.out.println("=============#FUCK安全知识竞赛 By:Finger#===============\n");
        JsonArray jsonArray;
        jsonArray = new JsonParser().parse(new JsonReader(new InputStreamReader(getResourceAsStream("sql_tiku_hanfocus_dump")))).getAsJsonObject().getAsJsonObject("data").getAsJsonArray("list");
        list = new ArrayList<>();
        for (JsonElement jobj : jsonArray) {
            Issue issue = new Issue();
            issue.id = jobj.getAsJsonObject().getAsJsonPrimitive("timu_id").getAsInt();
            issue.type = jobj.getAsJsonObject().getAsJsonPrimitive("timu_tixing").getAsString();
            issue.title = jobj.getAsJsonObject().getAsJsonPrimitive("timu_title").getAsString();
            issue.items[0] = new Issue.IssueItem("A", jobj.getAsJsonObject().getAsJsonPrimitive("timu_a").getAsString());
            issue.items[1] = new Issue.IssueItem("B", jobj.getAsJsonObject().getAsJsonPrimitive("timu_b").getAsString());
            issue.items[2] = new Issue.IssueItem("C", jobj.getAsJsonObject().getAsJsonPrimitive("timu_c").getAsString());
            issue.items[3] = new Issue.IssueItem("D", jobj.getAsJsonObject().getAsJsonPrimitive("timu_d").getAsString());
            issue.answer = jobj.getAsJsonObject().getAsJsonPrimitive("timu_daan").getAsString();
            list.add(issue);
        }
        Scanner scanner = new Scanner(System.in,"GBK");
        String inputStr;
        while (true){
            System.out.println("===========>输入题目关键字,输入exit退出");
            inputStr = scanner.next();
            if (inputStr.equals("exit")){
                break;
            }
            findIssue(inputStr);
        }
    }

    public static void findIssue(String str){
        for (Issue issue : list) {
            if (issue.title.contains(str)){
                System.out.println("===========>查询结果为  "+issue + "\n");
            }
        }
    }
}
