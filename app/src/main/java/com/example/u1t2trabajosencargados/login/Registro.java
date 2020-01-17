package com.example.u1t2trabajosencargados.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.u1t2trabajosencargados.R;
import com.example.u1t2trabajosencargados.login.LoginPage;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true; /** true -> el menú ya está visible */
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.activity_login_page) {
            startActivity(new Intent(this, LoginPage.class));
            return true;
        }
        if (id == R.id.accion_salir) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
