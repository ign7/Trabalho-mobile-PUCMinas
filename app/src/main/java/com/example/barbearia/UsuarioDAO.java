package com.example.barbearia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {

    public Usuario selecionaUsuario(String Email, String Senha) {
        try {
            Connection conn = conexao.Conectar();
            if (conn != null) {
                String sql = " SELECT * FROM cliente WHERE email='"+Email+"' AND senha='" +Senha +"'";
                Statement st = null;
                st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Usuario usu = new Usuario();
                    usu.setNome(rs.getString(1));
                    usu.setEmail(rs.getString(2));
                    usu.setSenha(rs.getString(3));
                    usu.setTelefone(rs.getString(4));
                    conn.close();
                    return usu;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

