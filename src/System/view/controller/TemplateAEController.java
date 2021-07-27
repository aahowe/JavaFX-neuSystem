package System.view.controller;

import System.model.Question;
import System.model.Template;
import System.service.QuestionService;
import System.service.QuestionWrapper;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author wanghao
 */
public class TemplateAEController implements Initializable {

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXComboBox<String> q1;

    @FXML
    private JFXComboBox<String> q2;

    @FXML
    private JFXComboBox<String> q3;

    @FXML
    private JFXComboBox<String> type;

    private boolean ok = false;
    private Template template;
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
            template.setId(id.getText());
            template.setName(name.getText());
            template.setType(type.getValue());
            QuestionWrapper wrapper = QuestionService.loadQuestion("src/System/data/questionlist.xml");
            assert wrapper != null;
            for (Question i : wrapper.getQuestion()) {
                if (i.getText().equals(q1.getValue())) {
                    template.setQ1(i);
                } else if (i.getText().equals(q2.getValue())) {
                    template.setQ2(i);
                } else if (i.getText().equals(q3.getValue())) {
                    template.setQ3(i);
                }
            }
            dialogStage.close();
        }
    }

    public void add(Template template) {
        this.template = template;
    }

    public void edit(Template template) {
        this.template = template;
        id.setText(template.getId());
        name.setText(template.getName());
        type.setValue(template.getType());
        q1.setValue(template.getQ1().getText());
        q2.setValue(template.getQ2().getText());
        q3.setValue(template.getQ3().getText());
        this.add(template);
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (id.getText() == null || id.getText().length() == 0) {
            errorMessage += "非法ID!\n";
        }
        if (name.getText() == null || name.getText().length() == 0) {
            errorMessage += "非法名称!\n";
        }
        if (type.getValue() == null || type.getValue().length() == 0) {
            errorMessage += "非法类型!\n";
        }
        if (q1.getValue() == null || q1.getValue().length() == 0 || q2.getValue() == null || q2.getValue().length() == 0 || q3.getValue() == null || q3.getValue().length() == 0) {
            errorMessage += "非法问题!\n";
        }
        if (q1.getValue().equals(q2.getValue()) || q1.getValue().equals(q3.getValue()) || q2.getValue().equals(q3.getValue())){
            errorMessage += "问题重复!\n";
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
        QuestionWrapper wrapper = QuestionService.loadQuestion("src/System/data/questionlist.xml");
        assert wrapper != null;
        ArrayList<String> name = new ArrayList<>();
        for (Question i : wrapper.getQuestion()) {
            name.add(i.getText());
        }
        ObservableList<String> options =
                FXCollections.observableArrayList(name);
        q1.setItems(options);
        q2.setItems(options);
        q3.setItems(options);
        ObservableList<String> options1 =
                FXCollections.observableArrayList(
                        "A",
                        "B"
                );
        type.setItems(options1);
    }
}
