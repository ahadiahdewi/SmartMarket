package com.wildan.aha.smartmarket;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText textEmailAddress,textPassword;
    TextView textDaftar;
    Button buttonLogin;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textEmailAddress = findViewById(R.id.textEmailAddress);
        textPassword = findViewById(R.id.textPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textDaftar = findViewById(R.id.Daftardisini);

        sessionManagement = new SessionManagement(this);

        if(sessionManagement.isLoggedIn()){
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }

        // Sign Up activitiy
        textDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftarIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(daftarIntent);
            }
        });

        // Login process
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            String email = textEmailAddress.getText().toString();
            String password = textPassword.getText().toString();

            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Lengkapi alamat email anda", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Isi password anda", Toast.LENGTH_SHORT).show();
                }
                login(email, password);
            }
        });

//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email,password;
//                email = textEmailAddress.getText().toString();
//                password = textPassword.getText().toString();
//                if(true){
//                    sessionManagement.createLoginSession(email,password);
//                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                    startActivity(i);
//                }else{
//                    Toast.makeText(getApplicationContext(),"Email dan Password salah",Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }

    private void login(String email, String password) {
        try {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(homeIntent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Terjadi kesalahan, mohon ulangi", Toast.LENGTH_SHORT).show();
                    }
                }
            })
            .addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
                    //
        } catch (Exception e) {
            Log.e("LoginError", e.getMessage());
        }
    }
}
