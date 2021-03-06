package System.view.controller;

import System.model.Bed;
import System.model.Patient;
import System.service.PaListWrapper;
import System.service.PatientService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author wanghao
 */
public class BedAEController implements Initializable {

    @FXML
    private JFXTextField status;

    @FXML
    private JFXTextField room;

    @FXML
    private JFXTextField floor;

    @FXML
    private JFXTextField number;

    @FXML
    private JFXDatePicker start;

    @FXML
    private JFXComboBox<String> patient;

    @FXML
    private JFXDatePicker end;

    @FXML
    private JFXTextField bedid;

    private boolean ok = false;
    private Bed bed;
    private Stage dialogStage;

    @FXML
    void cancel(ActionEvent event) {
        dialogStage.close();
    }

    @FXML
    void confirm(ActionEvent event) {
        if (isInputValid()) {
            ok = true;
            bed.setStatus(status.getText());
            bed.setNumber(number.getText());
            bed.setFloor(floor.getText());
            bed.setRoom(room.getText());
            bed.setBed(bedid.getText());
            bed.setStartDate(start.getEditor().getText());
            bed.setEndDate(end.getEditor().getText());
            PaListWrapper wrapper = PatientService.loadPa("src/System/data/patientlist.xml");
            assert wrapper != null;
            for (Patient i : wrapper.getPa()) {
                if (i.getName().equals(patient.getValue())){
                    bed.setPatient(i);
                }
            }
            dialogStage.close();
        }
    }

    public void add(Bed bed) {
        this.bed = bed;
    }

    public void edit(Bed bed) {
        this.bed = bed;
        patient.setValue(bed.getPatient().getName());
        status.setText(bed.getStatus());
        number.setText(bed.getNumber());
        start.getEditor().setText(bed.getStartDate());
        end.getEditor().setText(bed.getEndDate());
        floor.setText(bed.getFloor());
        room.setText(bed.getRoom());
        bedid.setText(bed.getBed());
        this.add(bed);
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (patient.getValue() == null) {
            errorMessage += "????????????!\n";
        }
        if (status.getText() == null || status.getText().length() == 0) {
            errorMessage += "????????????!\n";
        }
        if (number.getText() == null || number.getText().length() == 0) {
            errorMessage += "????????????!\n";
        }
        if (floor.getText() == null || floor.getText().length() == 0) {
            errorMessage += "????????????!\n";
        }
        if (room.getText() == null || room.getText().length() == 0) {
            errorMessage += "???????????????!\n";
        }
        if (start.toString() == null || start.toString().length() == 0) {
            errorMessage += "????????????!\n";
        }
        if (end.toString() == null || end.toString().length() == 0) {
            errorMessage += "????????????!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            ok = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("??????");
            alert.setHeaderText("?????????????????????????????????");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

    public boolean isOk() {
        return ok;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PaListWrapper wrapper = PatientService.loadPa("src/System/data/patientlist.xml");
        assert wrapper != null;
        ArrayList<String> name = new ArrayList<>();
        for (Patient i : wrapper.getPa()) {
            name.add(i.getName());
        }
        ObservableList<String> options =
                FXCollections.observableArrayList(name);
        patient.setItems(options);
    }

}
