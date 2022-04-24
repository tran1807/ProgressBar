package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar prXuly;
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prXuly = (ProgressBar) findViewById(R.id.progressBarXuly);
        btnDownload = (Button) findViewById(R.id.buttonDownload);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 10000: 10 giây -> tổng thời gian đếm ngược
                // 1000: 1 giây -> thời gian lặp lại 1 hành động nào đó
                CountDownTimer countDownTimer = new CountDownTimer(10000,500) {//10 giây,1 giây
                    @Override
                    public void onTick(long l) {
                        int curent = prXuly.getProgress();
                        if(curent >= prXuly.getMax()){
                            curent = 0;
                        }
                        prXuly.setProgress(curent + 10);
                    }

                    @Override
                    public void onFinish() {
                        //chạy nữa
                        this.start();
                        Toast.makeText(MainActivity.this, "Hết Giờ", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }
}