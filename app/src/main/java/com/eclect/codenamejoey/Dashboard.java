package com.eclect.codenamejoey;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hypertrack.lib.HyperTrack;
import com.hypertrack.lib.HyperTrackMapAdapter;
import com.hypertrack.lib.callbacks.HyperTrackCallback;
import com.hypertrack.lib.models.Action;
import com.hypertrack.lib.models.ErrorResponse;
import com.hypertrack.lib.models.Place;
import com.hypertrack.lib.models.SuccessResponse;
import com.hypertrack.lib.models.User;
import com.hypertrack.lib.models.UserParams;

import java.util.ArrayList;
import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

public class Dashboard extends AppCompatActivity {

    private Context context;
    private TextView NameVerify, AddressVerify;
    private EditText Name, Address;
    private FancyButton btnOrder, btnDriving, btnCurrentOrder;
    private String asdf;

    //HyperTrackMapAdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeSimple);
        setContentView(R.layout.activity_dashboard);

        FancyButton btnOrder =  findViewById(R.id.btnOrderAPackage);
        FancyButton btnDriving = findViewById(R.id.btnDriveStuff);
        FancyButton btnCurrentOrder = findViewById(R.id.Mileage);



        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), OrderPackage.class);
                startActivity(i);

            }
        });
        btnDriving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Driving.class);
                startActivity(i);

            }
        });
        btnCurrentOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CurrenTOrder.class);
                startActivity(i);

            }
        });

//        String placeTitle = ;

        HyperTrack.initialize(this.getApplicationContext(), "pk_test_4e0231f77fd97c3e434e3359e284df5ee07c5b93");
        // To request Location Permissions
        HyperTrack.requestPermissions(this);

        // To enable Location Services
        HyperTrack.requestLocationServices(this);
        //    Place placeB = new Place().setLocation()
        //    .setAddress()
        //    .setName("");









//        HyperTrack.getOrCreateUser(userParams,  {
//            @Override
//            public void onSuccess(@NonNull SuccessResponse response) {
//                if (response.getResponseObject() != null) {
//                    User user = (User) response.getResponseObject();
//                    String userId = user.getId();
//
//                    Log.i("HT", "userId" + userId);
//                    // Handle user_id, if needed
//
//                }
//            }
//
//            @Override
//            public void onError(@NonNull ErrorResponse error) {
////                Log.e("HT", "Error MT" + error);
////            }
//        });
//
////        Place expectedPlace = new Place()
//                .setLocation(latitude, longitude)
////              .setAddress(address)
//              .setName(name);

    }}
