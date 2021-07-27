package System.model;

import javafx.beans.property.*;


/**
 * @author howe
 */

public class Person {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty birthday;
    private final StringProperty phone;

    public Person() {
        this(null, null, null, null);
    }

    public Person(String id, String name, String birthday, String phone) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.birthday = new SimpleStringProperty(birthday);
        this.phone = new SimpleStringProperty(phone);
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setBirthday(String birthday) {
        this.birthday.setValue(birthday);
    }

    public void setPhone(String phone) {
        this.phone.setValue(phone);
    }

    public String getId() {
        return this.id.get();
    }

    public String getName() {
        return this.name.get();
    }

    public String getPhone() {
        return this.phone.get();
    }

    public String getBirthday() {
        return this.birthday.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty birthdayProperty() {
        return birthday;
    }

    public StringProperty phoneProperty() {
        return phone;
    }

}
