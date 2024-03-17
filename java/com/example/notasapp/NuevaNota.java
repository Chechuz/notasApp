package com.example.notasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class NuevaNota extends AppCompatActivity {
    EditText titulo, detalle;
    Button btnAdd;
    String fecha, hora;
    Calendar calendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_nota);
        //habilia boton "home" en la barra, edito titulo en la barra
        getSupportActionBar().setTitle("Nueva Nota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titulo = findViewById(R.id.anadeNota);
        detalle= findViewById(R.id.cuerpoNota);
        btnAdd= findViewById(R.id.btn_guardar);
        //Para que muestre fecha y hora de la nota
        calendario = Calendar.getInstance();
        fecha=calendario.get(Calendar.YEAR)+"/"+ calendario.get(Calendar.MONTH)+"/"+ calendario.get(Calendar.DAY_OF_MONTH);
        hora = pad(calendario.get(Calendar.HOUR))+":"+ pad(calendario.get(Calendar.MINUTE));
        Log.d("calendar", "Fecha y Hora "+fecha+ "/"+hora);

        //Programamos el boton para guardar la nota en la base de datos
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotaModelo notaModelo= new NotaModelo(titulo.getText().toString(), detalle.getText().toString(),fecha, hora);
                NotasDatabase db = new NotasDatabase(NuevaNota.this);
                db.anadeNota(notaModelo);
                // Pongo el intent para volver al main
                Intent intent = new Intent(NuevaNota.this, MainActivity.class);
                startActivity(intent);
                // aviso al usuario que la nota ha sido guardada
                Toast.makeText(NuevaNota.this, "Nota guardada", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //metodo para que la hora se visualice correctamente (con dos caracteres siempre)
    public String pad(int i){
        if(i<0)
            return "0"+i;
        return String.valueOf(i);
    }
        //metodo para finalizar este activity en caso de presionar "home" en la barra
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}