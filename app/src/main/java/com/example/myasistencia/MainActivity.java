package com.example.myasistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner1 ;
    private Button boton1;

    String[] strCursos;
    List<String> listaCursos;
    ArrayAdapter<String> comboAdapter;
    String nombreCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner)findViewById(R.id.spinner_cursos) ;

        //spinner1.setOnItemClickListener(this::onItemSelected);
        listaCursos = new ArrayList<>();
        strCursos = new String[]{ "A/1", "B/2", "C/3"};
        Collections.addAll(listaCursos, strCursos);
        comboAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaCursos);
        spinner1.setAdapter(comboAdapter);
        nombreCurso = (String)spinner1.getSelectedItem();




        boton1 = findViewById(R.id.button);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello "+nombreCurso,Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(v.getContext(), ListaEstudiantes.class);
                intent.putExtra("parametro", nombreCurso);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         nombreCurso = (String)spinner1.getSelectedItem();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}