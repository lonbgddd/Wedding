package com.example.wedding.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wedding.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText etEmail,etPassword, etConfirm;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onClickSignUp();
            }
        });

    }

    private void onClickSignUp() {
        String strEmail = etEmail.getText().toString().trim();
        String strPassword = etPassword.getText().toString().trim();
        String strConfirm = etConfirm.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();


        boolean flag = true;

        if(TextUtils.isEmpty(strEmail)){
            Toast.makeText(this,"Vui lòng nhập email!", Toast.LENGTH_SHORT).show();
            flag  = false;
        }
        if(TextUtils.isEmpty(strPassword)){
            Toast.makeText(this,"Vui lòng nhập password!", Toast.LENGTH_SHORT).show();
            flag  = false;
        }
        if (strPassword.length()<6) {
            Toast.makeText(SignUpActivity.this, "Mật khẩu tối thiểu 6 kí tự", Toast.LENGTH_SHORT).show();
            flag  = false;
        }
        if(!strPassword.equals(strConfirm)) {
            Toast.makeText(SignUpActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
            flag  = false;
        }

        if (flag) auth.createUserWithEmailAndPassword(strEmail, strPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "Đăng kí thành công, vui lòng đăng nhập lại",
                                Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                        startActivity(intent);
                        finishAffinity();
                    }
                        else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(SignUpActivity.this, "Đăng kí thất bại",
                                    Toast.LENGTH_SHORT).show();

                            }
                        }
           });
    }
}