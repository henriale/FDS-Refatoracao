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

public class ConsultClientsGenderController implements Initializable {
    @FXML
    private Button backBtn;

    @FXML
    private Label maleLabel;

    @FXML
    private Label femaleLabel;

    @FXML
    private Label malePercentage;

    @FXML
    private Label femalePercentage;

    public void backToMenu() throws IOException {
        Main.backToMain((Stage) backBtn.getScene().getWindow());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        malePercentage.setText(Main.getBar().getGenderRate().getMale() * 100 + "%");
        femalePercentage.setText(Main.getBar().getGenderRate().getFemale() * 100 + "%");
    }


}
