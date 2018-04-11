package com.eclect.codenamejoey;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mehdi.sakout.fancybuttons.FancyButton;

public class SendOff extends AppCompatActivity {

    private FancyButton submit;
    private EditText etItem;
    private String ab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_off);

        FancyButton submit = findViewById(R.id.btnRequest);
        TextView tv33 = findViewById(R.id.tv3);

        String s = getIntent().getStringExtra("key");

        tv33.setText(s);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText a = findViewById(R.id.editText3);
                String ab = a.getText().toString();

                Toast.makeText(getApplicationContext(), "A driver has been requested to pickup your " + ab ,Toast.LENGTH_LONG).show();


                Intent i = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(i);





            }
        });

    }
}
