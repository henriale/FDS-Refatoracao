package uinterface.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import uinterface.model.Main;

import java.io.IOException;

public class MainController {
    @FXML
    private MenuButton newClientMenuButton;

    @FXML
    private MenuItem newClientButton;

    @FXML
    private MenuItem newPartnerButton;

    @FXML
    private Button clientExit;

    @FXML
    private MenuButton consultClientsMenu;

    @FXML
    private MenuItem consultClients;

    @FXML
    private MenuItem consultPerGender;

    @FXML
    private MenuItem consultPerPartner;

    @FXML
    private MenuItem consultPerCpf;

    @FXML
    private Button exitBtn;

    public void newClient() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/new_client_interface.fxml"));
        Stage stage = (Stage) newClientMenuButton.getScene().getWindow();
        stage.setTitle("Novo cliente :)");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void newPartner() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/new_partner_interface.fxml"));
        Stage stage = (Stage) newClientMenuButton.getScene().getWindow();
        stage.setTitle("Novo sócio :)");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void consultClient(ActionEvent actionEvent) throws IOException {
        Parent root;
        if (actionEvent.getSource() == consultClients) {
            root = FXMLLoader.load(getClass().getResource("../view/consult_clients_interface.fxml"));
        } else if (actionEvent.getSource() == consultPerCpf) {
            root = FXMLLoader.load(getClass().getResource("../view/consult_client_cpf_interface.fxml"));
        } else if (actionEvent.getSource() == consultPerGender) {
            root = FXMLLoader.load(getClass().getResource("../view/consult_client_gender_interface.fxml"));
        } else if (actionEvent.getSource() == consultPerPartner) {
            root = FXMLLoader.load(getClass().getResource("../view/consult_client_partners_interface.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("../view/main_interface.fxml"));
        }

        Stage stage = (Stage) consultClientsMenu.getScene().getWindow();
        stage.setTitle("Consultas");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void clientExit() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/client_exit_interface.fxml"));
        Stage stage = (Stage) clientExit.getScene().getWindow();
        stage.setTitle("Cliente saindo :(");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void exit() throws Exception {
        if (!Main.getBar().consultaClientes().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ops, ainda não...");
            alert.setHeaderText(null);
            alert.setContentText("Você não pode fechar o bar, ainda há clientes nele!");

            alert.showAndWait();
        } else {
            Main.getBar().fechar();
        }
    }
}
