package com.example.prestamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Nombre, Telefono, Cedula, Direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre = (EditText) findViewById(R.id.edNombre);
        Telefono = (EditText) findViewById(R.id.edTelefono);
        Cedula = (EditText) findViewById(R.id.edCedula);
        Direccion = (EditText) findViewById(R.id.edDireccion);
        Button button = findViewById(R.id.btContinuar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Nombre.getText().toString().isEmpty()) {
                    Nombre.setError("Campo Obligatorio");
                    Toast.makeText(MainActivity.this,"Revise los campos", Toast.LENGTH_SHORT).show();
                } else if (Telefono.getText().toString().isEmpty()) {
                    Telefono.setError("Campo obligatorio");
                    Toast.makeText(MainActivity.this, "Revise los campos", Toast.LENGTH_SHORT).show();
                } else if (Cedula.getText().toString().isEmpty()) {
                    Cedula.setError("Campo Obligatorio");
                    Toast.makeText(MainActivity.this, "Revise los campos", Toast.LENGTH_SHORT).show();
                } else if (Direccion.getText().toString().isEmpty()) {
                    Direccion.setError("Campo obligatorio");
                    Toast.makeText(MainActivity.this, "Revise los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
