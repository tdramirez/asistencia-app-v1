package com.example.myasistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;




public class ListaEstudiantes extends AppCompatActivity {

    private TextView text1;
    //String nombreCuro = getIntent().getExtras().getString("parametro");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiantes);

        text1 = (TextView)findViewById(R.id.titulo);
        text1.setText("Curso ");

    }
}