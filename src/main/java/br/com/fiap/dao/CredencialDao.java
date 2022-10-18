package br.com.fiap.dao;

import java.sql.SQLException;

import br.com.fiap.conexao.ConnectionFactory;
import br.com.fiap.model.Credencial;

public class CredencialDao {

    public void salvar(Credencial credencial) throws SQLException {
        var conexao = ConnectionFactory.getConnection();
        var stm = conexao.prepareStatement("INSERT INTO senhas (local, login, senha) VALUES (?,?,?)");
        stm.setString(1, credencial.getLocal());
        stm.setString(2, credencial.getLogin());
        stm.setString(3, credencial.getSenha());
        stm.execute();
        conexao.close();
    }
    
}
