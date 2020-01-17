package com.example.u1t2trabajosencargados.musica;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.u1t2trabajosencargados.R;
import java.util.Vector;

public class Musica extends AppCompatActivity implements InterfaceToast {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MiAdaptador adaptador;
    private Vector<String> misdatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        recyclerView = findViewById(R.id.recycler_view);
        misdatos = new Vector<String>();
        misdatos.add("123000 Wilson Callisaya");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("111000 Pedro Martinez");
        misdatos.add("011000 Paco Pérez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("111000 Pedro Martinez");
        misdatos.add("011000 Paco Pérez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("111000 Pedro Martinez");
        misdatos.add("011000 Paco Pérez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("123000 Pepito Domingez");
        misdatos.add("111000 Pedro Martinez");
        misdatos.add("011000 Paco Pérez");

        adaptador = new MiAdaptador(this, misdatos);
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void mensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
