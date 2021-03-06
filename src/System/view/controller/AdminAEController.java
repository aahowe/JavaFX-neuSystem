package System.view.controller;


import System.model.Administrator;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;


/**
 * @author wanghao
 */
public class AdminAEController implements Initializable {

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField spcialty;

    @FXML
    private JFXComboBox<String> jobtitle;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXDatePicker birthday;

    private boolean ok = false;
    private Administrator adm;
    private Stage dialogStage;
    private int choice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void confirm() {
        if (isInputValid()) {
            ok = true;
            adm.setId(id.getText());
            adm.setName(name.getText());
            adm.setJobtitle(jobtitle.getValue());
            adm.setPassword(password.getText());
            adm.setBirthday(birthday.getEditor().getText());
            adm.setSpecialty(spcialty.getText());
            adm.setPhone(phone.getText());
            dialogStage.close();
        }
    }

    public void cancel() {
        dialogStage.close();
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void add(Administrator adm) {
        ObservableList<String> options = null;
        switch (choice) {
            case 1:
                options = FXCollections.observableArrayList("??????");
                break;
            case 2:
                options = FXCollections.observableArrayList("??????");
                break;
            case 3:
                options = FXCollections.observableArrayList("??????");
                break;
            default:
                break;
        }
        jobtitle.setItems(options);
        this.adm = adm;
    }

    public void edit(Administrator adm) {
        this.adm = adm;
        id.setText(adm.getId());
        name.setText(adm.getName());
        birthday.getEditor().setText(adm.getBirthday());
        spcialty.setText(adm.getSpecialty());
        jobtitle.setValue(adm.getJobtitle());
        phone.setText(adm.getPhone());
        password.setText(adm.getPassword());
        this.add(adm);
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (id.getText() == null || id.getText().length() == 0) {
            errorMessage += "???????????????!\n";
        }
        if (name.getText() == null || name.getText().length() == 0) {
            errorMessage += "????????????!\n";
        }
        if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "????????????\n";
        }
        if (jobtitle.getValue() == null || jobtitle.getValue().length() == 0) {
            errorMessage += "????????????!\n";
        }
        if (phone.getText() == null || phone.getText().length() == 0) {
            errorMessage += "??????????????????!\n";
        } else {
            try {
                Long.parseLong(phone.getText());
            } catch (NumberFormatException e) {
                errorMessage += "???????????????????????????!\n";
            }
        }
        if (birthday.toString() == null || birthday.toString().length() == 0) {
            errorMessage += "????????????!\n";
        }
        if (spcialty.getText() == null || spcialty.getText().length() == 0) {
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

}