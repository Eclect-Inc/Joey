package com.eclect.codenamejoey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Driving extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving);
        setTheme(R.style.AppThemeSimple);
        TextView tv33 = findViewById(R.id.textView3);



        tv33.setText("You have not been verified as a driver yet.");
    }
}
