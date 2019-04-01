package com.wildan.aha.smartmarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgScanner,imgLogout, imgCart;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgScanner = findViewById(R.id.imgScanner);
        imgLogout = findViewById(R.id.imgLogout);
        imgCart = findViewById(R.id.imgCart);

        sessionManagement = new SessionManagement(this);

        if(!sessionManagement.isLoggedIn()){
            sessionManagement.logoutUser();
        }

        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });

        imgScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ScannerActivity.class);
                startActivity(i);
            }
        });

        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CartMainActivity.class);
                startActivity(i);
            }
        });
    }
}
