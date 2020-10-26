package org.spianmo.learn.week7;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void speed() {
        Fly fly = new Person();

        File file = new File("./data");
        try {
            InputStream is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void go() {

    }
}