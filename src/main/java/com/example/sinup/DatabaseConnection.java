package com.example.sinup;
import java.sql.Connection;
import java.sql.DriverManager;

/** Conexcão com minha Database mysql
 *
 */
public class DatabaseConnection {
    public Connection databaselink;

    public Connection getConnection(){
        String databaseName = "pedradaDigital";
        String databaseUser = "root";
        String databasePassword = "@Elcapa99";
        String url  = "jdbc:mysql://localhost/" + databaseName ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaselink;
    }
}
