package com.example.u1t2trabajosencargados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.u1t2trabajosencargados.login.LoginPage;
import com.example.u1t2trabajosencargados.login.Permisos;
import com.example.u1t2trabajosencargados.musica.Musica;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Login(View view) {
        startActivity(new Intent(this, LoginPage.class));

    }

    public void Musica(View view) {

        startActivity(new Intent(this, Musica.class));
    }
}
