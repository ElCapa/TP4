package com.example.sinup;
import javafx.animation.*;
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
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Controller relacionado a ficheiro fxml singup1.fxml para Registar Estudantes
 *
 */

public class HelloController1 implements Initializable {
    @FXML
    private ComboBox<String> CombolList;
    @FXML
    private ComboBox<String> CombolList1;
    @FXML
    private ComboBox<String> CombolList2;
    @FXML
    private ImageView imageRotate;
    @FXML
    private ImageView pedra;
    @FXML
    private ImageView pessoas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Candidato", "Matriculado", "Suspenso", "Anulado", "Terminado");
        CombolList.setItems(list);
        ObservableList<String> list1 = FXCollections.observableArrayList("LEE", "LEIT", "LEM");
        CombolList1.setItems(list1);
        ObservableList<String> list2 = FXCollections.observableArrayList("1º ano", "2º ano", "3º ano", "4º ano");
        CombolList2.setItems(list2);

        /**
         * Fazer efeito para rotação de um imagem
         */
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(30), imageRotate);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(20), pessoas);
        translateTransition.setFromY(50);
        translateTransition.setToY(-10);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.play();

        /**
         * fazer efeito simulando os estundantes a andar
         */

        ScaleTransition zoomInTransition = new ScaleTransition(Duration.seconds(2), pedra);
        zoomInTransition.setToX(1.25);
        zoomInTransition.setToY(1.25);
        ScaleTransition zoomOutTransition = new ScaleTransition(Duration.seconds(2), pedra);
        zoomOutTransition.setToX(1.0);
        zoomOutTransition.setToY(1.0);
        zoomInTransition.setAutoReverse(true);
        zoomOutTransition.setAutoReverse(true);
        zoomInTransition.setCycleCount(ScaleTransition.INDEFINITE);
        zoomOutTransition.setCycleCount(ScaleTransition.INDEFINITE);
        zoomInTransition.play();
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(5));
        pauseTransition.setOnFinished(event -> {
            zoomInTransition.stop();
            zoomOutTransition.play();
        });
        pauseTransition.play();

        CombolList.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Scene scene = CombolList.getScene();
                String cssFile = getClass().getResource("style.css").toExternalForm();
                scene.getStylesheets().add(cssFile);
            }
        });

    }

    @FXML
    public void goToLogin(MouseEvent event) throws IOException {
        Parent go1 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene goScene1 = new Scene(go1);
        Stage goStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

        goStage1.setScene(goScene1);
        goStage1.show();
    }

    @FXML
    TextField email1;

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

      String insertFields = "INSERT INTO estudante (firstname, lastname, username, email, password) VALUES ('";
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


}



