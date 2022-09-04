package ru.gb.javafxapp.Chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;




public class ControllerChat {
    @FXML//когда делаем приватными сверху ставим форму
    private TextArea historyArea;
    @FXML
    private TextField userAnswer;

    private PlayChat playChat;
    private int step;//ходы

    public ControllerChat() {
        this.playChat = new PlayChat();

    }

    public void clickCheckButton(ActionEvent actionEvent) {
        final String answer = userAnswer.getText();
        if (answer.isBlank()) {//isBlank тс что и isEmpty только
            // игнорирует пробелы
            return;
        }
        PlayChat.BullsAndCowsCount count =
                playChat.calculateBullsAndCows((answer));
        String text = String.format("%d. Введено число %s, " +
                                            "количество быков %d, " +
                                            "количество коров %d",
                                    ++step, answer, count.getBulls(),
                                    count.getCows());
        historyArea.appendText(text + "\n");
        userAnswer.clear();
        userAnswer.requestFocus();//курсор
        if (count.getBulls() == 4) {
            if (ifWantToPlayAgain()) {//хочет сыграть еще раз
                step = 0;
                historyArea.appendText("\n\n--- Начинаем новую игру" +
                                               " ---\n");
                this.playChat = new PlayChat();
            } else {
                System.exit(0);
            }


        }
    }

    private boolean ifWantToPlayAgain() {
        //всплывающее коно
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                                      "Моё" +
                                              " почтение, " +
                                              "Сударь. Выйгрыш " +
                                              "Ваш!!\n" +
                                              "Число " + playChat.getGuessNum() + " вычислили за " + step + " попыт(ку/ки/ок)\n" + "Желаете сыграть еще раз?",
                                      new ButtonType("Ага",
                                                     ButtonBar.ButtonData.YES),
                                      new ButtonType("Неа",
                                                     ButtonBar.ButtonData.NO)
        );
        alert.setTitle("Поздравляю!");
        final ButtonType answer = alert.showAndWait().get();
        return answer.getButtonData() == ButtonBar.ButtonData.YES;

    }

    public void clickNewGame() {//menu
        step = 0;
        historyArea.appendText("\n\n--- Начинаем новую игру" +
                                       " ---\n");
        this.playChat = new PlayChat();
    }

    public void clickExit(ActionEvent actionEvent) {//menu
        System.exit(0);
    }

    public void clickRules() {
       historyArea.appendText("Правила игры: Машина JAVA " +
                                      "загадала четырехзначное число.\n" +
                                      "Отгадай" +
                                      " 4 цифры " +
                                      "загаданные машиной JAVA.\n" +
                                      "При" +
                                      " угадывании места и цифры " +
                                      "подсказка выдаст быка,\nпри " +
                                      "угадывнии цифры не на своём " +
                                      "месте подсказка выдаст " +
                                      "корову.\n\nЖелаю удачи в " +
                                      "этой " +
                                      "битве!\n\n\n");
    }
}//10 step my result