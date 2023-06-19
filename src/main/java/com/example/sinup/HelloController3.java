package com.example.sinup;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

/** Controller relacionado a ficheiro fxml singup3.fxml para Registar Funcionarios
 *
 */

public class HelloController3 implements Initializable {
    @FXML
    private Label messagemRegistro;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmarPassword;
    @FXML
    private Button close;
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
    private ComboBox CombolList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CombolList.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Scene scene = CombolList.getScene();
                String cssFile = getClass().getResource("style.css").toExternalForm();
                scene.getStylesheets().add(cssFile);
            }
        });
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
    public void goToBack(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("singup.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();

        goStage2.setScene(goScene2);
        goStage2.show();
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

        String insertFields = "INSERT INTO funcionario (firstname, lastname, username, email, password) VALUES ('";
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
    @FXML
    public void goToLogin(MouseEvent event) throws IOException {
        Parent go1 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene goScene1 = new Scene(go1);
        Stage goStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

        goStage1.setScene(goScene1);
        goStage1.show();
    }
}
