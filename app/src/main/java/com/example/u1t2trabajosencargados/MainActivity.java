package com.example.u1t2trabajosencargados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
