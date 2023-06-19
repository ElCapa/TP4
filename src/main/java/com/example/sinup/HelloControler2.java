package com.example.sinup;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

/** Controller relacionado a ficheiro fxml singup2.fxml para Registar Porfessores
 *
 */
public class HelloControler2 {
    @FXML
    private Text texto;
    @FXML
    private Button close;
    @FXML
    private ImageView goBack;
    @FXML
    private Label messagemRegistro;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmarPassword;
    @FXML
    private Label passwordInvalido;
    @FXML
    private TextField UserName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField emailaccount;
    @FXML
    private ComboBox  CombolList;
    @FXML
    private ComboBox  CombolList1;
    @FXML
    private ComboBox  CombolList2;

    public void initialize() {
        /** Fazer efeito de um texto aparecendo letra por letra
         *
         */
        final String fullText = texto.getText();
        texto.setText("");

        final int animationDelay = 50;

        Timeline timeline = new Timeline();

        for (int i = 0; i < fullText.length(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(i * animationDelay), event -> {
                texto.setText(fullText.substring(0, index + 1));
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setCycleCount(1);
        timeline.play();

        ObservableList<String> list = FXCollections.observableArrayList("Licenciado", "Doutorado", "Mestrado");
        CombolList.setItems(list);
        ObservableList<String> list1 = FXCollections.observableArrayList("Ensino Infantil", " Ensino Básico", "Ensino Fundamental ");
        CombolList1.setItems(list1);
        ObservableList<String> list2 = FXCollections.observableArrayList("Academico", "Pedagogico", "Financero");
        CombolList2.setItems(list2);

        CombolList.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Scene scene = CombolList.getScene();
                String cssFile = getClass().getResource("style.css").toExternalForm();
                scene.getStylesheets().add(cssFile);
            }
        });

    }
    public void goToBack(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("singup.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();

        goStage2.setScene(goScene2);
        goStage2.show();
    }
    public void goToPage2(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();

        goStage2.setScene(goScene2);
        goStage2.show();
    }
    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
    public void registarButtonOnAction(ActionEvent event) {
        if (Password.getText().equals(ConfirmarPassword.getText())) {
            regitarUser();
            passwordInvalido.setText("");
        }else {
            passwordInvalido.setText("Invaly");
        }
    }
    public void regitarUser() {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();

        String firstname = FirstName.getText();
        String lastname = LastName.getText();
        String username = UserName.getText();
        String password = Password.getText();
        String email = emailaccount.getText();

        String insertFields = "INSERT INTO professor (firstname, lastname, username, email, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + email + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectionDB.createStatement();
            statement.executeUpdate(insertToRegister);

            messagemRegistro.setText("User has been registered successfully!");
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}

