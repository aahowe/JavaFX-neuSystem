package System.model;

import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author wanghao
 */
public class Question {
    private StringProperty id;
    private StringProperty text;
    private StringProperty a1;
    private StringProperty a2;
    private StringProperty a3;
    private StringProperty type;

    public Question() {
        this(null, null, null, null, null, null);
    }

    public Question(String id, String text, String a1, String a2, String a3, String type) {
        this.id = new SimpleStringProperty(id);
        this.text = new SimpleStringProperty(text);
        this.a1 = new SimpleStringProperty(a1);
        this.a2 = new SimpleStringProperty(a2);
        this.a3 = new SimpleStringProperty(a3);
        this.type = new SimpleStringProperty(type);
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public void setA1(String a1) {
        this.a1.setValue(a1);
    }

    public void setA2(String a2) {
        this.a2.setValue(a2);
    }

    public void setA3(String a3) {
        this.a3.setValue(a3);
    }

    public void setType(String type) {
        this.type.setValue(type);
    }

    public String getId() {
        return id.get();
    }

    public String getA1() {
        return a1.get();
    }

    public String getA2() {
        return a2.get();
    }

    public String getA3() {
        return a3.get();
    }

    public String getText() {
        return text.get();
    }

    public String getType() {
        return type.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty a1Property() {
        return a1;
    }

    public StringProperty a2Property() {
        return a2;
    }

    public StringProperty a3Property() {
        return a3;
    }

    public StringProperty textProperty() {
        return text;
    }

    public StringProperty typeProperty() {
        return type;
    }
}
