package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TelaPrincipal extends AppCompatActivity {

    Button agendar;
    Button newDate;
    TextView Data;
    EditText Horario;
    public String minhaData;
    Calendar calendario;
    DatePickerDialog DataMarcada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        calendario = Calendar.getInstance();
        agendar =(Button) findViewById(R.id.agendar);
        Data=(TextView) findViewById(R.id.idData);
        newDate =(Button) findViewById((R.id.EditData));
       Horario=(EditText) findViewById((R.id.EditHoras));
        String horas=Horario.getText().toString();
        DataMarcada = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
               Calendar dataSelecionada = Calendar.getInstance();
               dataSelecionada.set(year,month,dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Data.setText(format.format(dataSelecionada.getTime()));
            }
        }, calendario.get(Calendar.YEAR),calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH));

       newDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataMarcada.show();
            }
        });

        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VaiPraTelaRelatorio();
                }
        });
    }

    public void VaiPraTelaRelatorio() {
        Intent it = new Intent(TelaPrincipal.this, TelaRelatorioAgendamento.class);
        it.putExtra("data",Data.getText());
        it.putExtra("horario",Horario.getText().toString());
        startActivity(it);
     }
}