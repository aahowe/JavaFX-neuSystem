package System.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * @author wanghao
 */
public class Template {
    private StringProperty id;
    private StringProperty name;
    private StringProperty type;
    private Question q1;
    private Question q2;
    private Question q3;

    public Template() {
        this(null, null, null, null, null, null);
    }

    public Template(String id, String name, String type, Question q1, Question q2, Question q3) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    public void setQ1(Question q1) {
        this.q1 = q1;
    }

    public void setQ2(Question q2) {
        this.q2 = q2;
    }

    public void setQ3(Question q3) {
        this.q3 = q3;
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setType(String type) {
        this.type.setValue(type);
    }

    public String getType() {
        return type.get();
    }

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public Question getQ1() {
        return q1;
    }

    public Question getQ2() {
        return q2;
    }

    public Question getQ3() {
        return q3;
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty typeProperty() {
        return type;
    }
}
