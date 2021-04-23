package com.example.myasistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner1 ;
    private Button boton1;

    String[] strStudianes;
    List<String> listaEstdiante;
    ArrayAdapter<String> comboAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner)findViewById(R.id.spinner_cursos) ;

        //spinner1.setOnItemClickListener(this);
        listaEstdiante = new ArrayList<>();
        strStudianes = new String[]{ "A/1", "B/2", "C/3"};
        Collections.addAll(listaEstdiante, strStudianes);
        comboAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaEstdiante);
        spinner1.setAdapter(comboAdapter);


        boton1 = findViewById(R.id.button);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListaEstudiantes.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    
}