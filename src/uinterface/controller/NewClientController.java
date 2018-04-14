package uinterface.controller;

/*
Classe Controller da Screen de novo cliente
 */

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import uinterface.model.Main;

import java.io.IOException;

public class NewClientController {
    @FXML
    private ToggleGroup group = new ToggleGroup();

    @FXML
    private TextField clientName;

    @FXML
    private TextField clientAge;

    @FXML
    private TextField clientCpf;

    @FXML
    private Button cancelNewClientButton;

    @FXML
    private Button addNewClientButton;

    @FXML
    private RadioButton rbClientMale;

    @FXML
    private RadioButton rbClientFemale;

    @FXML
    private Label clientAdded;

    @FXML
    private Label cpfAlreadyExists;

    /*
    Nenhum textfield ta com restricoes
    Entao aceita int, string, tudo
    A diferenca eh que na hora de criar o objeto, se ele nao digitou certo, os campos ficam null
    Idade: int
    CPF: String com 11 caracteres
     */
    public void newClient() throws IOException {
        Main.createClient(clientName, clientCpf, clientAge, rbClientFemale, clientAdded, cpfAlreadyExists);
    }

    public void moveMain() throws IOException {
        Main.backToMain((Stage) cancelNewClientButton.getScene().getWindow());
    }
}
