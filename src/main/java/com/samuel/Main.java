package com.samuel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("primary.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        scene.getStylesheets().add(
    Main.class.getResource("style.css").toExternalForm()
    );

        stage.setTitle("Sistema Bancário");
        stage.setHeight(600);
        stage.setWidth(400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        
        
    }
}
