package System.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author wanghao
 */
public class Analysis {
    private StringProperty aperson;
    private StringProperty advice;
    private StringProperty time;
    private StringProperty tname;
    private StringProperty ttype;
    private StringProperty name;
    private StringProperty sex;

    public Analysis() {
        this(null, null, null, null, null, null, null);
    }

    private Analysis(String aperson, String advice, String time, String tname, String ttype, String name, String sex) {
        this.aperson = new SimpleStringProperty(aperson);
        this.advice = new SimpleStringProperty(advice);
        this.time = new SimpleStringProperty(time);
        this.tname = new SimpleStringProperty(tname);
        this.sex = new SimpleStringProperty(sex);
        this.ttype = new SimpleStringProperty(ttype);
        this.name = new SimpleStringProperty(name);
    }

    public void setAdvice(String advice) {
        this.advice.set(advice);
    }

    public void setAperson(String aperson) {
        this.aperson.set(aperson);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public void setTname(String tname) {
        this.tname.set(tname);
    }

    public void setTtype(String ttype) {
        this.ttype.set(ttype);
    }

    public String getAdvice() {
        return advice.get();
    }

    public String getAperson() {
        return aperson.get();
    }

    public String getName() {
        return name.get();
    }

    public String getSex() {
        return sex.get();
    }

    public String getTime() {
        return time.get();
    }

    public String getTname() {
        return tname.get();
    }

    public String getTtype() {
        return ttype.get();
    }

    public StringProperty adviceProperty() {
        return advice;
    }

    public StringProperty apersonProperty() {
        return aperson;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public StringProperty timeProperty() {
        return time;
    }

    public StringProperty tnameProperty() {
        return tname;
    }

    public StringProperty ttypeProperty() {
        return ttype;
    }

}
