module ru.gb.javafxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.gb.javafxapp to javafx.fxml;
    exports ru.gb.javafxapp;
    exports ru.gb.javafxapp.Chat;
    opens ru.gb.javafxapp.Chat to javafx.fxml;

}