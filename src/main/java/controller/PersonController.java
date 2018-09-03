package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Person;
import view.PersonView;

import javax.swing.text.TabableView;

public class PersonController {

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> nameCol;
    @FXML
    private TableColumn<Person, String> lastnameCol;
    //@FXML
    //private TableColumn<Person, String>

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
        System.out.println("to jest test");
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastnameCol.setCellValueFactory(cell -> cell.getValue().lastnameProperty());

    }
}
