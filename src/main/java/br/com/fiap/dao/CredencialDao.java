package br.com.fiap.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Credencial> listar() throws SQLException{
        var lista =  new ArrayList<Credencial>();

        var conexao = ConnectionFactory.getConnection();
        var stm  = conexao.prepareStatement("SELECT * FROM senhas ORDER BY local");
        var rs = stm.executeQuery();

        while(rs.next()){
            var credencial = new Credencial(
                rs.getInt("id"), 
                rs.getString("local"), 
                rs.getString("login"), 
                rs.getString("senha")
            );
            lista.add(credencial);
        }

        return lista;
    }
    
}
