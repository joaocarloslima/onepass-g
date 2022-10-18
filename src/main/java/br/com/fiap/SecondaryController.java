package br.com.fiap;

import java.sql.SQLException;

import br.com.fiap.conexao.ConnectionFactory;
import br.com.fiap.dao.CredencialDao;
import br.com.fiap.model.Credencial;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SecondaryController {

    @FXML private TextField local;
    @FXML private TextField login;
    @FXML private TextField senha;

    public void salvar(){
        try {
            new CredencialDao().salvar(dadosDoFormulario());
        } catch (SQLException e) {
            mostrarMensagemDeErro(e.getMessage());
        }
    }

    private Credencial dadosDoFormulario(){
        return new Credencial(local.getText(), login.getText(), senha.getText());
    }

    private void mostrarMensagemDeErro(String message) {
        var alerta = new Alert(AlertType.ERROR);
        alerta.setContentText(message);
        alerta.show();
    }

}