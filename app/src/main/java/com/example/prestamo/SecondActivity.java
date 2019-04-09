package com.example.prestamo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {
    private TextView MontoCuota, MontoPagar;
    private EditText MontoCredito, Plazo, FechaActual, FechaFinal;
    private Spinner Interes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String fecha = new SimpleDateFormat("d/M/yyyy").format(new Date());
        FechaActual = findViewById(R.id.etFecha);
        FechaFinal = findViewById(R.id.etFechaFinal);
        FechaActual.setText(fecha);

        Button finalizar = findViewById(R.id.btFinalizar);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"Gracias!", Toast.LENGTH_SHORT ).show();
            }
        });
        Interes = findViewById(R.id.spInteres);
        Interes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                saldo_pendiente();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        MontoCredito = findViewById(R.id.etMontoCredito);
        MontoCredito.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saldo_pendiente();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Plazo = findViewById(R.id.etPlazo);
        Plazo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                saldo_pendiente();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        MontoPagar = findViewById(R.id.twMontoPagar1);
        MontoCuota = findViewById(R.id.twMontoCuota1);
    }
    public void saldo_pendiente()
    {
        int monto = 0;
        int porcentaje = 0;
        int meses = 0;
        float interes = 0;
        float saldo = 0;
        float cuota = 0;
        if(MontoCredito.getText().toString().length()!=0){
            monto=Integer.valueOf(MontoCredito.getText().toString());
        }
        porcentaje=Integer.valueOf(Interes.getSelectedItem().toString());
        interes =Float.valueOf((monto*porcentaje)/100);
        saldo = Float.valueOf(monto + interes);
        MontoPagar.setText(String.valueOf(saldo));
        Calendar fechafinal = Calendar.getInstance();
        int day = fechafinal.get(Calendar.DAY_OF_MONTH);
        int month;
        int year;
        if(Plazo.getText().toString().length()!=0){
            meses =Integer.valueOf(Plazo.getText().toString());
            saldo = Float.valueOf(monto + (interes*meses));
            cuota = Float.valueOf(saldo/meses);
            MontoPagar.setText(String.valueOf(saldo));
            MontoCuota.setText(String.valueOf(cuota));
            fechafinal.add(Calendar.MONTH, meses);
            month = fechafinal.get(Calendar.MONTH);
            month++;
            year = fechafinal.get(Calendar.YEAR);
            FechaFinal.setText(String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year));
        }
        else{
            MontoCuota.setText(String.valueOf(saldo));
            fechafinal.add(Calendar.MONTH, 1);
            month = fechafinal.get(Calendar.MONTH);
            month++;
            year = fechafinal.get(Calendar.YEAR);
            FechaFinal.setText(String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year));
        }
    }

}
