package br.com.fiap;

import java.sql.SQLException;

import br.com.fiap.conexao.ConnectionFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SecondaryController {

    public void salvar(){
        try {
            var conexao = ConnectionFactory.getConnection();
            System.out.println("conectado");
            conexao.close();
        } catch (SQLException e) {
            mostrarMensagemDeErro(e.getMessage());
        }
    }

    private void mostrarMensagemDeErro(String message) {
        var alerta = new Alert(AlertType.ERROR);
        alerta.setContentText(message);
        alerta.show();
    }

}