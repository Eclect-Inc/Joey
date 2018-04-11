package com.eclect.codenamejoey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.fancybuttons.FancyButton;

public class OrderPackage extends AppCompatActivity {

    private FancyButton btnShoebox, btnPassenger, btnTruckBed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


       FancyButton btnShoebox =  findViewById(R.id.btnShoebox);
       FancyButton btnPassenger = findViewById(R.id.btnPassengerSeat);
       FancyButton btnTruckBed= findViewById(R.id.btnTruckBed);



        btnShoebox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SendOff.class);
                i.putExtra("key","Shoebox");
                startActivity(i);

            }
        });
        btnPassenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SendOff.class);
                i.putExtra("key","Passenger Seat");
                startActivity(i);

            }
        });
        btnTruckBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SendOff.class);
                i.putExtra("key","Truck Bed");
                startActivity(i);

            }
        });

    }
}
