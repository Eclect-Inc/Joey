package com.eclect.codenamejoey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CurrenTOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeSimple);
        setContentView(R.layout.activity_curren_torder);

        String s = getIntent().getStringExtra("key");



    }
}
