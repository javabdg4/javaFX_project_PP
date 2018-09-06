package com.sda.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import com.sda.javafx.view.PersonView;


public class Main extends Application {

    private Stage stage;
    private PersonView personView;

    public static void main(String[] args) {

        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        personView = new PersonView(this.stage);
        personView.loadView();
    }


}
