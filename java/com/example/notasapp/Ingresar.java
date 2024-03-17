package com.example.notasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ingresar extends AppCompatActivity {
    Button btnEntrar;
    EditText etiNombre;
    TextView tvSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        btnEntrar=(Button) findViewById(R.id.btnEntrar);
        etiNombre =(EditText) findViewById(R.id.etiName);
        tvSaludo =(TextView) findViewById(R.id.tvBienv);

        cargarPreferencias();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPreferencia();
                Intent i = new Intent(Ingresar.this,MainActivity.class);
                startActivity(i);

            }
        });

    }
    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);
        String user= preferences.getString("user","Bienvenid@ !");
    }
    private void guardarPreferencia(){
        SharedPreferences preferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);
        String name=etiNombre.getText().toString();

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("user", name);
        tvSaludo.setText("Bienvenid@ de nuevo "+name);
        editor.commit();
    }

}