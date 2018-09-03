package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

public class PersonView {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public PersonView() {
        personList.add(new Person("Pawel", "Powroznik", "kebabowa", "kebsoncity", "9863", "66985421"));
        personList.add(new Person("Pawe", "Powrozn", "kewa", "kebsoncity", "963", "525"));
        personList.add(new Person("Paw", "Powrnik", "kebab", "ksoncity", "63", "4578"));
        personList.add(new Person("Pal", "Poznik", "keaowa", "fsdf", "93", "525"));
    }
}
