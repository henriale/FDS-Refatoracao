package uinterface.controller;

/*
Classe Controller da Screen de novo cliente
 */

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import uinterface.model.Main;

import java.io.IOException;

public class NewPartnerController {
    @FXML
    private ToggleGroup group = new ToggleGroup();

    @FXML
    private TextField partnerName;

    @FXML
    private TextField partnerAge;

    @FXML
    private TextField partnerCpf;

    @FXML
    private TextField partnerNumber;

    @FXML
    private Button cancelNewPartnerButton;

    @FXML
    private Button addNewPartnerButton;

    @FXML
    private RadioButton rbClientMale;

    @FXML
    private RadioButton rbClientFemale;

    @FXML
    private Label partnerAdded;

    @FXML
    private Label cpfAlreadyExists;

    @FXML
    private Label partnerNumberLabel;

    /*
    Nenhum textfield ta com restricoes
    Entao aceita int, string, tudo
    A diferenca eh que na hora de criar o objeto, se ele nao digitou certo, os campos ficam null
    Idade: int
    CPF: String com 11 caracteres
    Nº sócio: String
     */
    public void newClient() throws IOException {
        Main.createClient(partnerName, partnerCpf, partnerAge, partnerNumber, rbClientFemale, partnerAdded, cpfAlreadyExists);
    }

    public void moveMain() throws IOException {
        Main.backToMain((Stage) cancelNewPartnerButton.getScene().getWindow());
    }
}
