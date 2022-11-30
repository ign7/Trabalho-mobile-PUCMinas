package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicio extends AppCompatActivity {

    Button botaoCadastro;
    Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
        botaoCadastro = (Button)findViewById(R.id.cadastro);
        botaoLogin = (Button)findViewById(R.id.login);

        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               VaiPraTelaCadastro();
            }
        });
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VaiPraTelaLogin();
            }
        });
    }

    public void VaiPraTelaCadastro(){
        Intent it = new Intent(TelaInicio.this, TelaCadastro.class);
        startActivity(it);
    }

    public void VaiPraTelaLogin(){
        Intent it = new Intent(TelaInicio.this, TelaLogin.class);
        startActivity(it);
    }



}