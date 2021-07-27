package System.view.controller;

import System.model.Template;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;


/**
 * @author wanghao
 */
public class TemplateDetailsController {

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField id;

    @FXML
    private JFXTextField q1;

    @FXML
    private JFXTextField q2;

    @FXML
    private JFXTextField q3;

    @FXML
    private JFXTextField type;

    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void confirm(ActionEvent event) {
        dialogStage.close();
    }

    public void detail(Template template){
        id.setText(template.getId());
        name.setText(template.getName());
        type.setText(template.getType());
        q1.setText(template.getQ1().getText());
        q2.setText(template.getQ2().getText());
        q3.setText(template.getQ3().getText());
    }

}
