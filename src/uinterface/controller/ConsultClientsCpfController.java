package uinterface.controller;

import business.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import uinterface.model.Main;

import java.io.IOException;

public class ConsultClientsCpfController {
    @FXML
    private Button backBtn;

    @FXML
    private Button consultBtn;

    @FXML
    private Label cpf;

    @FXML
    private Label clientNotFound;

    @FXML
    private Label client;

    @FXML
    private TextField cpfField;


    public void searchClient() {
        Customer customerFromCpf = Main.getBar().queryCustomer(cpfField.getText());
        if (customerFromCpf != null) {
            client.setText(customerFromCpf.toString());
            clientNotFound.setVisible(false);
            client.setVisible(true);
        } else {
            clientNotFound.setVisible(true);
        }
    }

    public void backToMenu() throws IOException {
        Main.backToMain((Stage) backBtn.getScene().getWindow());
    }
}
