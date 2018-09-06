package com.sda.javafx.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.javafx.Main;
import com.sda.javafx.controller.NewPersonController;
import com.sda.javafx.controller.PersonController;
import com.sda.javafx.model.PersonInString;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.sda.javafx.model.Person;

import java.io.File;
import java.io.IOException;

public class PersonView {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    private VBox vBox;
    private Stage stage;

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public PersonView(Stage stage) {
        this.stage = stage;
        readPerson();

        /*personList.add(new Person("Pawel", "Powroznik", "kebabowa", "kebsoncity", "9863", "66985421"));
        personList.add(new Person("Pawe", "Powrozn", "kewa", "kebsoncity", "963", "525"));
        personList.add(new Person("Paw", "Powrnik", "kebab", "ksoncity", "63", "4578"));
        personList.add(new Person("Pal", "Poznik", "keaowa", "fsdf", "93", "525"));*/
    }

    public PersonView() {

    }

    public void loadEditWindow(Person person, int index) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/EditView.fxml"));
        VBox newEditView = null;
        try {
            newEditView = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage newEditStage = new Stage();
        Scene newEditScene = new Scene(newEditView);
        newEditStage.setScene(newEditScene);
        newEditStage.show();
        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);
        newPersonController.setSelectedIndex(index);
        newPersonController.setPerson(person);
        newPersonController.setFlag(false);


    }

    public void loadEditView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/EditView.fxml"));
        VBox newEditView = null;
        try {
            newEditView = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage newEditStage = new Stage();
        Scene newEditScene = new Scene(newEditView);
        newEditStage.setScene(newEditScene);
        newEditStage.show();
        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);
        newPersonController.setFlag(true);

    }

    public void loadView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/RootView.fxml"));
        try {
            vBox = (VBox) loader.load();
            Scene scene = new Scene(vBox);
            stage.setScene(scene);
            stage.show();

            PersonController personController = loader.getController();
            personController.setPersonView(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readPerson() {
        ObjectMapper objectMapper = new ObjectMapper();
        File filename = new File("PersonList.json");
        try {
            PersonInString[] readOrders = objectMapper.readValue(filename,PersonInString[].class);

            for (PersonInString p: readOrders){
                personList.add(new Person(p.getName(),p.getLastname(),p.getStreet(),p.getCity(),p.getPostalCode(),p.getTelephone()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
