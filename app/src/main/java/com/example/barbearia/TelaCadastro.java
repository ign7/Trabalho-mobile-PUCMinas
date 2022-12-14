package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TelaCadastro extends AppCompatActivity {

    EditText editId;
    EditText editNome;
    EditText editUsuario;
    EditText editEmail;
    EditText editSenha;
    EditText editTell;
    TextView resposta;
    Button cadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        editId=(EditText) findViewById(R.id.editId);
        editNome=(EditText) findViewById(R.id.EditNome);
        editEmail=(EditText) findViewById(R.id.editEmail);
        editSenha=(EditText) findViewById(R.id.editSenha);
        editTell=(EditText) findViewById(R.id.tell);

        cadastrar=(Button) findViewById(R.id.cadastrar);
        resposta=(TextView) findViewById(R.id.Results);


       cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag=true;
                //Integer codigo=Integer.parseInt(editId.getText().toString());
                String CadastroNome=editNome.getText().toString();
                String CadastroEmail=editEmail.getText().toString();
                String CadastroSenha=editSenha.getText().toString();
                String CadastroTell=editTell.getText().toString();
                try {
                    Connection conn = conexao.Conectar();
                    if (conn != null) {
                        String sql = "INSERT INTO cliente(nome,email,senha,telefone) VALUES  ('" + CadastroNome + "','" + CadastroEmail + "','" + CadastroSenha + "','" + CadastroTell + "');";
                        Statement st = conn.createStatement();
                        st.executeUpdate(sql);

                    }
                } catch (SQLException e) {
                    flag=false;
                    System.out.println("Error SQL");
                    e.printStackTrace();
                } catch (Exception e){
                    flag=false;
                    e.printStackTrace();
                }
                if(flag!=false) {
                    resposta.setText("Cadastro Efetuado com Sucesso !!");
                    VaiPraTelaInicio();

                }
                else{
                    resposta.setText("Erro,Tente Novamente !!");
                }
            }
        });
    }

    public void VaiPraTelaInicio(){
        Intent it = new Intent(TelaCadastro.this,TelaInicio.class);
        startActivity(it);
    }




}