package com.example.sinup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.io.IOException;

/** Controller relacionado a ficheiro fxml singup.fxml para escolha de tipo usuario
 *
 */
public class HelloController {
    @FXML
    private RadioButton professorRadioButton;
    @FXML
    private RadioButton estudanteRadioButton;
    @FXML
    private RadioButton funcionarioRadioButton;
    @FXML
    private Button continueButton;
    @FXML
    private void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();
        professorRadioButton.setToggleGroup(toggleGroup);
        estudanteRadioButton.setToggleGroup(toggleGroup);
        funcionarioRadioButton.setToggleGroup(toggleGroup);
    }
    @FXML
    private void continuar() {
        if (professorRadioButton.isSelected()) {
            carregarFXML("singup2.fxml");
        } else if (estudanteRadioButton.isSelected()) {
            carregarFXML("singup1.fxml");
        } else if (funcionarioRadioButton.isSelected()) {
            carregarFXML("singup3.fxml");
        } else {
            welcomeText.setText("Escolha uma opção");
        }
    }

    private void carregarFXML(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) continueButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}