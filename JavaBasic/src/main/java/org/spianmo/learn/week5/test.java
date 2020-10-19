package org.spianmo.learn.week5;

/**
 * @ClassName test
 * @Description TODO
 * @Author Finger
 * @Date 10/19/2020
 **/
public class test {
    public static void main(String[] args) {
        int age = 22;
        age = 23;
        System.out.println("age"+age);
        String[] ee =new String[]{"wddwde","nibcbc"};
        ee[0] = "我爱1你";
        ee[1] = "aaaaa";
        for(int i=0;i<ee.length;i++){
            System.out.println(ee[i]);
        }
        for (String str:ee){
            System.out.println(str);
        }


        if ("我爱你".equals(ee[0])){
            System.out.println("1");
        }else if ("我爱1你".equals(ee[0])){
            System.out.println("2");
        }else if ("我爱2你".equals(ee[0])){
            System.out.println("3");
        }else {
            System.out.println("4");
        }

        switch (ee[0]){
            case "我爱你":
                System.out.println("1111");
                break;
            case "我爱1你":
                System.out.println("2");
                break;
            case "我爱2你":
                System.out.println("3");
                break;
        }


    }

}
