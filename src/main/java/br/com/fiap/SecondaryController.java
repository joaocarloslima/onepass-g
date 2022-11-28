package br.com.fiap;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.fiap.conexao.ConnectionFactory;
import br.com.fiap.dao.CredencialDao;
import br.com.fiap.model.Credencial;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController implements Initializable {

    @FXML private TextField local;
    @FXML private TextField login;
    @FXML private TextField senha;

    @FXML private TableView<Credencial> tabela;
    @FXML private TableColumn<Credencial, String> colunaLocal;
    @FXML private TableColumn<Credencial, String> colunaLogin;
    @FXML private TableColumn<Credencial, String> colunaSenha;

    public void salvar(){
        try {
            new CredencialDao().salvar(dadosDoFormulario());
            carregarDados();
        } catch (SQLException e) {
            mostrarMensagemDeErro(e.getMessage());
        }
    }

    private void carregarDados(){
        try {
            tabela.getItems().clear();
            tabela.getItems().addAll(new CredencialDao().listar());
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       colunaLocal.setCellValueFactory(new PropertyValueFactory<>("local"));
       colunaLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
       colunaSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
       carregarDados();
    }

}