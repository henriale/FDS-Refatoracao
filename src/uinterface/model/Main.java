package uinterface.model;

/*
Classe Main, responsavel por executar a primeira instancia da UI
 */

import business.Bar;
import business.Client;
import business.Gender;
import business.Socio;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    private static Bar bar = new Bar();

    /*
    Nao sei se eh a melhor maneira para retirar os codigos duplicados
    Ate pq ta exatamente o metodo start ali de cima
    Mas ta funcionando :)
     */
    public static void backToMain(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("../view/main_interface.fxml"));
        stage.setTitle("Bora beber!!!");
        stage.setScene(new Scene(root, 300, 200));
        stage.show();
    }

    /*
    Mesma coisa que aqui em cima
    Nao sei se eh a melhor maneira de extrair metodos duplicados
    mas funciona :)
     */
    public static void createClient(TextField name, TextField partnerCpf, TextField age, RadioButton rbClientFemale, Label partnerAdded, Label cpfAlreadyExists) {
        String nome = name.getText();
        String cpf = partnerCpf.getText();
        int idade = Integer.parseInt(age.getText());
        Gender sexo = rbClientFemale.isSelected() ? Gender.FEMALE : Gender.MALE;
        if (!Main.getBar().contemCpf(cpf)) {
            Main.getBar().addCliente(new Client(nome, cpf, idade, sexo));
            partnerAdded.setVisible(true);
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> partnerAdded.setVisible(false)));
            timeline.play();
        } else {
            cpfAlreadyExists.setVisible(true);
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> cpfAlreadyExists.setVisible(false)));
            timeline.play();
        }
    }

    public static void createClient(TextField name, TextField partnerCpf, TextField age, TextField partnerNumber, RadioButton rbClientFemale, Label partnerAdded, Label cpfAlreadyExists) {
        String nome = name.getText();
        String cpf = partnerCpf.getText();
        int idade = Integer.parseInt(age.getText());
        Gender sexo = rbClientFemale.isSelected() ? Gender.FEMALE : Gender.MALE;
        String partnerId = partnerNumber.getText();
        if (!Main.getBar().contemCpf(cpf)) {
            Main.getBar().addCliente(new Socio(nome, cpf, idade, sexo, partnerId));
            partnerAdded.setVisible(true);
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> partnerAdded.setVisible(false)));
            timeline.play();
        } else {
            cpfAlreadyExists.setVisible(true);
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> cpfAlreadyExists.setVisible(false)));
            timeline.play();
        }
    }

    public static Bar getBar() {
        return bar;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/main_interface.fxml"));
        primaryStage.setTitle("Bora beber!!!");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }
}
