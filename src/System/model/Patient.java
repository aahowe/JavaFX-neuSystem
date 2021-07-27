package System.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author wanghao
 */
public class Patient extends Person {
    private StringProperty sex;
    private StringProperty idcode;
    private StringProperty emergency;
    private StringProperty emerphone;

    public Patient() {
        this(null, null, null, null, null, null, null, null);
    }

    public Patient(String id, String name, String birthday, String phone, String sex, String idcode, String emergency, String emerphone) {
        super(id, name, birthday, phone);
        this.sex = new SimpleStringProperty(sex);
        this.idcode = new SimpleStringProperty(idcode);
        this.emergency = new SimpleStringProperty(emergency);
        this.emerphone = new SimpleStringProperty(emerphone);
    }

    public void setSex(String sex) {
        this.sex.setValue(sex);
    }

    public void setIdcode(String idcode) {
        this.idcode.setValue(idcode);
    }

    public void setEmergency(String emergency) {
        this.emergency.setValue(emergency);
    }

    public void setEmerphone(String emerphone) {
        this.emerphone.setValue(emerphone);
    }

    public String getSex() {
        return sex.get();
    }

    public String getIdcode() {
        return idcode.get();
    }

    public String getEmergency() {
        return emergency.get();
    }

    public String getEmerphone() {
        return emerphone.get();
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public StringProperty idcodeProperty() {
        return idcode;
    }

    public StringProperty emergencyProperty() {
        return emergency;
    }

    public StringProperty emerphoneProperty() {
        return emerphone;
    }

}
