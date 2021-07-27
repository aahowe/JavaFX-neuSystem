package System.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Random;

/**
 * @author wanghao
 */
public class Bed {
    private StringProperty id;
    private StringProperty number;
    private StringProperty floor;
    private StringProperty room;
    private StringProperty bed;
    private StringProperty startDate;
    private StringProperty endDate;
    private StringProperty status;
    private StringProperty idcode;
    private StringProperty location;
    private Patient patient;
    private Random ran = new Random();


    public Bed() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public Bed(Patient patient, String number, String floor, String room, String bed, String startDate, String endDate, String status, String idcode, String id) {
        this.number = new SimpleStringProperty(number);
        this.floor = new SimpleStringProperty(floor);
        this.room = new SimpleStringProperty(room);
        this.bed = new SimpleStringProperty(bed);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
        this.status = new SimpleStringProperty(status);
        this.patient = patient;
        this.id = new SimpleStringProperty(getran(5));
        this.idcode = new SimpleStringProperty(getran(7));
    }

    private String getran(int i) {
        if (i == 5) {
            Integer random = (int) (10000 * ran.nextDouble());
            return random.toString();
        }
        if (i == 7) {
            Integer random = (int) (1000000 * ran.nextDouble());
            return random.toString();
        }
        return null;
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public void setIdcode(String idcode) {
        this.idcode.setValue(idcode);
    }

    public void setRoom(String room) {
        this.room.setValue(room);
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setBed(String bed) {
        this.bed.set(bed);
    }

    public void setFloor(String floor) {
        this.floor.set(floor);
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }

    public void setEndDate(String endDate) {
        this.endDate.set(endDate);
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public Patient getPatient() {
        return patient;
    }

    public String getId() {
        return id.get();
    }

    public String getBed() {
        return bed.get();
    }

    public String getStartDate() {
        return startDate.get();
    }

    public String getEndDate() {
        return endDate.get();
    }

    public String getFloor() {
        return floor.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getRoom() {
        return room.get();
    }

    public String getIdcode() {
        return idcode.get();
    }

    public String getNumber() {
        return number.get();
    }

    public String getLocation() {
        return number.get() + "->" + floor.get() + "->" + room.get() + "->" + bed.get();
    }

    public StringProperty locationProperty() {
        this.location = new SimpleStringProperty(number.get() + "->" + floor.get() + "->" + room.get() + "->" + bed.get());
        return location;
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty numberProperty() {
        return number;
    }

    public StringProperty bedProperty() {
        return bed;
    }

    public StringProperty endDateProperty() {
        return endDate;
    }

    public StringProperty floorProperty() {
        return floor;
    }

    public StringProperty idcodeProperty() {
        return idcode;
    }

    public StringProperty roomProperty() {
        return room;
    }

    public StringProperty startDateProperty() {
        return startDate;
    }

    public StringProperty statusProperty() {
        return status;
    }

}
