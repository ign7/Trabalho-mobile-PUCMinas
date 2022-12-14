package com.example.barbearia;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    public static Connection Conectar()  {
        Connection conn = null;
       try{
           StrictMode.ThreadPolicy politica;
           politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
           StrictMode.setThreadPolicy(politica);
           Class.forName("net.sourceforge.jtds.jdbc.Driver");
           String ip="192.168.15.86:1433";
           String db="nova";
           String senha="1234";
           String user="igorf";
           String connString="jdbc:jtds:sqlserver://"+ip+";databaseName="+db+";user="+user+";password="+senha+";";
           conn= DriverManager.getConnection(connString);

       }catch (ClassNotFoundException e){
           System.out.println("Classe nao encontrada !!!");
           e.printStackTrace();
       }
       catch(SQLException e) {
           System.out.println("erro ao obter conexão SQL!!");
           e.printStackTrace();
       }
       catch (Exception e){
           e.printStackTrace();
       }
        return conn;
    }

}
