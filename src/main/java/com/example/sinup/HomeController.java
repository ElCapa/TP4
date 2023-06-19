package com.example.sinup;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/** Controller relacionado a ficheiro fxml Home.fxml para qunado usuario fazer login
 *
 */
public class HomeController implements Initializable{
    @FXML
    private Label nomeDeLogin;
    @FXML
    private ImageView close;
    @FXML
    private Label likeLabel;
    @FXML
    private Label likeLabel1;
    @FXML
    private Label likeLabel2;
    @FXML
    private Label likeLabel3;
    private int likeCount = 50;
    private int likeCount1 = 187;
    private int likeCount2 = 509;
    private int likeCount3 = 20;
    @FXML
    private boolean liked = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        likeLabel.setText(Integer.toString(likeCount));
        likeLabel1.setText(Integer.toString(likeCount1));
        likeLabel2.setText(Integer.toString(likeCount2));
        likeLabel3.setText(Integer.toString(likeCount3));
        nomeDeLogin.setText(LoginController.loggedInUserName);
    }
    public void goToSingup(MouseEvent event) throws IOException {
        Parent go2 = FXMLLoader.load(getClass().getResource("singup.fxml"));
        Scene goScene2 = new Scene(go2);
        Stage goStage2 = (Stage) ((Node)event.getSource()).getScene().getWindow();

        goStage2.setScene(goScene2);
        goStage2.show();
    }

    public void closeButtonOnAction(MouseEvent event){
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
    @FXML
    public void onImageClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
            if (liked) {
                likeCount--;
            } else {
                likeCount++;
            }
            liked = !liked;
            likeLabel.setText(Integer.toString(likeCount));
        }
    }
    @FXML
    public void onImageClick1(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
            if (liked) {
                likeCount1--;
            } else {
                likeCount1++;
            }
            liked = !liked;
            likeLabel1.setText(Integer.toString(likeCount1));
        }
    }
    @FXML
    public void onImageClick2(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
            if (liked) {
                likeCount2--;
            } else {
                likeCount2++;
            }
            liked = !liked;
            likeLabel2.setText(Integer.toString(likeCount2));
        }
    }
    @FXML
    public void onImageClick3(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
            if (liked) {
                likeCount3--;
            } else {
                likeCount3++;
            }
            liked = !liked;
            likeLabel3.setText(Integer.toString(likeCount3));
        }
    }
//    public void UploadImgOnAction () {
//        Stage primaryStage = new Stage();
//        FileChooser fc = new FileChooser();
//        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
//        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
//        fc.getExtensionFilters().addAll(ext1,ext2);
//        File file = fc.showOpenDialog(primaryStage);
//
//        BufferedImage bf;
//        try {
//            bf = ImageIO.read(file);
//            Image image = SwingFXUtils.toFXImage(bf, null);
//
//            circleFill.setFill(new ImagePattern(image));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}
