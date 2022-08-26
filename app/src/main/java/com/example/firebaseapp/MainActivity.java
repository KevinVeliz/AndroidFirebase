package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextMensaje;
    private EditText mEditTextOcupacion;
    private Button mBtnCrearDatos;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextMensaje = (EditText) findViewById(R.id.editTextMensaje);
        mEditTextOcupacion = (EditText) findViewById(R.id.editTextOcupacion);
        mBtnCrearDatos = (Button) findViewById(R.id.btnCrearDatos);

        //Referencia al nodo principal de nuestra fase de datos.
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Personas");

        mBtnCrearDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertPersonasData();

            }
        });


    }

    private void insertPersonasData(){
        String name= mEditTextMensaje.getText().toString();
        String ocupacion = mEditTextOcupacion.getText().toString();
        Personas persona = new Personas(name,ocupacion);
        mDatabase.push().setValue(persona);
        Toast.makeText(MainActivity.this,"Datos ingresados", Toast.LENGTH_SHORT).show();
    }
}