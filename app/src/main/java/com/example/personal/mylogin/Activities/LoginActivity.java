package com.example.personal.mylogin.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.personal.mylogin.R;
import com.example.personal.mylogin.Utils.util;

public class LoginActivity extends AppCompatActivity {

     private SharedPreferences prefs;
        private EditText editTextEmail;
        private EditText editTextPassword;
        private Switch SwichRemember;
        private Button btnLogin;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            bindUI();
            prefs= getSharedPreferences("Preferences", Context.MODE_PRIVATE);
            setCredentialsiisIfExist();

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email= editTextEmail.getText().toString();
                    String password= editTextPassword.getText().toString();
                  if(login(email, password)){
                      GoToMain();
                      saveOnPreferences(email, password);
                  }
                }
            });
        }private void bindUI(){
            editTextEmail=(EditText) findViewById(R.id.EditTextEmail);
            editTextPassword=(EditText) findViewById(R.id.editTextPassword);
            SwichRemember=(Switch) findViewById(R.id.switch1);
            btnLogin=(Button) findViewById(R.id.buttonlogin);


        }private void setCredentialsiisIfExist(){
    String email=util.getUsersMailspref(prefs);
        String password=util.getUserspasspref(prefs);
        if(!TextUtils.isEmpty(email)&& !TextUtils.isEmpty(password)){
            editTextEmail.setText(email);
            editTextPassword.setText(password);
        }
    }
        private boolean login(String email, String password){
            if (!IsValidEmail(email)){
                Toast.makeText(this, "Email no válido, ingrese otro", Toast.LENGTH_LONG).show();
                return false;
            }else if(!IsValidPassword(password)){
                Toast.makeText(this, "Password no válido, ingrese 4 caracteres e intente de nuevo", Toast.LENGTH_LONG).show();
                return false;

            }else{
                return true;
            }
        }private void saveOnPreferences(String email, String password){
            if(SwichRemember.isChecked()){
                SharedPreferences.Editor editor= prefs.edit();
                editor.putString("email",email);
                editor.putString("pass",password);
                editor.commit();
                editor.apply();
            }
    }
        private boolean IsValidEmail(String Email){
            return !TextUtils.isEmpty(Email) && Patterns.EMAIL_ADDRESS.matcher(Email).matches();

        }private boolean IsValidPassword(String Password){
            return Password.length()>4;
        }private void GoToMain(){
            Intent intent=new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }


