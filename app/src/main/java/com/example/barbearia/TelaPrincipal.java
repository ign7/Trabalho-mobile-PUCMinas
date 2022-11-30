package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    Button agendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        agendar =(Button) findViewById(R.id.agendar);

        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VaiPraTelaRelatorio();
            }
        });
    }

    public void VaiPraTelaRelatorio() {
        Intent it = new Intent(TelaPrincipal.this, TelaRelatorioAgendamento.class);
        startActivity(it);
     }

}