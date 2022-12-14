package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {

    Button entrar;
    EditText Email;
    EditText Senha;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        entrar =(Button) findViewById(R.id.logar);
        Email=(EditText) findViewById(R.id.seuEmail);
        Senha=(EditText) findViewById(R.id.suaSenha);
        res=(TextView) findViewById(R.id.lbResultado);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logarEmail=Email.getText().toString();
                String logarSenha=Senha.getText().toString();
                Usuario usu = new UsuarioDAO().selecionaUsuario(logarEmail,logarSenha);
                if(usu!=null){
                    VaiPraTelaPrincipal();
                    res.setText("Login Efetuado com Sucesso");
                }else{
                    res.setText("Erro,Tente Novamente !!");
                }
            }
        });
    }



   public void VaiPraTelaPrincipal(){
       Intent  it = new Intent(TelaLogin.this,TelaPrincipal.class);
       startActivity(it);
   }

}