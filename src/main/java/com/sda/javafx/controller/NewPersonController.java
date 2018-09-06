package com.sda.javafx.controller;

import com.sda.javafx.model.Person;
import com.sda.javafx.view.PersonView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPersonController {

    boolean flag;


    @FXML
    private TextField name;

    @FXML
    private TextField lastname;

    @FXML
    private TextField street;

    @FXML
    private TextField city;

    @FXML
    private TextField postalCode;

    @FXML
    private TextField telephone;

    @FXML
    private Button closeButton;

    @FXML
    private Button saveButton;

    private PersonView personView;
    private int index;


    public void handleSaveButton(javafx.event.ActionEvent actionEvent) {

            Person person = new Person(name.getText(), lastname.getText(), street.getText(),
                    city.getText(), postalCode.getText(), telephone.getText());

            if (flag) {
                personView.getPersonList().add(person);
            }
            if (!flag) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    personView.getPersonList().set(index, person);
                }

            }

            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();



    }

    public void handleCancelButton(ActionEvent actionEvent) {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

    public void setPerson(Person person) {
        name.setText(person.getName());
        lastname.setText(person.getLastname());
        street.setText(person.getStreet());
        city.setText(person.getCity());
        postalCode.setText(person.getPostalCode());
        telephone.setText(person.getTelephone());
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setSelectedIndex(int index) {
        this.index = index;
    }
}
