package System.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * @author howe
 */

public class Administrator extends Person {
    private StringProperty specialty;
    private StringProperty jobtitle;
    private StringProperty password;

    public Administrator(){
        this(null,null,null,null,null,null,null);
    }

    public Administrator(String id, String name, String birthday, String phone, String specialty, String jobtitle, String password) {
        super(id, name, birthday, phone);
        this.specialty = new SimpleStringProperty(specialty);
        this.jobtitle = new SimpleStringProperty(jobtitle);
        this.password = new SimpleStringProperty(password);
    }

    public void setSpecialty(String specialty) {
        this.specialty.setValue(specialty);
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle.setValue(jobtitle);
    }

    public void setPassword(String password) {
        this.password.setValue(password);
    }

    public String getSpecialty() {
        return specialty.get();
    }

    public String getJobtitle() {
        return jobtitle.get();
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty specialtyProperty() {
        return specialty;
    }

    public StringProperty jobtitleProperty() {
        return jobtitle;
    }

    public StringProperty passwordProperty() {
        return password;
    }
}
