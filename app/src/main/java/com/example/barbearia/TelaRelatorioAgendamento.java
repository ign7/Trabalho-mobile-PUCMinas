package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TelaRelatorioAgendamento extends AppCompatActivity {

    Button agendamento;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_relatorio_agendamento);
        agendamento =(Button) findViewById(R.id.agendamento);
        resultado=(TextView)findViewById(R.id.TextResult);
        String MeuHorario=getIntent().getStringExtra("horario");
        String _Data=getIntent().getStringExtra("data");

        agendamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flag=true;
                Integer id=1;
                try {
                    Connection conn = conexao.Conectar();
                    if (conn != null) {
                        String sql = "INSERT INTO agenda(idcliente,hora) VALUES  ("+id+",'"+ _Data+"');";
                        Statement st = conn.createStatement();
                        st.executeUpdate(sql);
                    }
                } catch (SQLException e) {
                    flag=false;
                    System.out.println("Error SQL");
                    e.printStackTrace();
                } catch (Exception e) {
                    flag=false;
                    e.printStackTrace();
                }
                if(flag!=false) {
                    resultado.setText("Seu Horario foi Marcado!!Dia :"+_Data+",Horas :"+MeuHorario+"");
                }
                else{
                    resultado.setText("Horario  ja marcado,Tente Novamente !!");
                }
            }
        });
    }
}