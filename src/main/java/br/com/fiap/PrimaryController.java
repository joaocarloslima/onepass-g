package br.com.fiap;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class PrimaryController {

    @FXML private PasswordField senha;
    private String senhaMestra = "123";

    @FXML
    private void logar() throws IOException {
        if (senha.getText().equals(senhaMestra)){
            App.setRoot("secondary");
        }
    }
}
