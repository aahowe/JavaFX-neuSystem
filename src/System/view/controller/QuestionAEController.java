package System.view.controller;

import System.model.Question;
import com.jfoenix.controls.JFXComboBox;
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
public class QuestionAEController implements Initializable {

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField a2;

    @FXML
    private JFXTextField a1;

    @FXML
    private JFXTextField text;

    @FXML
    private JFXComboBox<String> type;

    @FXML
    private JFXTextField a3;

    private boolean ok = false;
    private Question question;
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
            question.setText(text.getText());
            question.setId(id.getText());
            question.setA1(a1.getText());
            question.setA2(a2.getText());
            question.setA3(a3.getText());
            question.setType(type.getValue());
            dialogStage.close();
        }
    }

    public void add(Question question) {
        this.question = question;
    }

    public void edit(Question question) {
        this.question = question;
        id.setEditable(false);
        id.setText(question.getId());
        text.setText(question.getText());
        type.setValue(question.getType());
        a1.setText(question.getA1());
        a2.setText(question.getA2());
        a3.setText(question.getA3());
        this.add(question);
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (id.getText() == null || id.getText().length() == 0) {
            errorMessage += "非法ID!\n";
        }
        if (text.getText() == null || text.getText().length() == 0) {
            errorMessage += "非法问题!\n";
        }
        if (type.getValue() == null || type.getValue().length() == 0) {
            errorMessage += "非法类型!\n";
        }
        if (a1.getText() == null || a1.getText().length() == 0 || a2.getText() == null || a2.getText().length() == 0 || a3.getText() == null || a3.getText().length() == 0) {
            errorMessage += "非法答案!\n";
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
                        "A",
                        "B"
                );
        type.setItems(options);
    }

}