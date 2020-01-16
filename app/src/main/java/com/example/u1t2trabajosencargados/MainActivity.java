package com.example.u1t2trabajosencargados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Musica(View view) {
        startActivity(new Intent(this, Ejercicio1.class));
    }

    public void Login(View view) {
        startActivity(new Intent(this, Ejercicio2.class));
    }
}
