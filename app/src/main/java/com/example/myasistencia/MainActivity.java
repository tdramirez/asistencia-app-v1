package com.example.myasistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner)findViewById(R.id.spinner_cursos) ;
    }

    
}