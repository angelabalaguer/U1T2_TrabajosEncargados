package com.example.u1t2trabajosencargados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {
    EditText usuario ;
    EditText password;
    Button btnejecutar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        usuario=findViewById(R.id.etusuariof);
        password=findViewById(R.id.etpasswordf);
        btnejecutar=findViewById(R.id.btnejecutarf);
        btnejecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usu=usuario.getText().toString();
                String pass=password.getText().toString();

                if (usu == "alumno" ){
                    if (pass == "Andorid" ){
                        Log.d("myTag", "This is my message");
                    }
                }
            }
        });

    }
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true; /** true -> el menú ya está visible */
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.activity_registro) {
            startActivity(new Intent(this, registro.class));
            return true;
        }
        if (id == R.id.accion_salir) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
