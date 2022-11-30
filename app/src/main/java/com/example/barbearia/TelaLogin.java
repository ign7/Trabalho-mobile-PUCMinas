package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;

public class TelaLogin extends AppCompatActivity {

    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        entrar =(Button) findViewById(R.id.logar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VaiPraTelaPrincipal();
            }
        });


    }

   public void VaiPraTelaPrincipal(){
       Intent  it = new Intent(TelaLogin.this,TelaPrincipal.class);
       startActivity(it);
   }

}