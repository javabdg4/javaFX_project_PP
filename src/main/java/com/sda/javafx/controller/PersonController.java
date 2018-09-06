package com.sda.javafx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.javafx.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.sda.javafx.view.PersonView;

import java.io.File;
import java.io.IOException;

public class PersonController {

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> nameCol;
    @FXML
    private TableColumn<Person, String> lastnameCol;
    @FXML
    private TableColumn<Person, String> streetCol;

    @FXML
    private Label nameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label streetLable;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label telephoneLabel;

    private PersonView personView;

    public void setPersonView(PersonView personView) {
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    public void initialize(){
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastnameCol.setCellValueFactory(cell -> cell.getValue().lastnameProperty());
        streetCol.setCellValueFactory(cell -> cell.getValue().streetProperty());
        personTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldField, newField) -> viewPersonInfoOnLable(newField)
        );
    }
    public void viewPersonInfoOnLable(Person person){
        nameLabel.setText(person.getName());
        lastnameLabel.setText(person.getLastname());
        streetLable.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postalCodeLabel.setText(person.getPostalCode());
        telephoneLabel.setText(person.getTelephone());
    }

    public void handleNewButton(ActionEvent actionEvent) {
        personView.loadEditView();
    }

    public void handleEditButton(ActionEvent actionEvent) {

            Person selectPerson = personTableView.getSelectionModel().getSelectedItem();
            int index = personTableView.getSelectionModel().getFocusedIndex();

            personView.loadEditWindow(selectPerson, index);

    }

    public void handleSaveButton(ActionEvent actionEvent) {
        ObjectMapper objectMapper = new ObjectMapper();
        File filename = new File("PersonList.json");

        try {
            objectMapper.writeValue(filename, personView.getPersonList());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleDeleteButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if(alert.getResult()== ButtonType.YES){
            Person selectPerson = personTableView.getSelectionModel().getSelectedItem();
            personView.getPersonList().remove(selectPerson);
        }

    }
}
