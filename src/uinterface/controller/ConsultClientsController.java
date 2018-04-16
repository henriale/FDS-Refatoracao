package uinterface.controller;

/*
Classe Controller da Screen de consulta de clientes
Implementa a classe Initializable para popular automaticamente a listview
 */

import business.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import uinterface.model.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConsultClientsController implements Initializable {
    @FXML
    private Button backBtn;

    @FXML
    private ListView<Client> clients;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateListView();
    }

    public void populateListView() {
        for (Client client : Main.getBar().consultaClientes()) {
            clients.getItems().add(client);
        }
    }

    public void moveMain() throws IOException {
        Main.backToMain((Stage) backBtn.getScene().getWindow());
    }
}
