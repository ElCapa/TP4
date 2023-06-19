package com.example.sinup;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
/** Controller relacionado a ficheiro fxml login.fxml onde qualquer tipo usuario pode fazer login
 *
 */
public class LoginController implements Initializable {

    @FXML
    private ImageView pedra1;

    @FXML
    private ImageView pedra2;
    @FXML
    private ImageView pedra3;
    @FXML
    private ImageView pedra4;
    @FXML
    private ImageView pedra5;
    @FXML
    private ImageView pedra6;
    @FXML
    private ImageView pedra7;
    @FXML
    private ImageView pedra8;
    @FXML
    private ImageView pedra9;
    @FXML
    private ImageView pedra10;
    @FXML
    private ImageView pedra11;
    @FXML
    private ImageView pedra12;
    @FXML
    private ImageView pedra13;
    @FXML
    private ImageView pedra14;
    @FXML
    private ImageView pedra15;
    @FXML
    private ImageView pedra16;
    @FXML
    private ImageView pedra17;
    @FXML
    private ImageView pedra18;
    @FXML
    private Button cancelbutton;
    @FXML
    private Label loginMessagemLabel;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Hyperlink goTosingup;
    @FXML
    static String loggedInUserName;
    @FXML
    static String loggedInEmail;

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }
    public void loginButtonOnAction(ActionEvent event){

        if(usernameTextField.getText().isBlank() == false & passwordField.getText().isBlank() == false){
            validateLogin();
        }else{
            loginMessagemLabel.setText("Please entar username and password");
        }

    }
    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyEstudante = "SELECT COUNT(1) FROM estudante WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordField.getText() + "'";

        String verifyProfessor = "SELECT COUNT(1) FROM professor WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordField.getText() + "'";

        String verifyFuncionario = "SELECT COUNT(1) FROM funcionario WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();


            ResultSet queryResultEstudante = statement.executeQuery(verifyEstudante);
            if (queryResultEstudante.next() && queryResultEstudante.getInt(1) == 1) {
                loginMessagemLabel.setText("Welcome, estudante!");
                loggedInUserName = usernameTextField.getText();
                redirectToHome();
                return;
            }

            ResultSet queryResultProfessor = statement.executeQuery(verifyProfessor);
            if (queryResultProfessor.next() && queryResultProfessor.getInt(1) == 1) {
                loginMessagemLabel.setText("Welcome, professor!");
                loggedInUserName = usernameTextField.getText();
                redirectToHome();
                return;
            }

            ResultSet queryResultFuncionario = statement.executeQuery(verifyFuncionario);
            if (queryResultFuncionario.next() && queryResultFuncionario.getInt(1) == 1) {
                loginMessagemLabel.setText("Welcome, Funcionario!");
                loggedInUserName = usernameTextField.getText();
                redirectToHome();
                return;
            }

            loginMessagemLabel.setText("Invalid login. Please try again!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccoundForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("singup.fxml"));
            Stage registarstage = new Stage();
            registarstage.setScene(new Scene(root, 600,400));
            registarstage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /**
         * Efeito pedras caindo
         */

        File brandingFile = new File("");

        applyRotationAnimation(pedra1);
        applyRotationAnimation(pedra2);
        applyRotationAnimation(pedra3);
        applyRotationAnimation(pedra4);
        applyRotationAnimation(pedra5);
        applyRotationAnimation(pedra6);
        applyRotationAnimation(pedra7);
        applyRotationAnimation(pedra8);
        applyRotationAnimation(pedra9);
        applyRotationAnimation(pedra10);
        applyRotationAnimation(pedra11);
        applyRotationAnimation(pedra12);
        applyRotationAnimation(pedra13);
        applyRotationAnimation(pedra14);
        applyRotationAnimation(pedra15);
        applyRotationAnimation(pedra16);
        applyRotationAnimation(pedra17);
        applyRotationAnimation(pedra18);

        applyFallAnimation(pedra1);
        applyFallAnimation(pedra2);
        applyFallAnimation(pedra3);
        applyFallAnimation(pedra4);
        applyFallAnimation(pedra5);
        applyFallAnimation(pedra6);
        applyFallAnimation(pedra7);
        applyFallAnimation(pedra8);
        applyFallAnimation(pedra9);
        applyFallAnimation(pedra10);
        applyFallAnimation(pedra11);
        applyFallAnimation(pedra12);
        applyFallAnimation(pedra13);
        applyFallAnimation(pedra14);
        applyFallAnimation(pedra15);
        applyFallAnimation(pedra16);
        applyFallAnimation(pedra17);
        applyFallAnimation(pedra18);


    }

    private void applyFallAnimation(ImageView imageView) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(20), imageView);
        translateTransition.setFromY(-400);
        translateTransition.setToY(400);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setDelay(Duration.seconds(Math.random() * 0));
        translateTransition.play();
    }
    private void applyRotationAnimation(ImageView imageView) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(15), imageView);
        rotateTransition.setAxis(Rotate.Z_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setDelay(Duration.seconds(Math.random() * 0));
        rotateTransition.play();
    }
    public void goToSingup(ActionEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("singup.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();

        goStage2.setScene(goScene2);
        goStage2.show();
    }

    private void redirectToHome() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Home1.fxml"));
            Stage homeStage = new Stage();
            homeStage.setScene(new Scene(root));
            homeStage.show();
            Stage currentStage = (Stage) usernameTextField.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}







