package System.view.controller;

import System.Main;
import System.service.AdministratorService;
import com.jfoenix.controls.*;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


/**
 * @author wanghao
 */
public class LoginController implements Initializable {
    @FXML
    private AnchorPane login;
    @FXML
    private JFXTextField idField;
    @FXML
    private JFXPasswordField pwdField;
    @FXML
    private StackPane stackPane;
    @FXML
    private JFXSpinner logining;

    private static final String ADMIN = "admin";
    private static final String PWD = "123456";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logining.setVisible(false);
    }

    @FXML
    private void loginAction() {
        String username = idField.getText();
        String password = pwdField.getText();
        if (username.isEmpty() || password.isEmpty()) {
            logining.setVisible(false);
            JFXDialogLayout content = new JFXDialogLayout();
            Text title = new Text("错误");
            title.setFont(new Font(20));
            content.setHeading(title);
            content.setBody(new Text("用户名或密码未输入\n" +
                    "请重新输入"));
            JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
            JFXButton button = new JFXButton("关闭");
            button.setOnAction(event -> dialog.close());
            content.setActions(button);
            dialog.show();
            return;
        }
        logining.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(1));
        pauseTransition.setOnFinished(ev -> {
            try {
                login();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pauseTransition.play();
    }

    public void login() throws IOException {
        logining.setVisible(false);
        String username = idField.getText();
        String password = pwdField.getText();
        try {
            AnchorPane user;
            if (ADMIN.equals(username) && PWD.equals(password)) {
                user = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("../fxml/Admin.fxml"))));
                login.getChildren().setAll(user);
            } else if (AdministratorService.login(username, password) != null) {
                Main.using = AdministratorService.login(username, password);
                user = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("../fxml/Doctor.fxml"))));
                login.getChildren().setAll(user);
            } else {
                JFXDialogLayout content = new JFXDialogLayout();
                Text title = new Text("错误");
                title.setFont(new Font(20));
                content.setHeading(title);
                content.setBody(new Text("用户名或密码错误\n" +
                        "请重新输入"));
                JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
                JFXButton button = new JFXButton("关闭");
                button.setOnAction(event -> dialog.close());
                content.setActions(button);
                dialog.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

