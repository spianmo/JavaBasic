package org.spianmo.learn.week8;

/**
 * @ClassName BaseBookException
 * @Description TODO
 * @Author Finger
 * @Date 11/2/2020
 **/
public class BaseBookException extends Exception {
    protected String msg;

    public BaseBookException(String msg){
        this.msg = msg;
    }

    public String showMsg(){
        return this.msg;
    }
}
