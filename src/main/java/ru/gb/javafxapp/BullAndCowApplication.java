package ru.gb.javafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BullAndCowApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(BullAndCowApplication.class.getResource(
                        "main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 240);
        //размер окна
        stage.setTitle("Bulls and Cows Game!");
        stage.setScene(scene);
        stage.show();//показать оконо
    }

    public static void main(String[] args) {
        launch();
    }
}