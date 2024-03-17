package com.example.notasapp;

import static com.example.notasapp.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    Adapter adapter;
    List<NotaModelo> listaNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        recycler = findViewById(id.recycler);
        NotasDatabase notasDB = new NotasDatabase(this);
        listaNotas = notasDB.getNote();  //llamo al List de la bbdd

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        recycler.setLayoutManager(layoutManager);
        adapter = new Adapter(this, listaNotas);
        recycler.setAdapter(adapter);
    }
//hago visible el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }
    // ponemos el intent en el item del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add);
        Intent i = new Intent(MainActivity.this, NuevaNota.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}