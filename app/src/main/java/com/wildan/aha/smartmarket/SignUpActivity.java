package com.wildan.aha.smartmarket;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    Button btnSimpanPelanggan;
    EditText textNama, textNotelp, textAlamat, textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSimpanPelanggan = findViewById(R.id.btnSimpanSignUp);
        textNama = findViewById(R.id.textNamaPelangganSignUp);
        textAlamat = findViewById(R.id.textNotelpPelangganSignUp);
        textNotelp = findViewById(R.id.textEmailSignUp);
        textPassword = findViewById(R.id.textPassword);

        final String password = textPassword.getText().toString();
        final String email = textEmail.getText().toString();

        btnSimpanPelanggan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterUser(email, password);
            }
        });

    }

    private void RegisterUser(String email, String password) {
        try {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isComplete()) {

                            } else {

                            }
                        }
                    })
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
        } catch (Exception e) {
            Log.e("SignUpError", e.getMessage());
        }
    }
}
