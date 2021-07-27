package System.view.controller;

import System.model.Analysis;
import System.model.Patient;
import System.Main;
import System.model.Template;
import System.service.*;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXSpinner;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author wanghao
 */
public class AnalyzeController implements Initializable {

    @FXML
    private JFXComboBox<String> select;

    @FXML
    private Label q1;

    @FXML
    private Label q2;

    @FXML
    private Label q3;

    @FXML
    private JFXCheckBox q1c1;

    @FXML
    private Label q1a1;

    @FXML
    private JFXCheckBox q1c2;

    @FXML
    private Label q1a2;

    @FXML
    private JFXCheckBox q1c3;

    @FXML
    private Label q1a3;

    @FXML
    private JFXCheckBox q2c1;

    @FXML
    private Label q2a1;

    @FXML
    private JFXCheckBox q2c2;

    @FXML
    private Label q2a2;

    @FXML
    private JFXCheckBox q2c3;

    @FXML
    private Label q2a3;

    @FXML
    private JFXCheckBox q3c1;

    @FXML
    private Label q3a1;

    @FXML
    private JFXCheckBox q3c2;

    @FXML
    private Label q3a2;

    @FXML
    private JFXCheckBox q3c3;

    @FXML
    private Label q3a3;

    @FXML
    private JFXSpinner loading;

    private Stage dialogStage;
    private Analysis analysis = new Analysis();
    private Template template;
    private Patient patient;
    private Integer score = 0;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void comfirm(ActionEvent event) throws IOException {
        if (!isValid()) {
            return;
        }
        loading.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(1));
        pauseTransition.setOnFinished(ev -> {
            if (AnalysisService.loadAnalysis("src/System/data/analysislist.xml") == null) {
                Analysis analysis = new Analysis();
                AnalysisWrapper wrapper = new AnalysisWrapper();
                ObservableList<Analysis> list = FXCollections.observableArrayList();
                list.add(analysis);
                wrapper.setAnalysis(list);
                AnalysisService.saveAnalysis(wrapper, "src/System/data/analysislist.xml");
            }
            analysis.setAperson(Main.using.getName());
            analysis.setTime(LocalDateTime.now().toString());
            analysis.setName(patient.getName());
            analysis.setAdvice(getAdvice());
            analysis.setSex(patient.getSex());
            analysis.setTname(template.getName());
            analysis.setTtype(template.getType());
            AnalysisWrapper wrapper = AnalysisService.loadAnalysis("src/System/data/analysislist.xml");
            assert wrapper != null;
            wrapper.getAnalysis().add(analysis);
            AnalysisService.saveAnalysis(wrapper, "src/System/data/analysislist.xml");


            dialogStage.close();
        });
        pauseTransition.play();
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    String getAdvice() {
        if (q1c1.isSelected()) {
            score += 5;
        } else if (q1c2.isSelected()) {
            score += 3;
        } else if (q1c3.isSelected()) {
            score += 1;
        }
        if (q2c1.isSelected()) {
            score += 5;
        } else if (q2c2.isSelected()) {
            score += 3;
        } else if (q2c3.isSelected()) {
            score += 1;
        }
        if (q3c1.isSelected()) {
            score += 5;
        } else if (q3c2.isSelected()) {
            score += 3;
        } else if (q3c3.isSelected()) {
            score += 1;
        }
        if (score <= 5) {
            return "差";
        } else if (score < 13) {
            return "良好";
        } else if (score <= 15) {
            return "优秀";
        }
        return null;
    }

    @FXML
    void select(ActionEvent event) {
        TemplateWrapper wrapper = TemplateService.loadTemplate("src/System/data/templatelist.xml");
        assert wrapper != null;
        for (Template i : wrapper.getTemplate()) {
            if (i.getName().equals(select.getValue())) {
                template = i;
                q1.setText(i.getQ1().getText());
                q2.setText(i.getQ2().getText());
                q3.setText(i.getQ3().getText());
                q1a1.setText(i.getQ1().getA1());
                q1a2.setText(i.getQ1().getA2());
                q1a3.setText(i.getQ1().getA3());
                q2a1.setText(i.getQ2().getA1());
                q2a2.setText(i.getQ2().getA2());
                q2a3.setText(i.getQ2().getA3());
                q3a1.setText(i.getQ3().getA1());
                q3a2.setText(i.getQ3().getA2());
                q3a3.setText(i.getQ3().getA3());
                break;
            }
        }
    }

    private boolean isValid() {
        String errorMessage = "";

        if (select.getValue() == null) {
            errorMessage += "未选择模板!\n";
        }
        if (!(q1c1.isSelected() || q1c2.isSelected() || q1c3.isSelected())) {
            errorMessage += "问题一未选择答案!\n";
        }
        if (!(q2c1.isSelected() || q2c2.isSelected() || q2c3.isSelected())) {
            errorMessage += "问题二未选择答案!\n";
        }
        if (!(q3c1.isSelected() || q3c2.isSelected() || q3c3.isSelected())) {
            errorMessage += "问题三未选择答案!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("错误");
            alert.setHeaderText("请检查以下信息是否正确");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    void q1c1(ActionEvent event) {
        q1c2.setSelected(false);
        q1c3.setSelected(false);
    }

    @FXML
    void q1c2(ActionEvent event) {
        q1c1.setSelected(false);
        q1c3.setSelected(false);
    }

    @FXML
    void q1c3(ActionEvent event) {
        q1c1.setSelected(false);
        q1c2.setSelected(false);
    }

    @FXML
    void q2c1(ActionEvent event) {
        q2c2.setSelected(false);
        q2c3.setSelected(false);
    }

    @FXML
    void q2c2(ActionEvent event) {
        q2c1.setSelected(false);
        q2c3.setSelected(false);
    }

    @FXML
    void q2c3(ActionEvent event) {
        q2c1.setSelected(false);
        q2c2.setSelected(false);
    }

    @FXML
    void q3c1(ActionEvent event) {
        q3c3.setSelected(false);
        q3c2.setSelected(false);
    }

    @FXML
    void q3c2(ActionEvent event) {
        q3c1.setSelected(false);
        q3c3.setSelected(false);
    }

    @FXML
    void q3c3(ActionEvent event) {
        q3c1.setSelected(false);
        q3c2.setSelected(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loading.setVisible(false);
        //
        TemplateWrapper wrapper = TemplateService.loadTemplate("src/System/data/templatelist.xml");
        assert wrapper != null;
        ArrayList<String> name = new ArrayList<>();
        for (Template i : wrapper.getTemplate()) {
            name.add(i.getName());
        }
        ObservableList<String> options =
                FXCollections.observableArrayList(name);
        select.setItems(options);
        //
    }
}
