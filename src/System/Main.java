package System;

import System.model.Administrator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * @author wanghao
 */
public class Main extends Application {
    /** 这个primaryStage当做全局变量用 */
    public static Stage primaryStage;
    /** 第二舞台， 用于放置其他功能 */
    public static Stage secondStage = new Stage();

    public static Administrator using;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 第二舞台设置为模态窗口
        secondStage.initModality(Modality.APPLICATION_MODAL);
        Main.primaryStage = primaryStage;
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("./view/fxml/Login.fxml")));
        Scene scene = new Scene(parent);

        primaryStage.setTitle("东软颐养社区中心系统");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
