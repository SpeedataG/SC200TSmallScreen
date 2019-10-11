package com.speedata.sc200tsmallscreen;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.speedata.smallscreenlib.SmallScreenApi;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SmallScreenApi api;
    private String test = "票价:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = new SmallScreenApi();
        findViewById(R.id.btn_test_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api.WriteData(20, 3, new byte[]{0x00}, 0);
                //取个随机数
                int number = new Random().nextInt(10) + 1;
                String data = test + String.valueOf(number) + "元";
                try {
                    //写入数据
                    api.WriteData(20, 3, data.getBytes("GBK"), 16);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    api.WriteData(20, 3, "error".getBytes(), 16);
                }
            }
        });
    }
}
