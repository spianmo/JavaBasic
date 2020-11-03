package com.tonystack;

import org.jetbrains.annotations.NotNull;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * @ClassName PassLecture
 * @Description TODO
 * @Author Finger
 * @Date 11/3/2020
 **/
public class PassLecture {

    private final static String BASE_URL = "http://localhost/PassLecture/Core.php";
    public static void main(String[] args) {
        final BufferedImage[] image = {null};

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("action", "init_pic")
                .build();

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(BASE_URL)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull okhttp3.Response response) throws IOException {
                InputStream is = response.body().byteStream();
                image[0] = ImageIO.read(is);
            }
        });


        JFrame frame = new JFrame("Test Image Panel");
        JLabel lbl = new JLabel();

        Container c= frame.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(lbl);
        lbl.setIcon(new ImageIcon(image[0]));
        frame.setBounds(200,100,300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
