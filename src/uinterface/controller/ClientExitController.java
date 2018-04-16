package uinterface.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import uinterface.model.Main;

import java.io.IOException;

public class ClientExitController {
    @FXML
    private Button cancelClientExit;

    @FXML
    private Button confirmClientExit;

    @FXML
    private Label goodbye;

    @FXML
    private Label clientNotFound;

    @FXML
    private TextField clientCpf;

    public void moveMain() throws IOException {
        Main.backToMain((Stage) cancelClientExit.getScene().getWindow());
    }


    public void clientExit() {
        String cpf = clientCpf.getText();
        if (Main.getBar().customerExists(cpf)) {
            Main.getBar().removeCustomer(cpf);
            goodbye.setVisible(true);
            Timeline timelineExitClient = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> goodbye.setVisible(false)));
            timelineExitClient.play();
        } else {
            clientNotFound.setVisible(true);
            Timeline timelineClientNotFound = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> clientNotFound.setVisible(false)));
            timelineClientNotFound.play();
        }
    }
}
