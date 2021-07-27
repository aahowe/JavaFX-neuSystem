package System.view.controller;

import System.model.Patient;
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
import java.util.ResourceBundle;

/**
 * @author wanghao
 */
public class PatientAEController implements Initializable {

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField ephone;

    @FXML
    private JFXTextField idcode;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXDatePicker birthday;

    @FXML
    private JFXTextField eperson;

    @FXML
    private JFXComboBox<String> sex;

    private boolean ok = false;
    private Patient patient;
    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void cancel(ActionEvent event) {
        dialogStage.close();
    }

    @FXML
    void confirm(ActionEvent event) {
        if (isInputValid()) {
            ok = true;
            patient.setName(name.getText());
            patient.setSex(sex.getValue());
            patient.setEmergency(eperson.getText());
            patient.setEmerphone(ephone.getText());
            patient.setBirthday(birthday.getEditor().getText());
            patient.setIdcode(idcode.getText());
            patient.setPhone(phone.getText());
            dialogStage.close();
        }
    }

    public void add(Patient patient) {
        this.patient = patient;
    }

    public void edit(Patient patient) {
        idcode.setEditable(false);
        this.patient = patient;
        idcode.setText(patient.getIdcode());
        name.setText(patient.getName());
        birthday.getEditor().setText(patient.getBirthday());
        ephone.setText(patient.getEmerphone());
        eperson.setText(patient.getEmergency());
        phone.setText(patient.getPhone());
        sex.setValue(patient.getSex());
        this.add(patient);
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (idcode.getText() == null || idcode.getText().length() == 0) {
            errorMessage += "非法身份证!\n";
        }
        if (name.getText() == null || name.getText().length() == 0) {
            errorMessage += "非法姓名!\n";
        }
        if (phone.getText() == null || phone.getText().length() == 0) {
            errorMessage += "非法电话号码!\n";
        } else {
            try {
                Long.parseLong(phone.getText());
            } catch (NumberFormatException e) {
                errorMessage += "电话号码必须是数字!\n";
            }
        }
        if (ephone.getText() == null || ephone.getText().length() == 0) {
            errorMessage += "非法电话号码!\n";
        } else {
            try {
                Long.parseLong(phone.getText());
            } catch (NumberFormatException e) {
                errorMessage += "电话号码必须是数字!\n";
            }
        }
        if (birthday.toString() == null || birthday.toString().length() == 0) {
            errorMessage += "非法生日!\n";
        }
        if (eperson.getText() == null || eperson.getText().length() == 0) {
            errorMessage += "非法紧急联系人!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            ok = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("错误");
            alert.setHeaderText("请检查以下信息是否正确");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    public boolean isOk() {
        return ok;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "男",
                        "女"
                );
        sex.setItems(options);
    }
}
