package ru.gb.javafxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML//когда делаем приватными сверху ставим форму
    private TextArea historyArea;
    @FXML
    private TextField userAnswer;

    private Game game;

    public Controller() {
        this.game = new Game();
    }

    public void clickCheckButton(ActionEvent actionEvent) {

    }
}