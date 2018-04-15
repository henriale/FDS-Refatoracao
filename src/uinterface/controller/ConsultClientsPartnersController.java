package uinterface.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import uinterface.model.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConsultClientsPartnersController implements Initializable {
    @FXML
    private Button backBtn;

    @FXML
    private Label partnerLabel;

    @FXML
    private Label nonPartnerLabel;

    @FXML
    private Label partnerPercentage;

    @FXML
    private Label nonPartnerPercentage;

    public void backToMenu() throws IOException {
        Main.backToMain((Stage) backBtn.getScene().getWindow());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partnerPercentage.setText(Main.getBar().percentualSocios().getRegistered()*100 + "%");
        nonPartnerPercentage.setText(Main.getBar().percentualSocios().getUnregistered()*100 + "%");
    }


}
