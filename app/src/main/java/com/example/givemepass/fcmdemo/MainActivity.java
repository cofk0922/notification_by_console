package com.example.givemepass.fcmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = (TextView) findViewById(R.id.msg);
        MyNotice.getInstance().setOnMessageReceivedListener(new MyNotice.OnMessageReceivedListener() {
            @Override
            public void onMessageReceived(final String s) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        msg.setText(s);
                    }
                });

            }
        });
    }
}
