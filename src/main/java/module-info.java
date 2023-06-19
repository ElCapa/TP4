module com.example.sinup {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    //requires mysql.connector.java;


    opens com.example.sinup to javafx.fxml;
    exports com.example.sinup;
}