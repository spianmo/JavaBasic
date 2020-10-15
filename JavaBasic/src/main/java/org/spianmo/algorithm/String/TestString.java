package org.spianmo.algorithm.String;

import org.spianmo.algorithm.String.LinkList.LinkString;

/**
 * @ClassName TestString
 * @Description TODO
 * @Author Finger
 * @Date 10/13/2020
 **/
public class TestString {
    public static void main(String[] args) {
        CustomizeString str1 = new CustomizeString(new char[] { 'a', 'b', 'c'});
        CustomizeString res1 = str1.SubStr(0,1);
        System.out.println("=================>SubStr结果: "+res1);
        System.out.println("=================>SubStr格式化结果: "+res1.toFormatString());

        CustomizeString str2 = new CustomizeString(new char[] { 'a', 'b', 'c'});
        CustomizeString res2 = str2.CommonSubStr(0,1);
        System.out.println("=================>CommonSubStr结果: "+res2);
        System.out.println("=================>CommonSubStr格式化结果: "+res2.toFormatString());

        LinkString str3 = new LinkString();
        str3.addArray(new Character[]{'a','b','c'});
        System.out.println("=================>InsertStr格式化结果: "+str3);

    }
}
