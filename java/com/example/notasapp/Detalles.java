package com.example.notasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Detalles extends AppCompatActivity {
TextView verTitulo,verDetalle;
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        //cambio titulo del action bar
        getSupportActionBar().setTitle("Detalle de la Nota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        verTitulo = findViewById(R.id.verDetalle);
        verDetalle = findViewById(R.id.verTitulo);

        NotasDatabase db = new NotasDatabase(this);
        Intent intent = getIntent();
        id= intent.getIntExtra("ID",0);
        NotaModelo notaModelo = db.getNotas(id);

        verTitulo.setText(notaModelo.getTitulo());
        verDetalle.setText(notaModelo.getDetalle());
        Toast.makeText(getApplicationContext(), "id "+ notaModelo.getId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_borrar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finish();
            return true;
        }
        if(item.getItemId()==R.id.delete){
            NotasDatabase db= new NotasDatabase(this);
            Intent intent= getIntent();
            id=intent.getIntExtra("ID", 0);
            db.eliminaNota(id);
            Toast.makeText(getApplicationContext(), "Nota eliminada", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Detalles.this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}