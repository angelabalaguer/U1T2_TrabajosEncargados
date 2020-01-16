package com.example.u1t2trabajosencargados;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    EditText usuario ;
    EditText password;
    Button btnejecutar;
    TextView txtresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        usuario=findViewById(R.id.etusuariof);
        password=findViewById(R.id.etpasswordf);
        btnejecutar=findViewById(R.id.btnejecutarf);
        txtresultado=findViewById(R.id.txtResultado);


        btnejecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usu=usuario.getText().toString();
                String pass=password.getText().toString();

                txtresultado.setText(usu + " el monto de "+ pass+
                        " dolares equivale a " );

                if (usu == "angela"  && pass == "android" ){
                    mostrarDialogoYES();
                   // permisos()
                }else{
                    mostrarDialogo();

                }
            }
        });

    }

     void permisos() {
         if ((ContextCompat.checkSelfPermission(LoginPage.this,
                 android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) &&
                 (ContextCompat.checkSelfPermission(this,
                         Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)){
             arranque();
         } else {
             Handler handler = new Handler();
             handler.postDelayed(
                     new Runnable() {
                         public void run() {
                             if (ContextCompat.checkSelfPermission(LoginPage.this,
                                     android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                                 permisocamara();
                             } else {
                                 solicitarPermiso(Manifest.permission.ACCESS_FINE_LOCATION,
                                         "Sin el permiso" + " de telefono no podemos realizar llamadas.", 0);
                             }
                         }
                     }, 2000L);
         }
    }



    public void solicitarPermiso(final String permiso, String justificacion, final int codigo) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permiso)) {
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Solicitud de permiso");
            dialogo1.setMessage(justificacion);
            dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    ActivityCompat.requestPermissions(LoginPage.this, new String[]{permiso}, codigo);
                }
            });
            dialogo1.show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permiso}, codigo);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permisocamara();
            } else {
                solicitarPermiso(Manifest.permission.ACCESS_FINE_LOCATION,
                        "Sin el permiso" + " de UBICACION no podemos realizar llamadas.", 0);
            }
        }
        if (requestCode == 1) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                arranque();
            } else {
                solicitarPermiso(Manifest.permission.CAMERA,
                        "Sin el permiso" + " de CAMARA no podremos localizarte", 1);
            }
        }


    }
    void arranque() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("FELICITACIONES");
        dialogo1.setMessage("Usted ya tiene los permisos necesarios para usar nuestra app");
        dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                finish();
            }
        });
        dialogo1.show();
    }

    void permisocamara(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            arranque();

        } else {
            solicitarPermiso(Manifest.permission.CAMERA,
                    "Sin el permiso" + " de Almacenamiento no podemos guardar su informacion.", 2);
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true; /** true -> el menú ya está visible */
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.activity_registro) {
            startActivity(new Intent(this, Registro.class));
            return true;
        }
        if (id == R.id.accion_salir) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void mostrarDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("DATOS INCORRECTOS");
        builder.setMessage("Por favor verifique sus datos").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).show();
    }

    private void mostrarDialogoYES(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("BIENVENIDO");
        builder.setMessage("Por favor verifique sus datossssss").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        }).show();
    }
}
