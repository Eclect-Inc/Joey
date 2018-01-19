package com.eclect.codenamejoey;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hypertrack.lib.HyperTrack;
import com.hypertrack.lib.HyperTrackMapAdapter;
import com.hypertrack.lib.callbacks.HyperTrackCallback;
import com.hypertrack.lib.models.Action;
import com.hypertrack.lib.models.ErrorResponse;
import com.hypertrack.lib.models.SuccessResponse;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    //HyperTrackMapAdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppThemeSimple);
        setContentView(R.layout.activity_dashboard);

        HyperTrack.initialize(this.getApplicationContext(), "pk_test_4e0231f77fd97c3e434e3359e284df5ee07c5b93");
        // To request Location Permissions
        HyperTrack.requestPermissions(this);

// To enable Location Services
        HyperTrack.requestLocationServices(this);
    }





}
